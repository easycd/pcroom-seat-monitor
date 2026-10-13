# 저장소 전수 조사 결과

조사일: 2026-10-13 (한국 시간)  
기준 커밋: `5fecbf2`  
대상: GitHub에서 clone한 현재 저장소

## 결론

두 Android 앱을 Firebase Realtime Database로 연결하는 60석 수동 상태 공유 프로젝트다. 좌석 입력과 조회 흐름은 구현되어 있지만, 이용자 앱의 빌드에 필요한 리소스가 누락되어 있고 데이터 누락·재실행·저장 실패에 대한 처리가 부족하다. 현재 상태를 안정적인 실행 버전으로 판단할 수 없다.

앱 코드는 수정하지 않았다. 실제 Firebase 서버 데이터·접근 규칙, 지도 서비스 등록 상태, 기기 실행 결과는 조사 범위 밖이다. 불필요한 빌드·예제 테스트 실행은 생략했다. 현재 셸에는 `java` 명령이 없고 `JAVA_HOME`도 설정되어 있지 않다.

## 조사 범위

- 운영 Java 소스 16개: 이용자 앱 15개, 좌석 입력 앱 1개.
- 리소스 XML 60개: 이용자 앱 41개, 좌석 입력 앱 19개. 레이아웃 구조, ID, 리소스 참조, 테마·색상·메뉴·백업 설정을 확인했다.
- 두 Manifest, 프로젝트/앱 Gradle, settings.gradle, gradle.properties, Wrapper 설정, ProGuard 설정, `.gitignore`.
- Firebase 설정 두 개: 프로젝트와 DB 주소 일치 여부, 앱 패키지 등록 여부만 확인했으며 키 값은 보고서에 재출력하지 않았다.
- 기본 테스트 4개 및 기존 README.md, CODE_ANALYSIS.md.
- 반복 좌석 코드는 번호를 제외한 본문이 동일함을 확인하고, 읽기/쓰기 60개 블록의 번호 연결을 대조했다.

## 우선순위별 결함

### 1. [P1] 이용자 앱 drawable 33종 누락

Java의 `R.drawable`과 XML의 `@drawable` 참조를 실제 drawable 폴더 파일과 대조했다. 아래 리소스가 없다. 이 참조들은 리소스 링크 또는 Java 컴파일을 막는다. 좌석 입력 앱에는 같은 검사에서 drawable 누락이 없었다.

`able`, `back`, `dak`, `down`, `emptyheart`, `event`, `event10`, `event2`, `event3`, `event4`, `event5`, `event6`, `event7`, `event8`, `event9`, `fow`, `heart`, `home`, `main_icon`, `map`, `opgg`, `pc`, `printing`, `quick`, `room1`, `room2`, `room3`, `room4`, `room5`, `room6`, `smoking`, `storemassage`, `word`.

원본 이미지 복구가 우선이다. 대체 이미지를 쓰면 원본 디자인 재현과 기능 복구를 구분해야 한다.

### 2. [P1] 이용자 앱 Firebase 설정 파일 위치

설정은 `information/app/src/google-services.json`에 있고 `information/app/google-services.json`은 없다. 별도의 파일 위치 지정이나 product flavor 설정도 없다. 기본 플러그인 설정에서 파일을 찾지 못할 원인이 된다.

공식 문서는 `app/google-services.json` 또는 `app/src/{build_type}/google-services.json` 등의 위치를 설명한다. 현재 위치를 앱 모듈 루트로 옮기는 것이 수정 방향이다. [Firebase 공식 문서](https://firebase.google.com/docs/android/google-services-plugin-and-file)

### 3. [P1] 좌석 키 누락 또는 비정상 값에서 화면 종료

`information/app/src/main/java/com/example/information/Seat_information.java:64`부터 60개 콜백이 `getValue().toString()` 및 `Integer.parseInt()`를 바로 호출한다. 한 좌석이라도 없으면 null 접근, 문자열이 `unknown`이면 숫자 변환 예외가 발생한다. 상위 경로가 없으면 집계 콜백의 977행에서도 null 접근이 발생한다.

좌석 키와 값의 존재·타입·허용 범위를 검사하고 미확인 상태를 별도로 표시해야 한다. 미확인 상태를 빈자리로 취급하면 잘못된 안내가 된다.

### 4. [P1] 좌석 입력 앱이 서버 상태를 읽지 않음

`seat_information3/app/src/main/java/com/example/seat_information/MainActivity.java:71`부터 60개 토글이 쓰기만 한다. 서버 상태를 읽어 체크 상태를 복원하는 코드가 없다.

서버가 `seat_01="1"`인 상태에서 앱을 재실행하면 1번 좌석은 기본 체크 해제 상태로 보인다. 빈자리로 바꾸려고 누르면 첫 클릭은 오히려 `"1"`을 다시 쓴다. 다른 입력 단말에서 바꾼 값도 반영하지 못한다.

초기 데이터를 읽은 뒤 조작을 허용하고 변경을 구독해야 한다. 서버 값으로 체크 상태를 설정하는 동작이 쓰기 리스너를 다시 실행하지 않도록 구분해야 한다.

### 5. [P1] 저장 실패를 성공처럼 표시하고 원문 삭제

좌석 입력 앱의 모든 `setValue()`는 성공·실패 처리 없이 버튼 색상을 바꾼다. 권한 거부 등으로 저장되지 않아도 입력 화면이 서버와 달라진 상태를 유지한다.

리뷰 `information.java:125`와 게시판 `cummunity.java:63`도 저장 완료 전에 입력을 지운다. 저장 실패 시 사용자는 원문을 잃는다. 성공 시 입력을 비우고, 실패 시 입력을 보존하며 재시도 안내를 해야 한다. 좌석은 저장 중 상태와 실패 시 복원 처리가 필요하다.

### 6. [P2] 좌석 색상·홈 집계·좌석 집계 규칙 불일치

- 홈 `MainActivity.java:145`: 문자열 `"0"`만 빈자리로 집계.
- 좌석 화면 `Seat_information.java:978`: 문자열 `"1"` 이외 모든 값을 빈자리로 집계.
- 좌석 색상: 문자열로 변환한 뒤 정수 1이면 사용 중으로 표시.

예를 들어 DB 값이 숫자형 `1`이면 좌석은 빨간색인데 집계에서는 빈자리로 센다. 값 `"2"`도 좌석 집계에서 빈자리로 센다. 두 집계 모두 자식 키 범위를 제한하지 않아 메타데이터가 섞이면 숫자에 포함될 수 있다.

홈은 집계 결과 표시가 반복문 안에 있어 경로가 비면 이전 숫자 또는 XML 기본 숫자가 남는다. `seat_01`~`seat_60`만 동일한 파싱 규칙으로 집계하고 결과를 반복문 밖에서 표시해야 한다.

### 7. [P2] Firebase 리스너 해제 누락 및 잘못된 경로

좌석 화면은 60개 좌석 구독과 집계 구독 1개를 등록하지만 해제하지 않는다. 홈도 구독을 해제하지 않는다.

리뷰·게시판·공지는 `/log`에 ChildEventListener를 붙인 다음 `mReference`를 각각 `/Review`, `/community`, `/Notice`로 바꾼다. `onDestroy()`는 바뀐 경로에서 ChildEventListener를 제거하므로 원래 구독이 남는다. 실제 목록의 ValueEventListener도 저장·해제하지 않는다.

화면을 반복해서 열면 종료된 Activity를 붙잡은 구독이 누적될 수 있다. 등록 reference와 listener를 함께 보관하고 화면 수명주기에 맞춰 제거해야 한다. 좌석 버튼과 집계를 상위 경로의 단일 스냅샷으로 갱신하면 서로 다른 순간의 값을 표시하는 문제도 줄일 수 있다.

### 8. [P2] 전적 사이트 URL에 스킴 없음

`OPGG.java:36`의 `"op.gg"`, `FOW.java:35`의 `"fow.kr"`, `DAK.java:35`의 `"dak.gg"`는 HTTPS 주소로 수정해야 한다. Gameinfo는 HTTPS 주소를 사용한다. 외부 사이트의 현재 WebView 호환성은 확인하지 않았다.

네 웹 화면 모두 웹 내부 방문 기록을 처리하는 뒤로가기와 로딩/실패 안내가 없다. 하단 뒤로가기는 Activity를 닫는다.

### 9. [P2] 즐겨찾기 저장 및 목록 연동 미구현

`information.java:59`의 토글은 하트 이미지 변경만 한다. 저장소에 저장하거나 시작 시 불러오지 않는다. `favorite.java`는 XML의 고정 목록을 표시하고 하단 메뉴만 연결한다. 매장 정보·좌석 버튼도 연결되지 않았다. 좌석 화면의 즐겨찾기 메뉴 리스너는 주석 처리되어 있다.

현재 하트 클릭은 앱 재실행 후 유지되는 즐겨찾기 기능을 제공하지 않는다.

### 10. [P2] 이벤트 최초 진입 시 본문 비어 있음

`event.java:19` 이후 버튼 리스너만 등록하고 최초 Eventlist Fragment를 넣지 않는다. 사용자가 탭을 누를 때까지 목록이 없다. 탭 전환마다 `addToBackStack(null)`을 호출하므로 뒤로가기는 탭 선택 이력을 거슬러 간다.

최초 생성 시 기본 탭을 표시하고, 단순 탭 전환의 back stack 정책을 정해야 한다. 이벤트는 서버 데이터나 날짜 판정 없이 고정 목록이다.

### 11. [P2] 지도 위치 권한 결과 전달 누락

`Maps.java:162`는 `FusedLocationSource.onRequestPermissionsResult()`에 결과를 전달하지 않고 첫 번째 FINE_LOCATION 결과만 확인한다. 대략적 위치만 허용하면 Follow 설정 분기를 타지 않는다.

권한 결과를 위치 소스에 전달하고 거부·대략적 위치 허용을 처리해야 한다. [네이버 지도 공식 문서](https://navermaps.github.io/android-map-sdk/guide-ko/4-2.html)

### 12. [P2] 좌석 입력 화면이 좁은 화면에서 잘릴 구조

`seat_information3/app/src/main/res/layout/activity_main.xml:51` 이후 고정 폭 910dp 좌석 행을 사용한다. 루트는 스크롤 없는 세로 LinearLayout이다. 폭이 910dp보다 작은 기기에서 전체 좌석을 보기 어렵다. 이용자 좌석 화면은 가로 스크롤이 있지만 높이는 450dp로 고정되어 있다.

이벤트 본문은 `event.xml:15`에서 높이 750dp이며 하단 메뉴 위까지 영역을 제한하는 조건이 없다. 작은 화면에서는 본문과 하단 메뉴 겹침 가능성이 있다. 실제 잘리는 영역은 기기 실행으로 확인해야 한다.

### 13. [P3] 입력 검증과 목록 상태 관리 부족

리뷰·게시판은 공백 문자열 및 길이 제한을 검사하지 않는다. 리뷰·게시판·공지의 adapter는 갱신마다 clear하지만 별도 `Array` 목록은 계속 추가한다. 화면 목록 중복은 아니지만 사용하지 않는 목록의 메모리가 늘어난다. 읽기 취소 콜백 대부분이 비어 있어 서버 오류와 빈 목록을 구별하기 어렵다.

리뷰의 `getCurrentFocus().getWindowToken()`은 포커스가 없을 때 null 접근 가능성이 있다. 입력 뷰의 토큰을 사용하거나 null을 검사해야 한다.

### 14. [P3] 반복 화면 이동과 UI 표시 문제

홈·이벤트·즐겨찾기에서 현재 화면의 하단 메뉴를 눌러도 같은 Activity를 새로 시작한다. Activity와 뒤로가기 이력이 늘어난다. 최상위 화면 이동 정책을 정하고 자기 자신을 다시 여는 동작을 제거해야 한다.

ExpandableListAdapter는 메뉴 접기/펼치기 자체는 구현되어 있으나 두 상태 모두 같은 down 이미지를 지정한다. 글자 크기에 dp를 사용하는 XML, 하드코딩된 문자열과 고정 여백도 많다. 글꼴 확대·화면 크기 대응은 리소스 복구 후 확인해야 한다.

## 파일별 구현 상태

| 파일 | 구현 및 제한 |
|---|---|
| 이용자 MainActivity | 화면 이동·배너·빈자리 조회. 매장 6개 중 첫 매장만 상세/좌석 연결. 드로어 숫자는 고정 |
| Seat_information | 60석 조회·배경색·집계. 누락 값 방어와 리스너 해제 없음 |
| Maps | 고정 매장 마커 6개와 위치 컨트롤. 매장 상세 연결과 초기 매장 영역 카메라 설정 없음 |
| information | 고정 매장 상세·음식 메뉴·리뷰. 하트 저장 및 평점 재계산 없음 |
| ExpandableListAdapter | 메뉴 그룹별 자식 제거/복원과 RecyclerView 범위 알림 구현 |
| cummunity | 내용 문자열 작성·조회. 제목·작성자·시간·수정·삭제 없음 |
| NOtice | 공지 문자열 조회. 관리자 작성 기능 없음 |
| favorite | 고정 즐겨찾기 목록 및 하단 메뉴 |
| event / Eventlist / Endevent | 탭 전환과 고정 XML 이벤트 목록 |
| OPGG / FOW / DAK / Gameinfo | 외부 웹페이지 표시. 사이트 API 연동 없음 |
| 입력 MainActivity | 60개 토글로 문자열 0/1 저장. 서버 상태 조회·저장 결과 처리 없음 |
| 테스트 4개 | 산술 2+2 및 패키지 이름만 확인. 업무 기능 테스트 없음 |

## 데이터와 보안 판단

두 Firebase 설정은 같은 프로젝트와 DB를 가리키며 필요한 앱 패키지가 등록되어 있다. 읽기 좌석 번호→버튼 번호, 쓰기 버튼 번호→좌석 키의 60개 연결에서 번호 불일치는 발견되지 않았다. 반복 좌석 로직은 번호를 제외하면 동일하다.

경로는 `/seat_information/seat_01...seat_60`, `/Review`, `/community`, `/Notice`, `/log/log`다. 좌석은 문자열 `"0"`(빈자리), `"1"`(사용 중)을 쓴다. 매장 ID와 작성자 ID가 없어 다중 매장 및 사용자별 권한 확장이 어렵다.

PC 전원·로그인 상태 자동 감지, 예약, 결제는 구현되어 있지 않다. 입력 앱에 Firebase Auth 의존성은 있지만 로그인 흐름은 없다. 서버 Security Rules 파일도 없다. 실제 서버가 공개되어 있는지 또는 무단 변경 가능한지는 단정할 수 없다. Firebase 설정 파일 자체는 관리자 비밀키가 아니다. [Firebase 설정 파일 설명](https://firebase.google.com/docs/android/google-services-plugin-and-file)

## 빌드 설정과 기존 문서의 차이

- 두 프로젝트는 독립 Android 프로젝트이며 AGP 7.3.0, Gradle 7.4, Java 8 소스 호환성, minSdk 26, compileSdk/targetSdk 32를 사용한다.
- 이용자 앱은 Material 1.6.0과 1.8.0-alpha02를 동시에 선언한다. 의도한 버전으로 통일할 필요가 있다.
- 이용자 최상위 Gradle은 Google Services 4.3.14 classpath와 4.3.10 plugins 선언을 함께 쓴다. 버전 선언을 하나로 정리해야 한다. 이것만으로 구체적인 Gradle 실패 결과를 확정하지는 않았다.
- 입력 앱은 Google Services 플러그인을 plugins와 apply plugin 양쪽에 선언한다. 불필요한 중복이다.
- Firestore, 입력 앱 Auth 등 일부 의존성은 실제 데이터 흐름에 쓰이지 않는다.
- **현재 clone에는 두 local.properties가 없다.** `.gitignore`가 이를 제외한다. 기존 README/CODE_ANALYSIS의 Mac SDK 경로가 남았다는 설명은 현재 checkout과 일치하지 않는다.
- 기존 보고서의 Gradle 실행 실패 기록은 이전 조사 기록이다. 이번에는 java 명령과 JAVA_HOME 상태만 확인하고 Gradle 실행은 생략했다.

## 수정 순서

1. 누락 이미지 복구와 Firebase 파일 위치 수정 후 개발 환경에서 두 앱 빌드.
2. 좌석 파싱·미확인 상태·집계를 통일하고 입력 앱에 서버 상태 복원 및 저장 실패 처리 추가.
3. Firebase 구독 등록/해제 수정, 게시글·리뷰 성공 시 입력 삭제 및 실패 안내.
4. WebView URL, 즐겨찾기, 기본 이벤트 탭, 지도 권한 전달, 화면 이동 수정.
5. 좁은 화면 레이아웃 대응 및 필요 시 매장·사용자별 데이터 모델 확장.

수정 후 필요한 확인은 누락/숫자형 좌석 데이터, 입력 앱 재실행, 저장 권한 거부, 화면 반복 이동, 위치 거부와 대략적 위치 허용이다. 의미 없는 산술 예제 테스트 반복은 필요하지 않다.
