package pages.account.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureKeyVerifyPage {

    private WebDriver driver;

    private By title = By.cssSelector(".underline");
    private By subText = By.cssSelector(".desc");
    private By secureKeyTitle = By.cssSelector(".input-item > .title");
    private By secureKeyInput = By.cssSelector("label");
    private By errorTip = By.cssSelector(".error-tip");
    private By confirmBtn = By.cssSelector(".btn-primary");

    public SecureKeyVerifyPage(WebDriver driver) {
        this.driver = driver;
    }


    // ===== 공통 기능 =====

    public void open() {
        driver.get("https://accounts.webportal.com/member/manage/account");
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getSubText() {
        return driver.findElement(subText).getText();
    }

    // ===== 보안키 =====

    public String getSecureKeyTitle() {
        return driver.findElement(secureKeyTitle).getText();
    }

    public String getSecureKeyInput() {
        return driver.findElement(secureKeyInput).getText();
    }

    public void fillSecureKey(String secureKey) {
        driver.findElement(secureKeyInput).clear();
        driver.findElement(secureKeyInput).sendKeys(secureKey);
    }


    // ===== 에러메시지 =====

    public String getErrorMessage() {
        return driver.findElement(errorTip).getText();
    }


    // ===== 확인 버튼 =====

    public String getConfirmBtn() {
        return driver.findElement(confirmBtn).getText();
    }

    public void clickConfirmBtn() {
        driver.findElement(confirmBtn).click();
    }
}
