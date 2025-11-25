package pages.account.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithdrawAgreePage {

    private WebDriver driver;

    private By title = By.cssSelector(".title");
    private By subText = By.cssSelector(".desc");
    private By agreeBtn = By.cssSelector("label");
    private By cancelBtn = By.cssSelector(".btn-line");
    private By requestBtn = By.cssSelector("#unregister_button > span");

    public WithdrawAgreePage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== 공통 기능 =====

    public void open() {
        driver.get("https://accounts.example.com/member/unregister/agree");
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getSubText() {
        return driver.findElement(subText).getText();
    }


    // ===== 동의 버튼 =====

    public String getAgreeBtn() {
        return driver.findElement(agreeBtn).getText();
    }

    public void clickAgreeBtn() {
        driver.findElement(agreeBtn).click();
    }

    // ===== 취소 버튼 =====

    public String getCancelBtn() {
        return driver.findElement(cancelBtn).getText();
    }

    public void clickCancelBtn() {
        driver.findElement(cancelBtn).click();
    }

    // ===== 신청 버튼 =====

    public String getRequestBtn() {
        return driver.findElement(requestBtn).getText();
    }

    public void clickRequestBtn() {
        driver.findElement(requestBtn).click();
    }
}
