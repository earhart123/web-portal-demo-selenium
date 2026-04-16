package pages.account.info;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WithdrawAgreePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By withdrawBtn = By.cssSelector("[data-qa='btn-withdrawal']");
    private By modalTitle = By.cssSelector("[data-qa='modal-withdrawal'] h3");
    private By modalText = By.cssSelector("[data-qa='modal-withdrawal'] p");
    private By cancelBtn = By.cssSelector("[data-qa='btn-cancel-withdrawal']");
    private By requestBtn = By.cssSelector("[data-qa='btn-confirm-withdrawal']");

    public WithdrawAgreePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // ===== 공통 기능 =====

    public void open() {
        driver.get(BaseTest.BASE_URL + "/account-info.html");
        wait.until(ExpectedConditions.elementToBeClickable(withdrawBtn));
        driver.findElement(withdrawBtn).click();
    }


    // ===== 모달 내용 =====

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle));
        return driver.findElement(modalTitle).getText();
    }

    public String getSubText() {
        return driver.findElement(modalText).getText();
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
