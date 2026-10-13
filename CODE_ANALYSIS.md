# PCroom_state 전체 코드 분석

분석일: 2026-10-13 (한국 시간)

## 1. 분석 범위와 결론

직접 작성한 Java 소스 16개, 두 앱의 리소스 XML 60개, AndroidManifest, Gradle 설정, Firebase 설정, 기본 테스트를 확인했다. build 및 .gradle의 생성물은 구현 평가에서 제외했다. Java 소스는 이용자 앱 2,575줄, 좌석 입력 앱 800줄이다. 실행 테스트와 빌드 성공은 확인하지 못했다.

이 프로젝트는 **주변 PC방 정보 조회와 수동 입력 기반의 실시간 좌석 공유를 결합한 Android 졸업작품**이다. 핵심 구현은 두 독립 앱을 Firebase Realtime Database로 연결하는 것이다. 좌석 입력 → DB 저장 → 이용자 화면 색상 변경과 빈자리 집계의 연결이 코드에 구현되어 있다.

현재 소스는 단일 매장의 시연을 중심으로 구성되어 있다. 여러 매장 정보는 화면에 있지만, 실시간 좌석과 상세 조회는 나사렛 피시방 한 곳에 연결된다. 즐겨찾기, 이벤트 관리, 사용자 권한 등은 제품 기능으로 완성되어 있지 않다. 이 평가는 제출 당시 실행 상태가 아니라 현재 폴더에 있는 코드 기준이다.

## 2. 구성과 실행 흐름

| 프로젝트 | 역할 | 핵심 파일 |
|---|---|---|
| information | 이용자용 Android 앱 | MainActivity.java, Seat_information.java, Maps.java |
| seat_information3 | 좌석 상태를 수동 입력하는 별도 Android 앱 | MainActivity.java |

두 프로젝트 모두 Java 8, XML 화면, compileSdk/targetSdk 32, minSdk 26, Android Gradle Plugin 7.3.0, Gradle 7.4를 사용한다. 각자 settings.gradle과 app 모듈을 가진 독립 프로젝트다.

```text
좌석 입력 앱: 60개 ToggleButton
    ↓ 체크 상태를 문자열 "1" 또는 "0"으로 저장
Firebase Realtime Database /seat_information/seat_01 ... seat_60
    ↓ ValueEventListener
이용자 앱: 좌석 색상 + 사용중/사용가능 집계 + 홈 빈자리 표시
```

두 google-services.json은 같은 Firebase 프로젝트와 Realtime Database 주소를 가리킨다. 이용자 앱 설정에는 com.example.information, 입력 앱 설정에는 com.example.seat_information 등록이 존재한다. API 키나 설정 식별자를 보고서에 재출력하지 않았다.

**현재 코드에는 PC의 전원·로그인·결제 상태를 자동 감지하는 수집 프로그램이 없다.** 실시간이라는 의미는 사람이 입력한 변경을 Firebase로 전달하는 것이다. 좌석 예약이나 결제 기능도 없다.

## 3. 파일별 역할과 완성도

| 파일 | 역할 | 확인한 상태 |
|---|---|---|
| MainActivity.java | 홈, 화면 이동, 배너, 빈자리 집계, 드로어 | 나사렛 매장만 상세/좌석 버튼 연결. 다른 매장은 XML 정적 표시 |
| Seat_information.java | 60석 상태 조회 및 전체 집계 | 좌석별 구독 60개 + 집계 구독 1개. 조회만 수행 |
| Maps.java | 네이버 지도, 현재 위치, 매장 6개 마커 | 좌표·이름·요금 고정. 마커 상세 연결 및 동적 매장 조회 없음 |
| information.java | 매장 상세, 음식 메뉴, 리뷰, 하트 | 상세/메뉴 정적. 리뷰는 Firebase 읽기/쓰기. 하트는 외형만 변경 |
| ExpandableListAdapter.java | 음식 메뉴 그룹 펼치기/접기 | 자식 데이터 제거/복원과 RecyclerView 범위 알림 구현 |
| cummunity.java | 자유게시판 | 내용 문자열을 저장/조회. 작성자·제목·시간·수정/삭제 없음 |
| NOtice.java | 공지사항 | Notice 경로 조회. 관리자 작성 UI 없음 |
| favorite.java | 즐겨찾기 화면 | 고정 매장 두 개 표시. 저장 데이터 조회 및 매장 버튼 연결 없음 |
| event.java | 진행중/종료 탭 전환 | 버튼을 누르면 Fragment 교체. 최초 화면의 Fragment 설정 없음 |
| Eventlist.java / Endevent.java | 이벤트 목록 | XML에 고정된 이미지·제목·날짜 표시 |
| OPGG.java / FOW.java / DAK.java | 전적 사이트 표시 | WebView 사용. 세 URL 모두 스킴 누락 |
| Gameinfo.java | 게임 정보 사이트 표시 | 인벤 HTTPS URL을 WebView로 로드 |
| 입력 앱 MainActivity.java | 좌석 사용중/빈자리 입력 | 60석 각각 setValue. 서버 초기 조회, 쓰기 결과 확인 없음 |

cm_edit.xml은 작성 화면 리소스가 있지만 이를 사용하는 Activity/화면 연결을 현재 코드에서 찾지 못했다. 실제 게시판 작성은 community.xml의 SlidingUpPanelLayout 안에서 한다.

## 4. 코드에서 추론되는 데이터 구조

```text
/
├─ seat_information
│  ├─ seat_01: "0" 또는 "1"
│  ├─ ...
│  └─ seat_60: "0" 또는 "1"
├─ Review
│  └─ pushId: "리뷰 내용"
├─ community
│  └─ pushId: "게시글 내용"
├─ Notice
│  └─ childKey: "공지 내용"
└─ log
   └─ log: "check"
```

이는 클라이언트 읽기/쓰기 경로로 추론한 구조다. 실제 서버 데이터와 Security Rules는 조회하지 않았다. "0"은 빈자리, "1"은 사용중이다. 읽기/쓰기 앱의 60개 좌석 키는 일치했고, 조회 리스너 안에서 다른 번호의 버튼을 갱신하는 매핑 오류는 정적 검사에서 발견되지 않았다.

매장 ID와 사용자 ID가 없어 리뷰와 좌석을 매장별로 분리할 수 없다. 문자열 게시글은 간단한 시연에는 적합하지만 작성자, 시간, 정렬, 삭제 권한을 붙이려면 구조 변경이 필요하다.

## 5. 우선 처리할 결함

### A. 빌드 재현 문제

1. **이용자 앱 이미지 리소스 33종 누락**
   main/res에서 Java의 R.drawable 및 XML의 @drawable 참조를 실제 파일과 대조했다. 이벤트 배너, 하트, 매장 사진, 뒤로가기/홈 아이콘 등이 없다. 현재 폴더 기준으로 리소스 링크 또는 Java 컴파일을 통과할 수 없는 원인이다. 기존 build 생성물이 남아 있다고 원본 리소스가 복구되는 것은 아니다.

   누락 목록: able, back, dak, down, emptyheart, event, event10, event2, event3, event4, event5, event6, event7, event8, event9, fow, heart, home, main_icon, map, opgg, pc, printing, quick, room1, room2, room3, room4, room5, room6, smoking, storemassage, word.

2. **SDK 경로가 이전 Mac 환경에 고정**
   두 local.properties의 sdk.dir가 /Users/kimjaewon/Library/Android/sdk다. 현재 Windows 환경에 맞는 SDK 경로로 재설정해야 한다.

3. **이용자 앱 Firebase 설정 위치 확인 필요**
   파일이 information/app/src/google-services.json에 있다. 현재 기본 구성에서 통상 사용하는 위치는 information/app/google-services.json이며, 빌드 타입 전용 파일은 app/src/debug 같은 위치에 둔다. src 바로 아래 경로를 처리하는 별도 설정은 확인하지 못했다.

4. **현재 셸에 Java 실행 환경 없음**
   information에서 gradlew.bat --offline --version을 실행했으나 JAVA_HOME 미설정 및 PATH에 java가 없다는 오류로 종료됐다. Gradle 시작 전 실패했으므로 실제 assemble/lint/test 결과는 없다. 환경 변경이나 도구 설치는 수행하지 않았다.

### B. 좌석 데이터 누락 시 크래시

Seat_information.java:64와 동일한 패턴 60곳에서 getValue().toString()을 바로 호출한다. DB에 좌석 키가 없거나 삭제되면 null이므로 NullPointerException이 발생할 수 있다. 이어지는 Integer.parseInt도 잘못된 문자열에서 실패한다. 집계 콜백 977행에서도 전체 값에 대해 같은 null 접근을 한다.

해결 방향: 초기 좌석 데이터 생성, 값의 존재·타입·허용 범위 검증, "알 수 없음" 상태 표시를 함께 적용한다. 알 수 없는 데이터를 빈자리로 표시하지 않는 것이 좋다.

### C. 좌석 입력 앱이 서버 상태를 복원하지 않음

입력 앱은 체크 변경 리스너와 setValue만 있고 서버 읽기 및 체크 상태 복원이 없다. 재실행하면 서버에서 사용중인 좌석도 체크 해제된 초기 화면으로 보일 수 있다. 서버 "1"인 좌석을 빈자리로 바꾸려다가 첫 클릭으로 "1"을 다시 저장하는 등 조작 의미가 어긋난다. 여러 입력 단말도 같은 문제가 있다.

해결 방향: 서버 초기 데이터를 표시한 뒤 조작을 활성화하고, 외부 변경을 구독한다. 서버 값으로 setChecked를 호출할 때 다시 쓰기 콜백이 발생하지 않도록 구분해야 한다.

### D. 리스너 해제 오류와 누적

- Seat_information은 61개 구독을 만들고 해제하지 않는다. 홈의 구독도 해제하지 않는다.
- information, cummunity, NOtice는 /log에 ChildEventListener를 붙인 뒤 mReference를 실제 조회 경로로 덮어쓴다.
- onDestroy에서는 바뀐 경로에 mChild를 제거한다. 등록했던 /log의 리스너가 남고, 실제 ValueEventListener도 저장/해제되지 않는다.
- 화면을 반복해서 열면 이전 Activity를 참조하는 콜백과 불필요한 구독이 누적될 수 있다.

해결 방향: 등록에 쓴 DatabaseReference와 리스너를 정확히 보관한다. 화면 표시 시 구독, 화면 이탈 시 해제를 짝짓는다. 좌석은 상위 경로 한 번의 구독으로 버튼과 집계를 같은 스냅샷에서 갱신할 수 있다. 이는 콜백과 상태 관리 단순화 제안이며, 리스너 수만으로 네트워크 비용을 61배라고 계산할 수는 없다.

### E. 빈자리 집계가 데이터 타입에 따라 어긋남

홈은 문자열 "0"만 빈자리로 인정한다. 좌석 화면은 문자열 "1" 이외의 값을 모두 빈자리로 센다. 숫자형 1, 잘못된 문자열, 추가 메타데이터가 들어가면 두 화면의 집계가 달라질 수 있다. 집계 표시가 반복문 안에 있어 자식이 하나도 없을 때 홈의 이전 숫자가 남는다.

해결 방향: 하나의 상태 타입과 파싱 규칙을 사용한다. seat_01~seat_60 범위만 집계하고, 반복문 밖에서 결과를 표시한다. 사용가능·사용중·미확인 합계가 전체 좌석 수와 일치하도록 한다.

### F. 웹뷰 URL 오류

OPGG.java:36은 "op.gg", FOW.java:35는 "fow.kr", DAK.java:35는 "dak.gg"를 전달한다. 명시적인 https:// 주소로 바꿔야 한다. Gameinfo는 HTTPS 주소를 사용한다. 현재 코드는 사이트 API 연동이나 자체 전적 조회가 아니라 외부 웹페이지 표시다.

웹뷰의 페이지 내 뒤로가기, 로딩/실패 UI, 수명주기 처리도 없다. usesCleartextTraffic=true가 앱 전체에 설정되어 있으므로 실제 HTTP 필요 여부를 확인한 뒤 범위를 좁히는 것이 좋다.

## 6. 기능과 사용자 경험의 빈틈

- **즐겨찾기:** information.java:59~67의 하트는 배경만 바꾼다. SharedPreferences/DB 저장이 없고 favorite 화면과 연결되지 않는다. 즐겨찾기 화면 자체의 매장/좌석 버튼에도 기능이 없다.
- **다중 매장:** 홈에 6곳을 표시하지만 Java에서 상세/좌석 연결과 빈자리 갱신은 첫 매장만 한다. 드로어의 빠른 자리 현황도 recordmenu.xml의 고정 숫자다.
- **이벤트:** 최초 진입에 기본 Fragment를 넣지 않아 탭 선택 전 본문이 비어 있다. 탭마다 addToBackStack을 호출하여 뒤로가기가 탭 선택 이력을 거슬러 간다. 진행/종료는 날짜 계산이 아닌 정적 화면 구분이다.
- **평점/정보:** 평점, 가격, PC 사양과 음식 메뉴는 하드코딩이다. 리뷰를 작성해도 평점을 재계산하지 않는다.
- **게시글/리뷰:** 빈 문자열 및 길이 검증이 없고, 작성 완료를 확인하기 전에 입력을 지운다. 실패하면 사용자가 원문을 잃을 수 있다. setValue 성공/실패 처리를 붙여야 한다.
- **누적 배열:** 리뷰/게시판/공지의 adapter는 clear하지만 별도 Array 목록은 clear하지 않고 매 갱신마다 모든 항목을 추가한다. 화면 중복이 아니라 사용하지 않는 내부 목록의 메모리 증가 문제다.
- **오류 UI:** 대부분 onCancelled가 비어 있다. 권한 거부나 서버 읽기 실패를 빈자리/빈 목록과 구별하기 어렵다.
- **리뷰 키보드:** getCurrentFocus().getWindowToken()은 포커스가 없으면 실패할 수 있다. editdt의 토큰을 쓰거나 null을 확인한다.
- **화면 이동:** 하단 메뉴에서 매번 새 Activity를 시작하고 자기 자신도 다시 열 수 있다. 동일 화면 반복과 뒤로가기 이력이 늘어난다. 명확한 최상위 화면 이동 정책이 필요하다.
- **메뉴 접기:** 펼침/접힘 모두 down 이미지를 지정하므로 상태 표시가 동일하다. 메뉴 자체의 자식 제거/복원 로직은 존재한다.
- **좌석 화면 즐겨찾기 버튼:** 클릭 핸들러가 주석 처리되어 있다.

## 7. 지도, 권한, 화면 리소스

Maps.java는 FusedLocationSource를 지도에 연결하지만 onRequestPermissionsResult 결과를 해당 객체에 전달하지 않는다. 요청 배열의 첫 번째 FINE_LOCATION 결과만 확인하므로 대략적 위치만 허용한 경우도 고려하지 않는다. 권한 전달과 거부 처리 흐름을 보완해야 한다. 마커 6개는 고정 좌표이며 카메라 초기 위치를 매장 영역으로 지정하는 코드도 없다.

XML 60개는 파싱에 성공했다. 이는 XML 문법 검사이며 Android 리소스 링크나 실제 배치 검증은 아니다. 이미지 누락 때문에 UI 실행 검증을 하지 못했다.

XML에서 textSize에 dp를 쓰는 참조 224개와 문자열 직접 지정 233개를 확인했다. 글자 크기는 sp를 사용하고 strings.xml로 이동하는 것이 좋다. 하단 메뉴의 고정 여백, 이벤트의 750dp 영역, 정적 매장 카드 복제는 작은 화면이나 글꼴 확대에서 배치 문제가 발생할 가능성이 있다. 실제 기기별 배치는 별도 확인해야 한다.

## 8. 보안과 운영 범위

입력 앱에 firebase-auth 의존성은 있지만 실제 로그인 호출과 관리자 역할 검사는 없다. 프로젝트 안에서 서버용 Database Security Rules 파일도 찾지 못했다. **따라서 현재 DB가 공개인지, 무단 변경이 가능한지 단정할 수 없다.**

상용화하려면 서버 규칙으로 좌석 쓰기를 매장 관리자에게 제한하고 값·키를 검증해야 한다. 리뷰와 게시판은 작성자 ID를 저장하고 수정/삭제 권한을 구분해야 한다. 앱의 버튼을 숨기는 것으로 서버 접근 제어가 완성되지는 않는다. Firebase 클라이언트 설정 파일의 존재 자체를 관리자 비밀키 유출로 판단하지 않는다.

## 9. 설계 평가와 개선 순서

장점은 앱 간 데이터 공유 흐름이 명확하고, 실시간 구독·지도·리스트 펼침·Fragment·웹뷰를 하나의 사용자 시나리오로 묶었다는 점이다. 별도 입력 앱을 두어 시연용 데이터 변경을 직접 보여줄 수 있다.

한계는 Activity 하나에 화면 이벤트, DB 접근, 파싱, 집계가 모여 있고 좌석 60개의 동일 로직을 복제했다는 점이다. 단일 매장의 고정 UI와 문자열 데이터 구조가 기능 확장을 어렵게 한다. 클래스 이름의 information/cummunity/NOtice 같은 불일치와 사용하지 않는 import/필드도 정리가 필요하다.

권장 순서:

1. **재현 가능 상태 복구:** 누락 리소스 확보, JDK/SDK 경로, Firebase 파일 위치 확인 후 두 앱 assembleDebug.
2. **핵심 연동 안정화:** 없는/잘못된 좌석 데이터 방어, 공통 집계 규칙, 입력 앱 서버 상태 복원, 쓰기 실패 처리.
3. **수명주기 수정:** 리스너 등록/해제 짝 맞추기, 화면 이동 중복 정리.
4. **보이는 기능 완성:** 즐겨찾기 저장/조회, 웹뷰 URL, 기본 이벤트 탭, 지도 권한 처리.
5. **매장/사용자 모델 도입:** /pcrooms/{roomId}/seats, /reviews/{roomId}/{reviewId}, /users/{uid}/favorites처럼 책임을 분리. 기존 데이터 마이그레이션 계획 필요.
6. **유지보수 개선:** Seat/PCroom/Review/Post 모델, Firebase Repository, 공통 좌석 렌더링과 집계, 공통 하단 메뉴. 필요한 범위에서 ViewModel 도입.

처음부터 모든 화면을 다른 프레임워크로 다시 작성할 필요는 없다. 현재 Java/XML 구조에서도 위 결함을 순서대로 고칠 수 있다.

## 10. 검증 결과와 후속 테스트

수행한 검증: 직접 작성 소스/설정 읽기, XML 파싱, 이미지 리소스 참조 대조, 두 앱 좌석 키 60개 대조, 조회 버튼 번호 매핑 검사, Firebase 프로젝트/패키지 설정 확인, Gradle 시작 가능 여부 확인.

기존 테스트는 각 앱의 2+2=4 확인과 패키지 이름 확인이다. 좌석 집계, 동기화, 리뷰, 즐겨찾기, 권한 흐름을 검증하지 않는다. 테스트는 실행되지 않았다.

복구 후 의미 있는 테스트는 다음과 같다.

- 60석 전부 빈자리/전부 사용중/일부 누락/잘못된 타입에서 집계와 표시 확인.
- 입력 앱을 종료하고 재실행해 서버 상태 복원 확인.
- 한 좌석 변경 후 홈·좌석 화면 일치 확인.
- 네트워크 및 읽기/쓰기 권한 실패 시 안내와 입력 보존 확인.
- 화면을 반복 이동해 구독이 누적되지 않는지 확인.
- 위치 거부/대략적 위치 허용, 작은 화면/큰 글꼴 환경 확인.

## 11. 공식 문서 대조

- [Firebase Android 설정과 파일 위치](https://firebase.google.com/docs/android/setup)
- [Google Services 플러그인 설정 파일](https://firebase.google.com/docs/android/google-services-plugin-and-file)
- [Firebase Realtime Database 읽기/쓰기 및 리스너 제거](https://firebase.google.com/docs/database/android/read-and-write)
- [네이버 지도 위치 권한 전달](https://navermaps.github.io/android-map-sdk/guide-ko/4-2.html)

문서와 비교한 항목은 Firebase 구성 파일 위치, 리스너 제거 방식, 네이버 위치 권한 전달이다. 실제 서버의 동작·규칙, 외부 전적 사이트의 현재 웹뷰 호환성, 앱 배포 상태는 조사하지 않았다.
