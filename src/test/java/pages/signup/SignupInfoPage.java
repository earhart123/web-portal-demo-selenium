package pages.signup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupInfoPage {

    private WebDriver driver;

    private By title = By.cssSelector("[data-qa='step-info'] h1");
    private By emailInput = By.cssSelector("[data-qa='signup-email']");
    private By emailValidation = By.id("email-validation");
    private By passwordInput = By.cssSelector("[data-qa='signup-password']");
    private By passwordValidation = By.id("password-validation");
    private By passwordConfirmInput = By.cssSelector("[data-qa='signup-password-confirm']");
    private By passwordConfirmValidation = By.id("password-confirm-validation");
    private By securityKeyInput = By.cssSelector("[data-qa='signup-security-key']");
    private By securityKeyValidation = By.id("security-key-validation");
    private By registerBtn = By.cssSelector("[data-qa='btn-info-submit']");
    private By completeTitle = By.cssSelector("[data-qa='step-complete'] h1");

    public SignupInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }


    // ===== 이메일 =====

    public void fillEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public String getEmailValidation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailValidation));
        return driver.findElement(emailValidation).getText();
    }


    // ===== 비밀번호 =====

    public void fillPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public String getPasswordValidation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordValidation));
        return driver.findElement(passwordValidation).getText();
    }


    // ===== 비밀번호 확인 =====

    public void fillPasswordConfirm(String password) {
        driver.findElement(passwordConfirmInput).clear();
        driver.findElement(passwordConfirmInput).sendKeys(password);
    }

    public String getPasswordConfirmValidation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordConfirmValidation));
        return driver.findElement(passwordConfirmValidation).getText();
    }


    // ===== 보안키 =====

    public void fillSecurityKey(String key) {
        driver.findElement(securityKeyInput).clear();
        driver.findElement(securityKeyInput).sendKeys(key);
    }

    public String getSecurityKeyValidation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(securityKeyValidation));
        return driver.findElement(securityKeyValidation).getText();
    }


    // ===== 가입하기 버튼 =====

    public String getRegisterBtn() {
        return driver.findElement(registerBtn).getText();
    }

    public void clickRegisterBtn() {
        driver.findElement(registerBtn).click();
    }


    // ===== 가입 완료 =====

    public String getCompleteTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeTitle));
        return driver.findElement(completeTitle).getText();
    }
}
