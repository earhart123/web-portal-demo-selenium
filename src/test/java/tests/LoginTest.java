package tests;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pages.login.LoginPage;
import pages.login.ResetPasswordPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest {

    private LoginPage login;
    private ResetPasswordPage resetPassword;

    @Before
    public void initPages() {
        login = new LoginPage(driver);
        resetPassword = new ResetPasswordPage(driver);
    }

    @Test
    public void loginFlow() {

        // 로그인 페이지
        login.open();
        assertThat(login.getLoginTitle(), is("로그인"));
        assertThat(login.getEmail(), is("이메일"));
        assertThat(login.getPassword(), is("비밀번호"));

        // 비밀번호 재설정 링크 확인 및 이동
        assertThat(login.getResetPasswordBtn(), is("비밀번호 재설정"));
        login.clickResetPasswordBtn();
        assertThat(resetPassword.getTitle(), is("비밀번호 재설정"));

        // 로그인 페이지로 돌아오기
        login.open();

        // 로그인 실패 > 잘못된 자격증명
        login.fillEmail("wrong@test.com");
        login.fillPassword("wrongpassword");
        assertThat(login.getLoginBtn(), is("로그인"));
        login.clickLoginBtn();
        assertThat(login.getErrorMessage(), is("이메일 또는 비밀번호를 확인해주세요."));
    }

    @Test
    public void loginFail() {

        login.open();

        login.fillEmail("wrong@test.com");
        login.fillPassword("wrongpassword");
        login.clickLoginBtn();
        assertThat(login.getErrorMessage(), is("이메일 또는 비밀번호를 확인해주세요."));
    }

    @Test
    public void loginSuccess() {

        login.open();

        login.fillEmail("test@gameportal.com");
        login.fillPassword("Test1234!");
        login.clickLoginBtn();
        assertThat(driver.getCurrentUrl(), is(BASE_URL + "/main.html"));
    }
}
