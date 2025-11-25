package pages.account.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithdrawRequestPage {

    private WebDriver driver;

    private By title = By.cssSelector(".underline");
    private By subText = By.cssSelector(".desc");
    private By secureKeyTitle = By.cssSelector(".input-item > .title");
    private By secureKeyInput = By.cssSelector("label");
    private By unregisterBtn = By.id("unreisterButton");

    public WithdrawRequestPage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== 공통 기능 =====

    public void open() {
        driver.get("https://accounts.example.com/member/unregister/request");
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getSubText() {
        return driver.findElement(subText).getText();
    }


    // ===== 보안키 =====

    public void fillSecureKey(String secureKey) {
        driver.findElement(secureKeyInput).clear();
        driver.findElement(secureKeyInput).sendKeys(secureKey);
    }


    // ===== 신청 버튼 =====

    public String getUnregisterBtn() {
        return driver.findElement(unregisterBtn).getText();
    }

    public void clickUnregisterBtn() {
        driver.findElement(unregisterBtn).click();
    }
}
