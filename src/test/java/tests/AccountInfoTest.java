package tests;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pages.account.info.AccountInfoPage;
import pages.account.info.SecureKeyVerifyPage;
import pages.account.info.WithdrawAgreePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
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

        // 계정정보 페이지
        accountInfo.open();
        assertThat(accountInfo.getTitle(), is("계정정보"));

        // 기본 정보 섹션
        assertThat(accountInfo.getBasicInfoTitle(), is("기본 정보"));
        assertThat(accountInfo.getAccountEmail(), is("test@gameportal.com"));
        assertThat(accountInfo.getAccountCreatedAt(), is("2024-01-15"));
        assertThat(accountInfo.getAccountStatus(), is("정상"));

        // 보안키 검증 섹션
        assertThat(accountInfo.getSecurityKeyTitle(), is("보안키 검증"));
        assertThat(accountInfo.getVerifyKeyBtn(), is("확인"));

        // 이벤트 정보 수신 동의 섹션
        assertThat(accountInfo.getEventNotificationTitle(), is("이벤트 정보 수신 동의"));
        assertThat(accountInfo.getEventNotificationStatus(), is("동의 안함"));

        // 기준 시간대 섹션
        assertThat(accountInfo.getTimezoneTitle(), is("기준 시간대"));

        // 회원 탈퇴 섹션
        assertThat(accountInfo.getWithdrawalTitle(), is("회원 탈퇴"));
        assertThat(accountInfo.getWithdrawBtnText(), is("회원 탈퇴 신청"));
    }

    @Test
    public void withdrawUITest() {

        WithdrawAgreePage withdrawAgreePage = new WithdrawAgreePage(driver);

        withdrawAgreePage.open();

        assertThat(withdrawAgreePage.getTitle(), is("정말 탈퇴하시겠습니까?"));
        assertThat(withdrawAgreePage.getSubText(), is("탈퇴 후에는 계정을 복구할 수 없으며, 모든 데이터가 삭제됩니다."));
        assertThat(withdrawAgreePage.getCancelBtn(), is("취소"));
        assertThat(withdrawAgreePage.getRequestBtn(), is("탈퇴 신청"));
    }

    @Test
    public void secureKeyValidation() {

        accountInfo.open();

        // 잘못된 보안키
        accountInfo.fillSecurityKey("wrongkey");
        accountInfo.clickVerifyKey();
        assertThat(accountInfo.getVerifyKeyResult(), is("보안키가 올바르지 않습니다."));

        // 올바른 보안키
        accountInfo.fillSecurityKey("secret123");
        accountInfo.clickVerifyKey();
        assertThat(accountInfo.getVerifyKeyResult(), is("보안키가 확인되었습니다."));
    }

    @Test
    public void agreementToggleFlow() {

        accountInfo.open();

        // 초기 상태: 동의 안함
        assertThat(accountInfo.getEventNotificationStatus(), is("동의 안함"));

        // 이벤트 정보 수신 동의
        accountInfo.clickEventInfoToggle();
        assertThat(accountInfo.getEventNotificationStatus(), is("동의함"));

        // 이벤트 정보 수신 동의 해제
        accountInfo.clickEventInfoToggle();
        assertThat(accountInfo.getEventNotificationStatus(), is("동의 안함"));
    }

    @Test
    public void timezoneChangeFlow() {

        accountInfo.open();

        // 기준 시간대 Tokyo로 변경 후 저장
        accountInfo.selectTimezone("Asia/Tokyo");
        accountInfo.clickSaveTimezone();
        assertThat(accountInfo.getTimezoneSaveResult(), is("시간대가 저장되었습니다."));

        // 기준 시간대 Seoul로 변경 후 저장
        accountInfo.selectTimezone("Asia/Seoul");
        accountInfo.clickSaveTimezone();
        assertThat(accountInfo.getTimezoneSaveResult(), is("시간대가 저장되었습니다."));
    }

    @Test
    public void withdrawCancelFlow() {

        WithdrawAgreePage withdrawAgreePage = new WithdrawAgreePage(driver);

        withdrawAgreePage.open();

        // 취소 클릭 시 모달 닫힘, 계정정보 페이지 유지
        withdrawAgreePage.clickCancelBtn();
        assertThat(accountInfo.getTitle(), is("계정정보"));
    }

    @Test
    public void withdrawRequestFlow() {

        WithdrawAgreePage withdrawAgreePage = new WithdrawAgreePage(driver);

        withdrawAgreePage.open();

        // 탈퇴 신청 확인 클릭 > 로그인 페이지로 이동
        withdrawAgreePage.clickRequestBtn();
        assertThat(driver.getCurrentUrl(), containsString("login.html"));
    }
}
