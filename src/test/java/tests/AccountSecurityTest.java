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

        // 해외 로그인 설정 섹션
        assertThat(accountSecurityPage.getOverseasLoginTitle(), is("해외 로그인 설정"));
        assertThat(accountSecurityPage.getOverseasLoginStatusBadge(), is("차단됨"));

        // 해외 로그인 허용으로 전환
        accountSecurityPage.clickOverseasLoginToggle();
        assertThat(accountSecurityPage.getOverseasLoginStatusBadge(), is("허용됨"));
        assertThat(accountSecurityPage.getOverseasLoginStatus(), is("해외 로그인이 허용되었습니다."));

        // 해외 로그인 차단으로 전환
        accountSecurityPage.clickOverseasLoginToggle();
        assertThat(accountSecurityPage.getOverseasLoginStatusBadge(), is("차단됨"));
        assertThat(accountSecurityPage.getOverseasLoginStatus(), is("해외 로그인이 차단되었습니다."));

        // 최근 로그인 이력 섹션
        assertThat(accountSecurityPage.getLoginHistoryTitle(), is("최근 로그인 이력"));
        assertThat(accountSecurityPage.getLoginHistoryCount(), is(3));

        // 비밀번호 변경 섹션
        assertThat(accountSecurityPage.getChangePasswordTitle(), is("비밀번호 변경"));

        // 비밀번호 불일치 시 오류 메시지
        accountSecurityPage.fillCurrentPassword("currentpass");
        accountSecurityPage.fillNewPassword("newpass123!");
        accountSecurityPage.fillNewPasswordConfirm("differentpass");
        accountSecurityPage.clickChangePasswordBtn();
        assertThat(accountSecurityPage.getChangePasswordResult(), is("새 비밀번호가 일치하지 않습니다."));
    }
}
