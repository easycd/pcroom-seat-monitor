# pcroom-seat-monitor — PC방 정보 및 실시간 좌석 현황 앱

PC방의 매장 정보와 좌석 현황을 확인하고, 게임 정보·이벤트·게시판을 함께 이용할 수 있도록 만든 Android 캡스톤 디자인 프로젝트입니다.

이용자용 앱과 좌석 정보 전달 앱을 별도로 구성하고, **Firebase Realtime Database를 통해 60개 좌석의 상태를 공유**합니다. 좌석 정보 전달 앱에서 사용 여부를 변경하면 이용자 앱의 좌석 배치도와 이용 가능한 좌석 수에 반영됩니다.

## 프로젝트 소개

| 항목 | 내용 |
|---|---|
| 프로젝트 | `pcroom-seat-monitor` — PC방 정보 및 실시간 좌석 현황 앱 |
| 제작 배경 | 대학교 졸업작품 |
| 제작자 | 김재원, 강현민 |
| 플랫폼 | Android |
| 개발 언어 | Java, XML |
| 개발 도구 | Android Studio |
| 지도 API | 네이버 지도 API (NAVER Maps Android SDK) |
| 백엔드 서비스 | Firebase Realtime Database |
| 구성 | 이용자용 앱 `information`, 좌석 정보 전달 앱 `seat_information3` |

이 문서는 앱 소개서의 기능 설명과 현재 저장소의 소스 코드를 함께 확인하여 작성했습니다. 구현 현황은 현재 소스 기준이며, 공모전 수상 여부나 배포 이력은 확인하지 않았습니다.

## 주요 기능

### 이용자용 앱

- **메인 화면**: PC방 목록, 매장별 간단한 정보, 이벤트 이미지 슬라이드, 주요 기능 바로가기와 하단 메뉴를 제공합니다.
- **실시간 좌석 현황**: 나사렛 피시방의 60개 좌석을 배치도로 표시하고 사용 중인 좌석과 이용 가능한 좌석을 집계합니다.
- **PC방 지도**: 네이버 지도에 매장 6곳의 위치·이름·요금을 표시합니다. 현재 위치와 지도 확대·축소 컨트롤을 제공합니다.
- **매장 상세 정보**: 주소, 이용 요금, PC 사양, 매장 안내와 음식 메뉴를 표시합니다. 음식 메뉴는 종류별로 접고 펼칠 수 있습니다.
- **리뷰**: 작성한 내용을 Firebase에 저장하고 리뷰 목록의 변경을 받아 표시합니다.
- **자유게시판**: 하단 패널에서 글을 작성하고 Firebase에 저장된 게시글을 조회합니다.
- **공지사항**: Firebase에 저장된 공지 내용을 조회합니다.
- **이벤트**: 진행 중인 이벤트와 종료된 이벤트 화면을 전환합니다.
- **전적 검색 사이트**: OP.GG, FOW.kr, DAK.GG를 WebView로 표시하도록 구성했습니다.
- **게임 정보**: 인벤 웹사이트를 WebView로 표시합니다.
- **즐겨찾기 화면**: 매장 상세의 하트 토글과 즐겨찾기 목록 화면이 있습니다. 저장 및 목록 연동은 현재 코드에 구현되어 있지 않습니다.

### 좌석 정보 전달 앱

- 60개의 토글 버튼으로 좌석 사용 여부를 직접 입력합니다.
- 버튼 상태를 Firebase의 해당 좌석 경로에 저장합니다.
- 사용 중인 좌석과 빈 좌석을 다른 배경색으로 표시합니다.

현재 좌석 상태는 사람이 버튼으로 입력합니다. PC의 전원·로그인 상태를 자동으로 감지하는 프로그램, 좌석 예약 및 결제 기능은 포함되어 있지 않습니다.

## 시스템 구조

```text
좌석 정보 전달 앱 (seat_information3)
  60개 ToggleButton으로 좌석 상태 입력
                    │
                    │ setValue("0" 또는 "1")
                    ▼
Firebase Realtime Database
  /seat_information/seat_01 ... seat_60
                    │
                    │ ValueEventListener
                    ▼
이용자용 앱 (information)
  좌석 배경색 변경 · 사용 중/이용 가능 집계 · 홈 빈자리 수 표시
```

두 앱은 서로 다른 패키지로 설치되며 같은 Firebase 프로젝트를 사용합니다. 이용자 앱의 리뷰·게시판·공지 조회도 Realtime Database를 사용합니다.

## 기술 구성

| 구분 | 기술 / 설정 |
|---|---|
| 언어 | Java, Java 8 소스 호환성 |
| 화면 | Android XML Layout, Activity, Fragment |
| UI | AndroidX AppCompat, Material Components, RecyclerView, ViewFlipper |
| 게시글 작성 패널 | SlidingUpPanelLayout 3.4.0 |
| 실시간 데이터 | Firebase Realtime Database 20.0.4 |
| Firebase BoM | 이용자 앱 31.0.0 / 좌석 정보 전달 앱 31.0.2 |
| 지도 | NAVER Maps Android SDK 3.14.0 |
| 위치 | Google Play Services Location 20.0.0 |
| 웹 콘텐츠 | Android WebView |
| 빌드 | Android Gradle Plugin 7.3.0 / Gradle Wrapper 7.4 |
| SDK | minSdk 26 / targetSdk 32 / compileSdk 32 |
| 최소 Android 버전 | Android 8.0 |

Firebase Firestore와 좌석 정보 전달 앱의 Firebase Authentication도 의존성에 선언되어 있지만, 현재 Java 소스에서 이를 사용하는 데이터 처리나 로그인 흐름은 확인되지 않습니다.

## 디렉터리 구조

```text
pcroom-seat-monitor/
├─ README.md
├─ CODE_ANALYSIS.md                 # 상세 코드 분석 및 개선 사항
├─ information/                    # 이용자용 독립 Android 프로젝트
│  ├─ app/
│  │  ├─ build.gradle
│  │  └─ src/
│  │     ├─ google-services.json    # 현재 위치, 실행 전 배치 확인 필요
│  │     ├─ main/
│  │     │  ├─ AndroidManifest.xml
│  │     │  ├─ java/com/example/information/
│  │     │  └─ res/
│  │     ├─ test/
│  │     └─ androidTest/
│  ├─ build.gradle
│  ├─ settings.gradle
│  └─ gradlew.bat
└─ seat_information3/              # 좌석 정보 전달용 독립 Android 프로젝트
   ├─ app/
   │  ├─ build.gradle
   │  ├─ google-services.json
   │  └─ src/
   │     ├─ main/
   │     │  ├─ AndroidManifest.xml
   │     │  ├─ java/com/example/seat_information/
   │     │  └─ res/
   │     ├─ test/
   │     └─ androidTest/
   ├─ build.gradle
   ├─ settings.gradle
   └─ gradlew.bat
```

### 주요 소스

| 파일 | 역할 |
|---|---|
| 이용자 앱 `MainActivity.java` | 홈, 화면 이동, 배너 슬라이드, 빈자리 수 조회 |
| `Seat_information.java` | 60개 좌석 상태 표시 및 집계 |
| `Maps.java` | 지도 초기화, 마커, 위치 권한 처리 |
| `information.java` | 매장 상세, 음식 메뉴, 리뷰 작성·조회 |
| `ExpandableListAdapter.java` | 음식 메뉴 펼침·접힘 처리 |
| `cummunity.java` | 자유게시판 작성·조회 |
| `NOtice.java` | 공지사항 조회 |
| `event.java`, `Eventlist.java`, `Endevent.java` | 이벤트 탭과 목록 |
| `favorite.java` | 즐겨찾기 화면 |
| `OPGG.java`, `FOW.java`, `DAK.java`, `Gameinfo.java` | 외부 사이트 WebView |
| 좌석 정보 전달 앱 `MainActivity.java` | 좌석 토글 입력 및 Firebase 저장 |

## 데이터 구조

클라이언트 코드의 읽기·쓰기 경로를 기준으로 정리한 구조입니다. 실제 서버 데이터와 접근 규칙은 별도로 확인해야 합니다.

```text
/
├─ seat_information
│  ├─ seat_01: "0"
│  ├─ seat_02: "1"
│  ├─ ...
│  └─ seat_60: "0"
├─ Review
│  └─ {pushId}: "리뷰 내용"
├─ community
│  └─ {pushId}: "게시글 내용"
├─ Notice
│  └─ {childKey}: "공지 내용"
└─ log
   └─ log: "check"
```

| 좌석 값 | 의미 |
|---|---|
| 문자열 `"0"` | 이용 가능 |
| 문자열 `"1"` | 사용 중 |

경로의 대소문자와 좌석 번호 형식을 유지해야 합니다. 1~9번은 `seat_01`~`seat_09`이며, 집계 코드가 문자열을 비교하므로 숫자형 `0`, `1`과 혼용하지 않아야 합니다.

## 개발 환경 설정 및 실행

### 공개 소스의 API 설정

실제 Firebase `google-services.json` 파일과 네이버 지도 Client ID는 공개 소스에서 제외했습니다. 설정 파일은 각 Android 프로젝트의 `app/google-services.json`에 직접 배치해야 합니다. 이 파일은 `.gitignore`로 제외됩니다.

네이버 지도 Client ID는 `information/local.properties`에 `NAVER_MAP_CLIENT_ID=본인의_클라이언트_ID`로 입력하거나 같은 이름의 환경변수로 설정합니다. Manifest는 Gradle placeholder로 값을 전달받습니다. `local.properties`도 Git에 포함되지 않습니다.

이 설정 분리는 저장소에 실제 값을 올리지 않기 위한 것입니다. 실행 앱에는 클라이언트 설정이 포함되며, Firebase 서버의 접근 규칙과 API 사용 제한은 별도로 관리해야 합니다.

현재 저장소에는 누락된 리소스와 환경 설정 문제가 있습니다. 아래 항목을 복구한 뒤 실행해야 하며, 현재 상태에서 빌드 성공을 확인한 것은 아닙니다.

### 1. Android 프로젝트 열기

Android Studio에서 `information`과 `seat_information3` 폴더를 각각 프로젝트로 엽니다. 저장소 최상위 폴더를 하나의 Android 프로젝트로 사용하는 구조는 아닙니다.

Android Gradle Plugin 7.3.0 및 Gradle 7.4와 호환되는 JDK를 구성하고 Android SDK Platform 32를 준비합니다. 기기 또는 에뮬레이터는 Android 8.0 이상이어야 합니다.

`local.properties`는 Git에 포함되지 않습니다. Android Studio에서 현재 개발 환경의 SDK 경로를 설정합니다.

### 2. Firebase 연결

1. 사용할 Firebase 프로젝트에 아래 두 Android 앱을 등록합니다.
   - 이용자 앱: `com.example.information`
   - 좌석 정보 전달 앱: `com.example.seat_information`
2. 두 앱이 같은 Realtime Database를 사용하도록 각각의 설정 파일을 준비합니다.
3. 각 앱의 `google-services.json`을 해당 프로젝트의 `app/` 폴더에 배치합니다. 실제 설정 파일은 공개 저장소에서 제외되어 있습니다.
4. `seat_information` 아래에 `seat_01`~`seat_60`을 모두 생성하고, 문자열 `"0"` 또는 `"1"`로 초기화합니다.
5. 테스트 계정과 목적에 맞게 DB 접근 규칙을 구성합니다. 관리자 역할에 따른 좌석 쓰기 제한을 적용하려면 앱의 인증 흐름도 추가해야 합니다.

현재 조회 코드는 없는 좌석 값을 안전하게 처리하지 않으므로, 일부 좌석만 초기화한 상태에서는 화면이 종료될 수 있습니다.

### 3. 네이버 지도 설정

`information/local.properties` 또는 환경변수의 `NAVER_MAP_CLIENT_ID`에 사용할 지도 서비스의 클라이언트 ID를 설정하고, 서비스에서 앱 패키지의 사용 권한을 확인합니다. 위치 기능 사용 시 기기에서 위치 권한을 허용합니다.

### 4. 리소스 복구

이용자 앱에서 참조하는 이미지 리소스 33종이 현재 폴더에 없습니다. 원본 이미지를 복구하거나 각 참조에 맞는 리소스를 추가해야 합니다. 누락 목록은 [상세 코드 분석](CODE_ANALYSIS.md)의 빌드 재현 문제 항목에 있습니다.

### 5. 빌드 및 실행

환경과 리소스를 복구한 뒤 각 Android Studio 프로젝트에서 Gradle Sync를 실행하고 기기에 설치합니다. Windows PowerShell에서는 저장소 루트에서 다음 명령으로 각각 빌드할 수 있습니다.

```powershell
Set-Location .\information
.\gradlew.bat assembleDebug
Set-Location ..\seat_information3
.\gradlew.bat assembleDebug
```

## 좌석 연동 시연

1. Firebase에 60개 좌석 상태를 초기화합니다.
2. 이용자 앱에서 나사렛 피시방의 자리현황 화면을 엽니다.
3. 좌석 정보 전달 앱에서 원하는 좌석의 토글을 변경합니다.
4. Firebase의 같은 번호 좌석 값과 이용자 화면의 색상·집계를 확인합니다.
5. 체크를 해제하여 이용 가능한 상태로 전환하고 표시 변화를 확인합니다.

좌석 정보 전달 앱은 시작할 때 서버의 기존 상태를 복원하지 않습니다. 시연 시 입력 앱의 초기 화면과 서버 상태가 일치하는지 먼저 확인해야 합니다.

## 현재 구현 범위와 제한사항

| 항목 | 현재 상태 |
|---|---|
| 다중 매장 | 홈과 지도에 여러 매장을 표시하지만 실시간 좌석 및 상세 화면은 나사렛 피시방 중심 |
| 매장 데이터 | 요금, 사양, 평점, 메뉴와 지도 마커는 코드·XML에 고정 |
| 즐겨찾기 | 소개서에는 추가·해제 및 목록 확인으로 설명되어 있으나 현재 소스에는 하트 외형 변경과 정적 목록만 존재 |
| 이벤트 | 목록과 날짜가 고정이며 자동 기간 분류나 관리 기능 없음. 최초 진입 시 기본 목록 설정 필요 |
| 전적 사이트 | 사이트 API 연동 없이 WebView 사용. OP.GG/FOW/DAK URL에 `https://` 보완 필요 |
| 게시글·리뷰 | 내용 문자열만 저장. 작성자·작성 시간·수정·삭제 기능 없음 |
| 좌석 입력 | 서버 상태 복원과 쓰기 성공·실패 처리 없음 |
| 데이터 안정성 | 값이 없거나 형식이 잘못되면 좌석 화면에서 예외 발생 가능. 화면 간 집계 규칙 통일 필요 |
| 리스너 관리 | 화면 종료 시 해제 누락 및 잘못된 경로에서 해제하는 코드 존재 |
| 위치 권한 | 권한 결과의 FusedLocationSource 전달 및 대략적 위치 처리 보완 필요 |
| 서버 권한 | 실제 Security Rules 미확인. 소스에 관리자 로그인 흐름 없음 |

## 테스트 및 개선 방향

기존 테스트는 기본 산술 결과와 앱 패키지 이름을 확인하는 예제 수준입니다. 좌석 동기화와 주요 기능을 검증하는 테스트는 추가되어 있지 않습니다.

코드 분석 당시 Gradle Wrapper 실행을 시도했으나 셸에 `JAVA_HOME`과 `java` 실행 파일이 없어 Gradle 시작 전에 실패했습니다. 앱 실행, Android Lint 및 테스트 통과 여부는 확인하지 못했습니다.

개선 우선순위는 다음과 같습니다.

1. 누락 이미지, JDK·SDK 환경 및 Firebase 설정을 복구해 두 앱의 빌드를 재현합니다.
2. 좌석 값 검증과 공통 집계를 추가하고 입력 앱의 서버 상태를 복원합니다.
3. Firebase 읽기·쓰기 실패를 처리하고 등록한 리스너를 정확히 해제합니다.
4. 즐겨찾기 저장, 이벤트 초기 화면, WebView URL과 위치 권한 처리를 완성합니다.
5. 매장·좌석·리뷰·게시글 모델과 사용자 권한을 도입합니다.
6. 반복되는 좌석 처리와 DB 접근을 공통 코드로 분리합니다.

좌석 집계의 경계값, 앱 재실행 후 상태 복원, 통신 실패, 반복 화면 이동, 위치 권한 거부를 우선 검증하는 것이 좋습니다.

## 참고 자료

- 사용자 제공 앱 소개서: **2022-2학기 캡스톤 디자인 우수사례 공모** (12개 슬라이드)
- [전체 코드 분석 보고서](CODE_ANALYSIS.md)
- [Firebase Android 설정](https://firebase.google.com/docs/android/setup)
- [Firebase Realtime Database 읽기·쓰기](https://firebase.google.com/docs/database/android/read-and-write)
- [네이버 지도 위치 기능](https://navermaps.github.io/android-map-sdk/guide-ko/4-2.html)

소개서 원본은 현재 저장소에 포함되어 있지 않습니다.
