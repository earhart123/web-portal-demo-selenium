package pages.account.security;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountSecurityPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By title = By.cssSelector("[data-qa='account-security-page'] h1");

    // 해외 로그인 설정
    private By overseasLoginTitle = By.cssSelector("[data-qa='section-overseas-login'] h2");
    private By overseasLoginStatusBadge = By.cssSelector("[data-qa='overseas-login-status-badge']");
    private By overseasLoginToggle = By.cssSelector("[data-qa='toggle-overseas-login']");
    private By overseasLoginStatus = By.cssSelector("[data-qa='overseas-login-status']");

    // 최근 로그인 이력
    private By loginHistoryTitle = By.cssSelector("[data-qa='section-login-history'] h2");
    private By loginHistoryList = By.cssSelector("[data-qa='login-history-list']");

    // 비밀번호 변경
    private By changePasswordTitle = By.cssSelector("[data-qa='section-change-password'] h2");
    private By currentPasswordInput = By.cssSelector("[data-qa='current-password']");
    private By newPasswordInput = By.cssSelector("[data-qa='new-password']");
    private By newPasswordConfirmInput = By.cssSelector("[data-qa='new-password-confirm']");
    private By changePasswordBtn = By.cssSelector("[data-qa='btn-change-password']");
    private By changePasswordResult = By.cssSelector("[data-qa='change-password-result']");


    public AccountSecurityPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    // ===== 공통 기능 =====

    public void open() {
        driver.get(BaseTest.BASE_URL + "/account-security.html");
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }


    // ===== 해외 로그인 설정 =====

    public String getOverseasLoginTitle() {
        return driver.findElement(overseasLoginTitle).getText();
    }

    public String getOverseasLoginStatusBadge() {
        return driver.findElement(overseasLoginStatusBadge).getText();
    }

    public void clickOverseasLoginToggle() {
    WebElement toggle = driver.findElement(overseasLoginToggle);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", toggle);
    }

    public String getOverseasLoginStatus() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(overseasLoginStatus));
        return driver.findElement(overseasLoginStatus).getText();
    }


    // ===== 최근 로그인 이력 =====

    public String getLoginHistoryTitle() {
        return driver.findElement(loginHistoryTitle).getText();
    }

    public int getLoginHistoryCount() {
        return driver.findElements(By.cssSelector("[data-qa='history-item']")).size();
    }


    // ===== 비밀번호 변경 =====

    public String getChangePasswordTitle() {
        return driver.findElement(changePasswordTitle).getText();
    }

    public void fillCurrentPassword(String password) {
        driver.findElement(currentPasswordInput).sendKeys(password);
    }

    public void fillNewPassword(String password) {
        driver.findElement(newPasswordInput).sendKeys(password);
    }

    public void fillNewPasswordConfirm(String password) {
        driver.findElement(newPasswordConfirmInput).sendKeys(password);
    }

    public void clickChangePasswordBtn() {
        driver.findElement(changePasswordBtn).click();
    }

    public String getChangePasswordResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(changePasswordResult));
        return driver.findElement(changePasswordResult).getText();
    }
}
