package pages.account.info;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountInfoPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By title = By.cssSelector("[data-qa='account-info-page'] h1");

    // 기본 정보
    private By basicInfoTitle = By.cssSelector("[data-qa='section-basic-info'] h2");
    private By accountEmail = By.cssSelector("[data-qa='account-email']");
    private By accountCreatedAt = By.cssSelector("[data-qa='account-created-at']");
    private By accountStatus = By.cssSelector("[data-qa='account-status']");

    // 보안키 검증
    private By securityKeyTitle = By.cssSelector("[data-qa='section-security-key'] h2");
    private By securityKeyInput = By.cssSelector("[data-qa='input-security-key']");
    private By verifyKeyBtn = By.cssSelector("[data-qa='btn-verify-key']");
    private By verifyKeyResult = By.cssSelector("[data-qa='verify-key-result']");

    // 이벤트 정보 수신 동의
    private By eventNotificationTitle = By.cssSelector("[data-qa='section-event-notification'] h2");
    private By eventNotificationStatus = By.cssSelector("[data-qa='event-notification-status']");
    private By toggleEventNotification = By.cssSelector("[data-qa='toggle-event-notification']");

    // 기준 시간대
    private By timezoneTitle = By.cssSelector("[data-qa='section-timezone'] h2");
    private By timezoneSelect = By.cssSelector("[data-qa='select-timezone']");
    private By saveTimezoneBtn = By.cssSelector("[data-qa='btn-save-timezone']");
    private By timezoneSaveResult = By.cssSelector("[data-qa='timezone-save-result']");

    // 회원 탈퇴
    private By withdrawalTitle = By.cssSelector("[data-qa='section-withdrawal'] h2");
    private By withdrawBtn = By.cssSelector("[data-qa='btn-withdrawal']");

    // 탈퇴 모달
    private By modalTitle = By.cssSelector("[data-qa='modal-withdrawal'] h3");
    private By modalText = By.cssSelector("[data-qa='modal-withdrawal'] p");
    private By cancelWithdrawBtn = By.cssSelector("[data-qa='btn-cancel-withdrawal']");
    private By confirmWithdrawBtn = By.cssSelector("[data-qa='btn-confirm-withdrawal']");

    public AccountInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    // ===== 공통 =====

    public void open() {
        driver.get(BaseTest.BASE_URL + "/account-info.html");
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }


    // ===== 기본 정보 =====

    public String getBasicInfoTitle() {
        return driver.findElement(basicInfoTitle).getText();
    }

    public String getAccountEmail() {
        return driver.findElement(accountEmail).getText();
    }

    public String getAccountCreatedAt() {
        return driver.findElement(accountCreatedAt).getText();
    }

    public String getAccountStatus() {
        return driver.findElement(accountStatus).getText();
    }


    // ===== 보안키 검증 =====

    public String getSecurityKeyTitle() {
        return driver.findElement(securityKeyTitle).getText();
    }

    public void fillSecurityKey(String key) {
        driver.findElement(securityKeyInput).clear();
        driver.findElement(securityKeyInput).sendKeys(key);
    }

    public String getVerifyKeyBtn() {
        return driver.findElement(verifyKeyBtn).getText();
    }

    public void clickVerifyKey() {
        driver.findElement(verifyKeyBtn).click();
    }

    public String getVerifyKeyResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyKeyResult));
        return driver.findElement(verifyKeyResult).getText();
    }


    // ===== 이벤트 정보 수신 동의 =====

    public String getEventNotificationTitle() {
        return driver.findElement(eventNotificationTitle).getText();
    }

    public String getEventNotificationStatus() {
        return driver.findElement(eventNotificationStatus).getText();
    }

    public void clickEventInfoToggle() {
        driver.findElement(toggleEventNotification).click();
    }


    // ===== 기준 시간대 =====

    public String getTimezoneTitle() {
        return driver.findElement(timezoneTitle).getText();
    }

    public void selectTimezone(String value) {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(driver.findElement(timezoneSelect));
        select.selectByValue(value);
    }

    public void clickSaveTimezone() {
        driver.findElement(saveTimezoneBtn).click();
    }

    public String getTimezoneSaveResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(timezoneSaveResult));
        return driver.findElement(timezoneSaveResult).getText();
    }


    // ===== 회원 탈퇴 =====

    public String getWithdrawalTitle() {
        return driver.findElement(withdrawalTitle).getText();
    }

    public String getWithdrawBtnText() {
        return driver.findElement(withdrawBtn).getText();
    }

    public void clickWithdrawBtn() {
        driver.findElement(withdrawBtn).click();
    }


    // ===== 탈퇴 모달 =====

    public String getModalTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle));
        return driver.findElement(modalTitle).getText();
    }

    public String getModalText() {
        return driver.findElement(modalText).getText();
    }

    public String getCancelWithdrawBtnText() {
        return driver.findElement(cancelWithdrawBtn).getText();
    }

    public String getConfirmWithdrawBtnText() {
        return driver.findElement(confirmWithdrawBtn).getText();
    }

    public void clickCancelWithdraw() {
        driver.findElement(cancelWithdrawBtn).click();
    }

    public void clickConfirmWithdraw() {
        driver.findElement(confirmWithdrawBtn).click();
    }
}
