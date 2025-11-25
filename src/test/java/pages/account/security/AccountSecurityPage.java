package pages.account.security;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSecurityPage {

    private WebDriver driver;

    private By title = By.cssSelector(".underline");
    private By passwordTitle = By.cssSelector("li:nth-child(1) em");
    private By passwordDate = By.cssSelector("li:nth-child(1) p");
    private By passwordBtn = By.cssSelector("#btnPasswordCheck > span:nth-child(1)");
    private By secureKeyTitle = By.cssSelector("li:nth-child(2) em");
    private By secureKeyDate = By.cssSelector("li:nth-child(2) p");
    private By secureKeyBtn = By.cssSelector("#btnSecurekeyCheck > span:nth-child(1)");
    private By otpTitle = By.cssSelector(".d-flex > em");
    private By otpSubText = By.cssSelector("li:nth-child(3) p");
    private By otpBtn = By.cssSelector("#btnOTPUnregist > span:nth-child(1)");
    private By loginHistoryTitle = By.cssSelector("li:nth-child(4) em");
    private By loginHistorySubText = By.cssSelector("li:nth-child(4) p");
    private By loginHistoryBtn = By.cssSelector("#btnLoginHistory > span:nth-child(1)");
    private By currentLoginTitle = By.cssSelector("li:nth-child(5) em");
    private By currentLoginSubText = By.cssSelector("li:nth-child(5) p");
    private By currentLoginBtn = By.cssSelector("#btnSessionCheck > span:nth-child(1)");
    private By overseasLoginTitle = By.cssSelector("li:nth-child(6) em");
    private By overseasLoginSubText = By.cssSelector("li:nth-child(6) p");
    private By overseasLoginToggle = By.cssSelector("#regionIpOn > span");
    private By overseasAllowModalTitle = By.cssSelector("#checkOn .title");
    private By overseasAllowModalSubText = By.cssSelector("#checkOn .text-align-left:nth-child(1)");
    private By overseasAllowModalText = By.cssSelector("#checkOn .desc > .text-align-left:nth-child(2)");
    private By overseasAllowModalBtn = By.cssSelector("#checkOn .btn");
    private By overseasBlockModalTitle = By.cssSelector("#checkOff .title");
    private By overseasBlockModalSubText = By.cssSelector("#checkOff .text-align-left:nth-child(1)");
    private By overseasBlockModalText = By.cssSelector(".blue-second");
    private By overseasBlockModalBtn = By.cssSelector("#checkOff .btn-wrap span");


    public AccountSecurityPage(WebDriver driver) {
        this.driver = driver;
    }


    // ===== 공통 기능 =====

    public void open() {
        driver.get("https://accounts.play2bit.com/member/manage/security");
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }


    // ===== 비밀번호 =====

    public String getPasswordTitle() {
        return driver.findElement(passwordTitle).getText();
    }

    public String getPasswordDate() {
        return driver.findElement(passwordDate).getText();
    }

    public String getPasswordBtn() {
        return driver.findElement(passwordBtn).getText();
    }

    public void clickPasswordBtn() {
        driver.findElement(passwordBtn).click();
    }


    // ===== 보안키 =====

    public String getSecureKeyTitle() {
        return driver.findElement(secureKeyTitle).getText();
    }

    public String getSecureKeyDate() {
        return driver.findElement(secureKeyDate).getText();
    }

    public String getSecureKeyBtn() {
        return driver.findElement(secureKeyBtn).getText();
    }

    public void clickSecureKeyBtn() {
        driver.findElement(secureKeyBtn).click();
    }


    // ===== OTP =====

    public String getOtpTitle() {
        return driver.findElement(otpTitle).getText();
    }

    public String getOtpSubText() {
        return driver.findElement(otpSubText).getText();
    }

    public String getOtpBtn() {
        return driver.findElement(otpBtn).getText();
    }

    public void clickOtpBtn() {
        driver.findElement(otpBtn).click();
    }


    // ===== 로그인 기록 =====

    public String getLoginHistoryTitle() {
        return driver.findElement(loginHistoryTitle).getText();
    }

    public String getLoginHistorySubText() {
        return driver.findElement(loginHistorySubText).getText();
    }

    public String getLoginHistoryBtn() {
        return driver.findElement(loginHistoryBtn).getText();
    }

    public void clickLoginHistoryBtn() {
        driver.findElement(loginHistoryBtn).click();
    }


    // ===== 현재 로그인 정보 =====

    public String getCurrentLoginTitle() {
        return driver.findElement(currentLoginTitle).getText();
    }

    public String getCurrentLoginSubText() {
        return driver.findElement(currentLoginSubText).getText();
    }

    public String getCurrentLoginBtn() {
        return driver.findElement(currentLoginBtn).getText();
    }

    public void clickCurrentLoginBtn() {
        driver.findElement(currentLoginBtn).click();
    }


    // ===== 해외 로그인 허용 =====

    public String getOverseasLoginTitle() {
        return driver.findElement(overseasLoginTitle).getText();
    }

    public String getOverseasLoginSubText() {
        return driver.findElement(overseasLoginSubText).getText();
    }

    public void clickOverseasLoginToggle() {
        driver.findElement(overseasLoginToggle).click();
    }


    // ===== 해외 로그인 허용 모달 =====

    public String getOverseasAllowModalTitle() {
        return driver.findElement(overseasAllowModalTitle).getText();
    }

    public String getOverseasAllowModalSubText() {
        return driver.findElement(overseasAllowModalSubText).getText();
    }

    public String getOverseasAllowModalText() {
        return driver.findElement(overseasAllowModalText).getText();
    }

    public String getOverseasAllowModalBtn() {
        return driver.findElement(overseasAllowModalBtn).getText();
    }

    public void clickOverseasLoginOnModalBtn() {
        driver.findElement(overseasAllowModalBtn).click();
    }


    // ===== 해외 로그인 차단 모달 =====

    public String getOverseasBlockModalTitle() {
        return driver.findElement(overseasBlockModalTitle).getText();
    }

    public String getOverseasBlockModalSubText() {
        return driver.findElement(overseasBlockModalSubText).getText();
    }

    public String getOverseasBlockModalText() {
        return driver.findElement(overseasBlockModalText).getText();
    }

    public String getOverseasBlockModalBtn() {
        return driver.findElement(overseasBlockModalBtn).getText();
    }

    public void clickOverseasLoginOffModalBtn() {
        driver.findElement(overseasBlockModalBtn).click();
    }
}
