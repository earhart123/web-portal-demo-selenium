package pages.signup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupInfoPage {

    private WebDriver driver;

    private By title = By.cssSelector(".text-align-center:nth-child(1)");
    private By subText = By.cssSelector(".desc > p");
    private By emailInput = By.id("email");
    private By emailConfirmBtn = By.cssSelector("#sendBtn > span");
    private By nicknameInput = By.id("nickname");
    private By nicknameError = By.cssSelector(".mb-6 > .error-tip");
    private By passwordInput = By.id("password");
    private By passwordConfirmInput = By.id("passwordConfirm");
    private By secureKeyInput = By.id("secureKey");
    private By secureKeyConfirmInput = By.id("secureKeyConfirm");
    private By registerBtn = By.id("registBtn");
    private By wrap = By.id("wrap");

    public SignupInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getSubText() {
        return driver.findElement(subText).getText();
    }
    
    // ===== 이메일 =====
    
    public String getEmailTitle() {
        return driver.findElement(By.cssSelector(".mb-2 > .input-item > .title")).getText();
    }

    public void fillEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(wrap).click();
    }

    public String getEmailError() {
        return driver.findElement(By.cssSelector(".mb-2 > .input-item > .error-tip")).getText();
    }

    public String getEmailConfirmBtn() {
        return driver.findElement(emailConfirmBtn).getText();
    }

    // ===== 닉네임 =====
    
    public String getNicknameTitle() {
        return driver.findElement(By.cssSelector(".mb-6 > .title")).getText();
    }

    public String getNicknameInput() {
        return driver.findElement(By.cssSelector(".mb-6 label")).getText();
    }

    public void fillNickname(String nickname) {
        driver.findElement(nicknameInput).clear();
        driver.findElement(nicknameInput).sendKeys(nickname);
        driver.findElement(wrap).click();
    }

    public String getNicknameError() {
        return driver.findElement(nicknameError).getText();
    }

    public String waitForNicknameError() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nicknameError));
        return errorElement.getText();
    }
    
    // ===== 비밀번호 =====

    public String getPasswordTitle() {
        return driver.findElement(By.cssSelector(".mb-5 .title")).getText();
    }

    public String getPasswordInput() {
        return driver.findElement(By.cssSelector(".mb-5 > .mb-2 label")).getText();
    }

    public void fillPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(wrap).click();
    }

    public String getPasswordError() {
        return driver.findElement(By.cssSelector(".mb-5 > .mb-2 > .error-tip")).getText();
    }

    public String getPasswordConfirmInput() {
        return driver.findElement(By.cssSelector(".mb-5 > .input-item:nth-child(2) label")).getText();
    }

    public void fillPasswordConfirm(String pw) {
        driver.findElement(passwordConfirmInput).clear();
        driver.findElement(passwordConfirmInput).sendKeys(pw);
        driver.findElement(wrap).click();
    }

    public String getPasswordConfirmError() {
        return driver.findElement(By.cssSelector(".mb-5 > .input-item:nth-child(2) > .error-tip")).getText();
    }

    public String getPasswordTip() {
        return driver.findElement(By.cssSelector(".error-tip-grayed")).getText();
    }
    
    // ===== 보안키 =====

    public String getSecureKeyTitle() {
        return driver.findElement(By.cssSelector(".tip")).getText();
    }

    public String getSecureKeyInput() {
        return driver.findElement(By.cssSelector(".input-wrapper:nth-child(4) > .mb-2 label")).getText();
    }

    public void fillSecureKey(String key) {
        driver.findElement(secureKeyInput).clear();
        driver.findElement(secureKeyInput).sendKeys(key);
        driver.findElement(wrap).click();
    }

    public String getSecureKeyError() {
        return driver.findElement(By.cssSelector(".input-wrapper:nth-child(4) > .mb-2 > .error-tip")).getText();
    }

    public String getSecureKeyConfirmInput() {
        return driver.findElement(By.cssSelector(".input-wrapper:nth-child(4) > .input-item:nth-child(2) label")).getText();
    }

    public void fillSecureKeyConfirm(String key) {
        driver.findElement(secureKeyConfirmInput).clear();
        driver.findElement(secureKeyConfirmInput).sendKeys(key);
        driver.findElement(wrap).click();
    }

    public String getSecureKeyConfirmError() {
        return driver.findElement(By.cssSelector(".input-wrapper:nth-child(4) > .input-item:nth-child(2) > .error-tip")).getText();
    }

    public String getRegisterBtn() {
        return driver.findElement(registerBtn).getText();
    }
}
