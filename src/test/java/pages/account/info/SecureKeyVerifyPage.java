package pages.account.info;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecureKeyVerifyPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By securityKeyInput = By.cssSelector("[data-qa='input-security-key']");
    private By confirmBtn = By.cssSelector("[data-qa='btn-verify-key']");
    private By verifyResult = By.cssSelector("[data-qa='verify-key-result']");

    public SecureKeyVerifyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    // ===== 공통 기능 =====

    public void open() {
        driver.get(BaseTest.BASE_URL + "/account-info.html");
    }


    // ===== 보안키 =====

    public void fillSecureKey(String secureKey) {
        driver.findElement(securityKeyInput).clear();
        driver.findElement(securityKeyInput).sendKeys(secureKey);
    }


    // ===== 확인 버튼 =====

    public String getConfirmBtn() {
        return driver.findElement(confirmBtn).getText();
    }

    public void clickConfirmBtn() {
        driver.findElement(confirmBtn).click();
    }


    // ===== 검증 결과 =====

    public String getVerifyResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyResult));
        return driver.findElement(verifyResult).getText();
    }

    public String getErrorMessage() {
        return getVerifyResult();
    }
}
