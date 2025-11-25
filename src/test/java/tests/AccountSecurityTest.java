package tests;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pages.account.security.AccountSecurityPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AccountSecurityTest extends BaseTest {

    private AccountSecurityPage accountSecurityPage;

    @Before
    public void initPages() {
        accountSecurityPage = new AccountSecurityPage(driver);
    }

    @Test
    public void accountSecurityUITest() {

        // 계정보안 페이지
        accountSecurityPage.open();
        assertThat(accountSecurityPage.getTitle(), is("계정보안"));

        // 비밀번호
        assertThat(accountSecurityPage.getPasswordTitle(), is("비밀번호"));
        assertThat(accountSecurityPage.getPasswordDate(), is("마지막 변경일 : 2025-11-11 14:01:32"));
        assertThat(accountSecurityPage.getPasswordBtn(), is("변경하기"));
        accountSecurityPage.clickPasswordBtn();

        // 보안키
        accountSecurityPage.open();
        assertThat(accountSecurityPage.getSecureKeyTitle(), is("WebPortal 보안 키"));
        assertThat(accountSecurityPage.getSecureKeyDate(), is("마지막 변경일 : 2025-1-1 14:01:32"));
        assertThat(accountSecurityPage.getSecureKeyBtn(), is("변경하기"));
        accountSecurityPage.clickSecureKeyBtn();

        // OTP
        accountSecurityPage.open();
        assertThat(accountSecurityPage.getOtpTitle(), is("OTP"));
        assertThat(accountSecurityPage.getOtpSubText(), is("일회용 비밀번호를 입력하는 이중 보안 서비스"));
        assertThat(accountSecurityPage.getOtpBtn(), is("이용하기"));
        accountSecurityPage.clickOtpBtn();

        // 로그인 기록
        accountSecurityPage.open();
        assertThat(accountSecurityPage.getLoginHistoryTitle(), is("로그인 기록"));
        assertThat(accountSecurityPage.getLoginHistorySubText(), is("계정의 로그인 이력을 확인할 수 있습니다."));
        assertThat(accountSecurityPage.getLoginHistoryBtn(), is("확인하기"));
        accountSecurityPage.clickLoginHistoryBtn();

        // 현재 로그인 정보
        accountSecurityPage.open();
        assertThat(accountSecurityPage.getCurrentLoginTitle(), is("현재 로그인 정보"));
        assertThat(accountSecurityPage.getCurrentLoginSubText(), is("로그인 기기 정보를 확인하고 접속 중인 로그인 상태를 변경할 수 있습니다."));
        assertThat(accountSecurityPage.getCurrentLoginBtn(), is("확인하기"));
        accountSecurityPage.clickCurrentLoginBtn();

        // 해외 로그인 허용, 차단
        accountSecurityPage.open();
        assertThat(accountSecurityPage.getOverseasLoginTitle(), is("해외 로그인 허용"));
        assertThat(accountSecurityPage.getOverseasLoginSubText(), is("모든 국가에서 로그인할 수 있도록 해외 로그인을 허용합니다."));
        accountSecurityPage.clickOverseasLoginToggle();

        // 해외 로그인 허용 모달
        assertThat(accountSecurityPage.getOverseasAllowModalTitle(), is("해외 로그인 허용"));
        assertThat(accountSecurityPage.getOverseasAllowModalSubText(), is("해외 로그인 차단을 해제하였습니다"));
        assertThat(accountSecurityPage.getOverseasAllowModalText(), is("모든 국가에서 보안인증 없이 로그인할 수 있습니다."));
        assertThat(accountSecurityPage.getOverseasAllowModalBtn(), is("확인"));
        accountSecurityPage.clickOverseasLoginOnModalBtn();

        // 해외 로그인 차단 모달
        assertThat(accountSecurityPage.getOverseasBlockModalTitle(), is("해외 로그인 차단"));
        assertThat(accountSecurityPage.getOverseasBlockModalSubText(), is("해외 로그인 차단을 설정하였습니다."));
        assertThat(accountSecurityPage.getOverseasBlockModalText(), is("해외에서 로그인을 시도하는 경우 보안인증 후\\\\n로그인이 가능합니다."));
        assertThat(accountSecurityPage.getOverseasBlockModalBtn(), is("확인"));
        accountSecurityPage.clickOverseasLoginOffModalBtn();
    }
}
