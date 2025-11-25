# Web portal demo selenium

## 프로젝트 소개

#### web portal 계정/보안 페이지 UI 테스트 자동화 프로젝트<br>

이 프로젝트는 포트폴리오용 예제로, 사이트 이름은 임의로 설정했습니다.<br><br>

이 프로젝트는 Selenium IDE 녹화 기반 코드를 시작으로 **Page Object 패턴, 
JUnit 기반 테스트 구조화, 테스트 시나리오 분리, 
JUnit XML 보고서 생성** 등을 적용하여 
확장 가능한 자동화 테스트 프레임워크로 발전시켰습니다.<br><br>
> ⚠️ 현재 데모 웹사이트를 대상으로 테스트를 진행하였기 때문에, <br>
GitHub Actions CI에서 실행 시 모든 테스트가 실패하였음을 참고해주세요.
<br>

## 적용 기술

| 기술                         | 설명                                          |
|:-----------------------------|:----------------------------------------------|
| Java 17                      | 테스트 코드 작성 언어                          |
| JUnit4                       | 테스트 프레임워크                              |
| Selenium WebDriver           | 브라우저 자동화                                |
| Page Object Model (POM)      | 페이지 요소를 객체화하여 관리                   |
| Gradle                       | 의존성 및 빌드 관리                            |
| Github Actions (CI)          | 테스트 자동 실행                               |
| JUnit XML                    | 테스트 실행 결과 기록 및 GitHub Actions 연동    |
| Chrome / ChromeDriver        | 실제 브라우저 테스트 환경                       |

> 참고: ExtentReports는 현재 프로젝트에 연동되어 있지 않습니다. HTML/JUnit XML 보고서를 활용하여 결과를 확인합니다.

<br>

## 테스트 시나리오 설명

- ### 회원가입 시나리오
  - 회원가입 페이지 접속
  - 이메일 회원가입 페이지 > 약관동의 노출 확인
  - 이메일 회원가입 페이지 > 정보입력 정상 동작 확인
  - 이메일 회원가입 페이지 > 비밀번호, 보안키 검증 동작 확인
 
- ### 로그인 시나리오
  - 로그인 페이지 접속
  - 비밀번호 재설정 페이지 접속
  - 로그인 실패/성공 동작
  - 로그인 성공 시 메인 페이지 이동 확인

- ### 계정정보 시나리오
  - 계정정보 페이지 접속 및 UI 확인
  - 보안키 검증
  - 이벤트 정보 수신 동의/해제 동작
  - 기준 시간대 변경
  - 회원탈퇴 취소/신청 동작

- ### 계정보안 시나리오
  - 계정보안 페이지 접속 및 UI 확인
  - 해외 로그인 허용/차단 동작
  <br>
  
 ## 프로젝트 구조
  
  ```
src/test/java
   └─ base        # 테스트 기본 설정 및 WebDriver 초기화
   └─ pages       # Page Object 클래스
   └─ tests       # 시나리오별 테스트 클래스
  build.gradle    # Gradle 빌드/의존성 관리
```

#### 설명
#### 1. BaseTest.java
- WebDriver 설정, Chrome 옵션, 공통 Before/After 메서드 관리
#### 2. pages
- Page Object Model(POM) 구조 적용
- 각 페이지별 패키지(login, signup, account/info, account/security)로 요소와 기능 구현
#### 3. tests
- 실제 JUnit 테스트 케이스 구현
- BaseTest 상속받아 테스트 수행


## GitHub Actions CI 설정
- .github/workflows/test-ci.yml를 통해 자동 테스트 실행 설정
- Gradle + Selenium + ChromeHeadless 환경에서 테스트 실행
- JUnit XML 보고서를 GitHub Actions에서 업로드 및 확인 가능

```
name: Selenium UI Tests

on:
  push:
  pull_request:

permissions:
  contents: read
  checks: write
  pull-requests: write

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v3

      - name: Set up JDK
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'

      - name: Install Chrome
        uses: browser-actions/setup-chrome@v1

      - name: Install ChromeDriver
        uses: nanasess/setup-chromedriver@v2

      - name: Grant execute permission for Gradle Wrapper
        run: chmod +x ./gradlew

      - name: Run Gradle Tests (Headless)
        env:
          HEADLESS: true
        run: ./gradlew test

      - name: List test results
        run: ls -R build/test-results/test/

      - name: Upload Test Reports
        uses: mikepenz/action-junit-report@v5
        if: success() || failure()
        with:
          token: ${{ secrets.GITHUB_TOKEN }}
          report_paths: 'build/test-results/test/TEST-*.xml'
```


> ⚠️ 현재 CI 환경에서는 실제 테스트 대상 웹사이트가 존재하지 않기 때문에 ChromeDriver 세션 생성 실패로 모든 테스트가 실패합니다.

## 테스트 실행 방법

1. 프로젝트 클론
```
git clone <repository-url>
cd web-portal-demo-selenium
```

2. Gradle로 테스트 실행
```
./gradlew test
```

3. 테스트 보고서 확인
- `build/reports/tests/test/index.html`에서 HTML 보고서 확인
- `build/test-results/test/`에서 JUnit XML 보고서 확인
- GitHub Actions 실행 시, Action Logs에서 테스트 결과 확인 가능


## 향후 개선 사항

- 실제 웹 포털을 대상으로 테스트 가능하도록 환경 구성 필요

- JUnit5 전환 시 useJUnitPlatform() 적용 가능

- ExtentReports 연동하여 테스트 스크린샷 및 시각화 보고서 생성

- 데이터 드리븐 테스트로 확장 가능 (CSV, Excel 등 외부 데이터 활용)

- GitHub Actions CI에서 브라우저 버전/드라이버 호환성 체크 필요
