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

        // 비밀번호 재설정
        assertThat(login.getResetPasswordBtn(), is("비밀번호 재설정"));
        login.clickResetPasswordBtn();
        assertThat(resetPassword.getTitle(), is("비밀번호 재설정"));


        // 로그인
        login.open();

        // 로그인 실패 > 비밀번호 불일치
        login.fillEmail("example@gmail.com");
        login.fillPassword("password");
        login.clickLoginBtn();
        assertThat(login.getErrorMessage(), is("WebPortal 계정 혹은 비밀번호가 일치하지 않습니다."));

        // 로그인 성공
        login.fillPassword("password7");
        assertThat(login.getLoginBtn(), is("로그인"));
        login.clickLoginBtn();
    }

    @Test
    public void loginFail() {

        LoginPage login = new LoginPage(driver);

        login.open();

        login.fillEmail("example@gmail.com");
        login.fillPassword("password");
        login.clickLoginBtn();
        assertThat(login.getErrorMessage(), is("WebPortal 계정 혹은 비밀번호가 일치하지 않습니다."));
    }

    @Test
    public void loginSuccess() {

        LoginPage login = new LoginPage(driver);

        login.open();

        login.fillEmail("example@gmail.com");
        login.fillPassword("password7");
        login.clickLoginBtn();
        assertThat(driver.getCurrentUrl(), is("https://www.example.com/"));
    }
}
