package pages.account.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountInfoPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By title = By.cssSelector(".underline");
    private By accountTitle = By.cssSelector("li:nth-child(1) > em");
    private By accountText = By.cssSelector("li:nth-child(1) > .detail > p:nth-child(1)");
    private By signupTime = By.cssSelector("li:nth-child(1) p:nth-child(2)");
    private By signupRegion = By.cssSelector("li:nth-child(1) p:nth-child(3)");
    private By nicknameTitle = By.cssSelector("li:nth-child(2) > em");
    private By nickname = By.cssSelector("li:nth-child(2) > .detail > span");
    private By nameTitle = By.cssSelector("li:nth-child(3) > em");
    private By name = By.cssSelector("form > span");
    private By birthTitle = By.cssSelector("li:nth-child(4) > em");
    private By birth = By.cssSelector("div:nth-child(1) > span");
    private By identifyTitle = By.cssSelector("li:nth-child(5) > em");
    private By identify = By.cssSelector(".detail > .blue");
    private By recentLoginInfoTitle = By.cssSelector("li:nth-child(6) > em");
    private By recentIP = By.cssSelector("li:nth-child(6) p:nth-child(2)");
    private By recentRegion = By.cssSelector("li:nth-child(6) p:nth-child(3)");
    private By receiveEventInfoTitle = By.cssSelector(".title > em");
    private By receiveEventInfoSubText = By.cssSelector(".mt-1");
    private By receiveEventInfoToggle = By.id("checkboxLabel");
    private By timezoneTitle = By.cssSelector(".timezone > em");
    private By timezoneUTC = By.cssSelector(".radio-btn:nth-child(2) > span");
    private By timezoneKorea = By.cssSelector(".radio-btn:nth-child(1) > span");
    private By modalTitle = By.cssSelector("#Play2bitModal .title");
    private By modalText = By.cssSelector(".desc > strong");
    private By modalBtn = By.cssSelector("#Play2bitModal .btn");
    private By withdrawBtn = By.linkText("Play2Bit 회원 탈퇴");

    public AccountInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    // ===== 공통 기능 =====
    public void open() {
        driver.get("https://accounts.play2bit.com/member/manage/account/info?countryCode=KR");
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }


    // ===== 계정 =====
    public String getAccountTitle() {
        return driver.findElement(accountTitle).getText();
    }

    public String getAccountText() {
        return driver.findElement(accountText).getText();
    }

    public String getSignupTime() {
        return driver.findElement(signupTime).getText();
    }

    public String getSignupRegion() {
        return driver.findElement(signupRegion).getText();
    }


    // ===== 닉네임 =====
    public String getNicknameTitle() {
        return driver.findElement(nicknameTitle).getText();
    }

    public String getNickname() {
        return driver.findElement(nickname).getText();
    }


    // ===== 이름 =====
    public String getNameTitle() {
        return driver.findElement(nameTitle).getText();
    }

    public String getName() {
        return driver.findElement(name).getText();
    }


    // ===== 생년월일 =====
    public String getBirthTitle() {
        return driver.findElement(birthTitle).getText();
    }

    public String getBirth() {
        return driver.findElement(birth).getText();
    }


    // ===== 본인확인 =====
    public String getIdentifyTitle() {
        return driver.findElement(identifyTitle).getText();
    }

    public String getIdentify() {
        return driver.findElement(identify).getText();
    }


    // ===== 최근 로그인 정보 =====
    public String getRecentLoginInfoTitle() {
        return driver.findElement(recentLoginInfoTitle).getText();
    }

    public String getRecentIP() {
        return driver.findElement(recentIP).getText();
    }

    public String getRecentRegion() {
        return driver.findElement(recentRegion).getText();
    }


    // ===== 이벤트 정보 수신 =====
    public String getReceiveEventInfoTitle() {
        return driver.findElement(receiveEventInfoTitle).getText();
    }

    public String getReceiveEventInfoSubText() {
        return driver.findElement(receiveEventInfoSubText).getText();
    }

    public void clickEventInfoToggle() {
        driver.findElement(receiveEventInfoToggle).click();
    }


    // ===== 시간대 설정 =====
    public String getTimezoneTitle() {
        return driver.findElement(timezoneTitle).getText();
    }

    public String getTimezoneUTC() {
        return driver.findElement(timezoneUTC).getText();
    }

    public void clickTimezoneUTC() {
        driver.findElement(timezoneUTC).click();
    }

    public String getTimezoneKorea() {
        return driver.findElement(timezoneKorea).getText();
    }

    public void clickTimezoneKorea() {
        driver.findElement(timezoneKorea).click();
    }


    // ===== 회원탈퇴 =====
    public String getWithdrawBtn() {
        return driver.findElement(withdrawBtn).getText();
    }

    public void clickWithdrawBtn() {
        driver.findElement(withdrawBtn).click();
    }


    // ===== 모달 =====
    public String getModalTitle() {
        return driver.findElement(modalTitle).getText();
    }

    public String getModalText() {
        return driver.findElement(modalText).getText();
    }

    public void clickModalBtn() {
        driver.findElement(modalBtn).click();
    }
}
