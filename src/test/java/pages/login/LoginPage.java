package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By title = By.cssSelector(".text-align-center");
    private By loginBtn = By.id("loginBtn");
    private By email = By.cssSelector(".input-item:nth-child(2) label");
    private By emailInput = By.id("email");
    private By password = By.cssSelector(".pw > label");
    private By passwordInput = By.id("password");
    private By resetPasswordBtn = By.linkText("비밀번호 재설정");
    private By errorTip = By.cssSelector(".error-tip");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://accounts.example.com/member/login");
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
        return driver.findElement(email).getText();
    }

    public void fillEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }


    // ===== 비밀번호 =====

    public String getPassword() {
        return driver.findElement(password).getText();
    }

    public void fillPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }


    // ===== 에러메시지 =====

    public String getErrorMessage() {
        return driver.findElement(errorTip).getText();
    }
}
