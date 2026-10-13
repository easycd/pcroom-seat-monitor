# 공개 저장소 전환 전 설정·인증정보 조사

공개용 소스 정리: 실제 Firebase 설정은 Git 추적에서 제외하고 로컬에 보존했다. 네이버 지도 ID는 무시되는 `information/local.properties`로 옮겼으며 Manifest에는 placeholder만 남겼다. `.gitignore`와 README도 갱신했다. 아래의 발견 내역과 과거 커밋 설명은 정리 전 저장소의 조사 기록이다. 공개용 브랜치는 이전 커밋을 부모로 갖지 않는 새 이력으로 준비했다.

조사일: 2026-10-13 (한국 시간). 현재 checkout과 로컬에서 접근 가능한 Git 커밋 4개를 조사했다. 키의 실제 값은 재출력하지 않았다. 서버 설정과 키의 유효성은 확인하지 않았다.

## 현재 발견한 항목

| 위치 | 내용 | 판단 및 권장 처리 |
|---|---|---|
| information/app/src/google-services.json | Firebase API 키, 프로젝트/앱 식별자, DB·Storage 주소, OAuth 클라이언트 정보 | Firebase 클라이언트 설정이며 관리자 비밀키가 아니다. 공개용 포트폴리오에서는 실제 설정 파일을 추적에서 제외하고 본인 설정을 넣는 방법을 안내하는 것을 권장 |
| seat_information3/app/google-services.json | Firebase API 키와 클라이언트 설정 | 위와 동일 |
| information/app/src/main/AndroidManifest.xml:62 | 네이버 지도 Client ID | Client Secret이 아닌 앱용 ID다. Manifest 전체를 제외하지 말고 실제 값만 로컬 설정 또는 환경변수로 분리 |
| .gitignore | 빌드 생성물, local.properties, IDE 파일, 서명 키, .env 제외 | 기본 제외는 이미 존재. Firebase 설정 파일과 서비스 계정 파일에 대한 규칙은 없음 |

현재 추적 파일과 접근 가능한 이력에서 서비스 계정 private key, GitHub 토큰, AWS 액세스 키, 서명 비밀번호의 흔한 패턴은 발견하지 못했다. 패턴 검색은 모든 형태의 비밀정보 부재를 보증하지 않는다.

Firebase 설정의 API 키는 Firebase용 식별자이며 데이터 접근 권한을 부여하는 관리자 키가 아니다. DB 보호는 Security Rules로 수행한다. 다른 Google Cloud API에도 사용할 수 있는 키라면 해당 API 제한을 확인해야 한다. 클라이언트 설정을 저장소에서 제외하더라도 APK에 포함되는 값은 추출될 수 있다. [Firebase API 키 공식 안내](https://firebase.google.com/docs/projects/api-keys)

네이버 지도 SDK는 앱에 Client ID를 지정하고 콘솔에 Android 패키지 이름을 등록하는 구조다. Client Secret을 Android 앱에 넣으면 안 된다. 현재 코드에서는 Client Secret을 발견하지 못했다. 현재 프로젝트의 구버전 SDK 설정은 유지하면서 값만 분리하는 것이 적절하다. [네이버 지도 SDK 공식 안내](https://navermaps.github.io/android-map-sdk/guide-ko/1.html)

## 추가할 만한 .gitignore 규칙

아래는 공개용 소스에서 실제 프로젝트 설정을 분리하기 위한 제안이며, 이번 조사에서 적용하지 않았다.

```gitignore
# Actual Firebase Android client configuration
**/google-services.json

# Firebase / Google Cloud administrator credentials
**/*firebase-adminsdk*.json
**/service-account*.json
**/serviceAccount*.json

# Local signing / secret settings
**/keystore.properties
**/secrets.properties
**/*.key
**/*.pfx

# Local logs / crash dumps
*.log
*.hprof
```

`*.json` 전체를 제외하면 필요한 데이터·설정까지 빠지므로 사용하지 않는다. 서비스 계정 파일 이름은 임의로 정할 수 있으므로 위 패턴만으로 모든 서비스 계정 파일을 막을 수는 없다. 인증정보를 넣는 위치와 파일 이름을 정해 관리해야 한다.

기존 규칙으로 이미 제외되는 항목은 `**/build/`, `**/.gradle/`, `**/local.properties`, `**/.idea/`, `*.iml`, `.vscode/`, `*.apk`, `*.aab`, `*.jks`, `*.keystore`, `*.p12`, `*.pem`, `.env`, `.env.*`다. `.env.example`은 실제 값 없이 예시만 넣어 공개할 수 있다.

Gradle Wrapper JAR·스크립트, build.gradle, settings.gradle, gradle.properties의 현재 비밀정보 없는 내용, AndroidManifest.xml, 소스·리소스, 문서는 계속 추적해야 한다. 현재 gradle.properties는 JVM/AndroidX 설정이며 비밀정보가 없다. 향후 토큰·비밀번호를 추가하면 해당 값만 로컬 설정으로 옮겨야 한다.

## 실제 설정을 제외할 때 필요한 변경

1. `.gitignore`에 실제 Firebase 설정 파일 패턴을 추가한다.
2. 이미 추적 중인 두 파일은 `git rm --cached`로 추적만 해제한다. 로컬 파일은 남긴다.
3. 이용자 앱의 설정 파일은 빌드에 맞게 `information/app/google-services.json`으로 배치한다. 현재 `app/src/` 위치는 별도 빌드 문제다.
4. 네이버 Manifest 값을 `${NAVER_MAP_CLIENT_ID}` 같은 placeholder로 바꾸고 Gradle에서 무시되는 local.properties 또는 환경변수 값을 주입한다. Manifest 자체는 Git에 남긴다.
5. README에는 Firebase 설정 다운로드·배치 및 지도 ID 입력 방법만 기록한다. 예시 파일에는 실사용 키나 DB 주소를 복사하지 않는다.

Git 추적 해제, 앱 설정 수정, 커밋, push, 원격 공개 설정 변경은 이번 조사에서 실행하지 않았다.

## 과거 커밋 주의

현재 두 Firebase 설정 파일과 지도 ID는 최초 커밋부터 접근 가능한 4개 커밋 모두에 존재한다. 다음 커밋에서 삭제하거나 `.gitignore`에 추가해도 과거 커밋에서는 볼 수 있다.

실제 비밀키가 발견되면 먼저 폐기·재발급해야 한다. 현재 발견된 클라이언트 식별자만으로 관리자 비밀키 유출을 단정하거나 전부 재발급할 필요는 없다. 키의 허용 API, Firebase DB 규칙, 지도 앱 등록 제한을 먼저 확인해야 한다.

과거의 실제 설정 값까지 공개하지 않으려면 별도의 이력 정리가 필요하다. 기존 저장소의 이력을 재작성하면 커밋 해시와 다른 clone에 영향을 주므로 일반 push 준비와 구분해야 한다. 과거 이력 없는 새 공개 저장소에 정리된 파일만 최초 커밋하는 방법도 있다. [GitHub 민감정보 제거 안내](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/removing-sensitive-data-from-a-repository)

## 공개 전 서버에서 확인할 항목

- Firebase Realtime Database 규칙: 좌석 쓰기가 관리자에게만 허용되는지, 리뷰·게시판의 값 및 권한 검증이 있는지. 현재 앱 코드에 로그인 흐름과 서버 규칙 파일이 없어 확인할 수 없다.
- Google Cloud API 키 제한: 필요한 Firebase API로 제한되어 있는지, 불필요한 유료 API 호출에 사용할 수 있는지.
- 네이버 지도 설정: 등록 Android 패키지와 허용 서비스, 사용량 제한 및 현재 사용 상태.

이 항목들은 실제 발견된 앱 설정에 대한 확인 사항이며 서버를 변경하거나 DB에 시험 요청을 보내지는 않았다.
