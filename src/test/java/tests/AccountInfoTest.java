package tests;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pages.account.info.AccountInfoPage;
import pages.account.info.SecureKeyVerifyPage;
import pages.account.info.WithdrawAgreePage;
import pages.account.info.WithdrawRequestPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AccountInfoTest extends BaseTest {

    private SecureKeyVerifyPage secureKeyVerify;
    private AccountInfoPage accountInfo;

    @Before
    public void initPages() {
        secureKeyVerify = new SecureKeyVerifyPage(driver);
        accountInfo = new AccountInfoPage(driver);
    }

    @Test
    public void accountInfoUITest() {

        // 보안키 확인 페이지
        secureKeyVerify.open();
        assertThat(secureKeyVerify.getTitle(), is("계정정보 확인"));
        assertThat(secureKeyVerify.getSubText(), is("안전한 계정정보 관리를 위하여 WebPortal 보안키를 입력해 주세요."));

        assertThat(secureKeyVerify.getSecureKeyTitle(), is("WebPortal 보안 키"));
        assertThat(secureKeyVerify.getSecureKeyInput(), is("WebPortal 보안키"));

        secureKeyVerify.fillSecureKey("135651");
        assertThat(secureKeyVerify.getConfirmBtn(), is("확인"));
        secureKeyVerify.clickConfirmBtn();
        assertThat(secureKeyVerify.getErrorMessage(), is("보안키가 올바르지 않습니다."));

        secureKeyVerify.fillSecureKey("112233");
        secureKeyVerify.clickConfirmBtn();


        // 계정정보 페이지
        assertThat(accountInfo.getTitle(), is("계정정보"));

        // 계정정보 페이지 > 계정
        assertThat(accountInfo.getAccountTitle(), is("WebPortal 계정"));
        assertThat(accountInfo.getAccountText(), is("example@gmail.com"));
        assertThat(accountInfo.getSignupTime(), is("2021-11-15 14:01:32 가입"));
        assertThat(accountInfo.getSignupRegion(), is("대한민국"));

        // 계정정보 페이지 > 닉네임
        assertThat(accountInfo.getNicknameTitle(), is("닉네임"));
        assertThat(accountInfo.getNickname(), is("nick ( UID : 111111 )"));

        // 계정정보 페이지 > 이름
        assertThat(accountInfo.getNameTitle(), is("이름"));
        assertThat(accountInfo.getName(), is("김*수"));

        // 계정정보 페이지 > 생년월일
        assertThat(accountInfo.getBirthTitle(), is("생년월일"));
        assertThat(accountInfo.getBirth(), is("1999-12-31"));

        // 계정정보 페이지 > 본인확인
        assertThat(accountInfo.getIdentifyTitle(), is("본인확인"));
        assertThat(accountInfo.getIdentify(), is("본인확인 완료"));

        // 계정정보 페이지 > 최근 로그인 정보
        assertThat(accountInfo.getRecentLoginInfoTitle(), is("최근 로그인 정보"));
        assertThat(accountInfo.getRecentIP(), is("11.11.111.111"));
        assertThat(accountInfo.getRecentRegion(), is("대한민국"));

        // 계정정보 페이지 > 이벤트 정보 수신 동의
        assertThat(accountInfo.getReceiveEventInfoTitle(), is("이벤트 정보 수신 동의"));
        assertThat(accountInfo.getReceiveEventInfoSubText(), is("WebPortal 서비스 소식, 이벤트, 광고관련 안내를 수신하겠습니다."));

        accountInfo.clickEventInfoToggle();
        assertThat(accountInfo.getModalTitle(), is("이벤트 수신 정보 안내"));
        assertThat(accountInfo.getModalText(), is("WebPortal의 이벤트 정보 알림 수신에 동의하였습니다.\\\\n(2025. 1. 1)"));
        accountInfo.clickModalBtn();

        accountInfo.clickEventInfoToggle();
        assertThat(accountInfo.getModalTitle(), is("이벤트 수신 정보 안내"));
        assertThat(accountInfo.getModalText(), is("WebPortal의 이벤트 정보 알림 수신을 거부하였습니다.\\\\n(2025. 1. 1)\\\\n\\\\n* 중요 공지사항 및 이벤트 당첨 안내 등은\\\\n알림 설정에 관계없이 발송됩니다."));
        accountInfo.clickModalBtn();

        // 계정정보 페이지 > 시간대 설정
        assertThat(accountInfo.getTimezoneTitle(), is("시간대 설정"));

        assertThat(accountInfo.getTimezoneUTC(), is("협정세계시 (UTC+0)"));
        assertThat(accountInfo.getModalTitle(), is("기준 시간대가 변경되었습니다."));
        accountInfo.clickModalBtn();

        assertThat(accountInfo.getTimezoneKorea(), is("대한민국 표준시 (UTC+9) 서울"));
        assertThat(accountInfo.getModalTitle(), is("기준 시간대가 변경되었습니다."));
        accountInfo.clickModalBtn();


        // ===== 회원탈퇴 =====
        assertThat(accountInfo.getWithdrawBtn(), is("WebPortal 회원 탈퇴"));
    }

    @Test
    public void withdrawUITest() {

        WithdrawAgreePage withdrawAgreePage = new WithdrawAgreePage(driver);

        withdrawAgreePage.open();

        assertThat(withdrawAgreePage.getTitle(), is("회원탈퇴 신청"));
        assertThat(withdrawAgreePage.getSubText(), is("회원탈퇴 시 안내사항 및 안내를 반드시 읽고 진행해 주세요."));
        assertThat(withdrawAgreePage.getAgreeBtn(), is("안내사항을 모두 확인하였으며, 이에 동의합니다."));
        assertThat(withdrawAgreePage.getCancelBtn(), is("취소"));
        assertThat(withdrawAgreePage.getRequestBtn(), is("회원탈퇴 신청"));
    }

    @Test
    public void secureKeyValidation() {

        SecureKeyVerifyPage secureKeyVerify = new SecureKeyVerifyPage(driver);
        AccountInfoPage accountInfo = new AccountInfoPage(driver);

        // 잘못된 보안키
        secureKeyVerify.fillSecureKey("135651");
        secureKeyVerify.clickConfirmBtn();
        assertThat(secureKeyVerify.getErrorMessage(), is("보안키가 올바르지 않습니다."));

        // 올바른 보안키
        secureKeyVerify.fillSecureKey("112233");
        secureKeyVerify.clickConfirmBtn();

        // 올바른 보안키 > 계정정보 페이지로 이동
        assertThat(accountInfo.getTitle(), is("계정정보"));
    }

    @Test
    public void agreementToggleFlow() {

        AccountInfoPage accountInfo = new AccountInfoPage(driver);

        accountInfo.open();

        // 이벤트 정보 수신 동의
        accountInfo.clickEventInfoToggle();
        assertThat(accountInfo.getModalTitle(), is("이벤트 수신 정보 안내"));
        accountInfo.clickModalBtn();

        // 이벤트 정보 수신 동의 해제
        accountInfo.clickEventInfoToggle();
        assertThat(accountInfo.getModalTitle(), is("이벤트 수신 정보 안내"));
        accountInfo.clickModalBtn();
    }

    @Test
    public void timezoneChangeFlow() {

        AccountInfoPage accountInfo = new AccountInfoPage(driver);

        accountInfo.open();

        // 기준 시간대 UTC로 변경
        accountInfo.clickTimezoneUTC();
        assertThat(accountInfo.getModalTitle(), is("기준 시간대가 변경되었습니다."));
        accountInfo.clickModalBtn();

        // 기준 시간대 Korea로 변경
        accountInfo.clickTimezoneKorea();
        assertThat(accountInfo.getModalTitle(), is("기준 시간대가 변경되었습니다."));
        accountInfo.clickModalBtn();
    }

    @Test
    public void withdrawCancelFlow() {

        WithdrawAgreePage withdrawAgreePage = new WithdrawAgreePage(driver);
        SecureKeyVerifyPage secureKeyVerifyPage = new SecureKeyVerifyPage(driver);

        withdrawAgreePage.open();

        withdrawAgreePage.clickCancelBtn();

        assertThat(secureKeyVerifyPage.getTitle(), is("계정정보 확인"));
    }

    @Test
    public void withdrawRequestFlow() {

        WithdrawAgreePage withdrawAgreePage = new WithdrawAgreePage(driver);
        WithdrawRequestPage withdrawRequestPage = new WithdrawRequestPage(driver);

        withdrawAgreePage.open();

        withdrawAgreePage.clickAgreeBtn();
        withdrawAgreePage.clickRequestBtn();

        withdrawRequestPage.fillSecureKey("112233");
        withdrawRequestPage.clickUnregisterBtn();
    }
}
