package pages.login;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By title = By.tagName("h1");
    private By loginBtn = By.cssSelector("[data-qa='login-submit']");
    private By emailLabel = By.cssSelector("label[for='email']");
    private By emailInput = By.cssSelector("[data-qa='login-email']");
    private By passwordLabel = By.cssSelector("label[for='password']");
    private By passwordInput = By.cssSelector("[data-qa='login-password']");
    private By resetPasswordBtn = By.cssSelector("[data-qa='link-password-reset']");
    private By errorTip = By.cssSelector("[data-qa='login-error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(BaseTest.BASE_URL + "/login.html");
    }


    public String getLoginTitle() {
        return driver.findElement(title).getText();
    }

    public String getLoginBtn() {
        return driver.findElement(loginBtn).getText();
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }


    // ===== 비밀번호 재설정 =====

    public String getResetPasswordBtn() {
        return driver.findElement(resetPasswordBtn).getText();
    }

    public void clickResetPasswordBtn() {
        driver.findElement(resetPasswordBtn).click();
    }


    // ===== 이메일 =====

    public String getEmail() {
        return driver.findElement(emailLabel).getText();
    }

    public void fillEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }


    // ===== 비밀번호 =====

    public String getPassword() {
        return driver.findElement(passwordLabel).getText();
    }

    public void fillPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }


    // ===== 에러메시지 =====

    public String getErrorMessage() {
        return driver.findElement(errorTip).getText();
    }
}
