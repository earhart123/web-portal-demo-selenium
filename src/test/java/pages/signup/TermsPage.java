package pages.signup;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsPage {

    private WebDriver driver;

    private By title = By.cssSelector("[data-qa='step-terms'] h1");
    private By checkAll = By.xpath("//input[@data-qa='agree-all']/following-sibling::span[1]");
    private By checkAllInput = By.cssSelector("[data-qa='agree-all']");
    private By agreeServiceLabel = By.xpath("//input[@data-qa='agree-service']/following-sibling::span[1]");
    private By agreeServiceInput = By.cssSelector("[data-qa='agree-service']");
    private By agreePrivacyLabel = By.xpath("//input[@data-qa='agree-privacy']/following-sibling::span[1]");
    private By agreePrivacyInput = By.cssSelector("[data-qa='agree-privacy']");
    private By agreeAgeLabel = By.xpath("//input[@data-qa='agree-age']/following-sibling::span[1]");
    private By agreeAgeInput = By.cssSelector("[data-qa='agree-age']");
    private By agreeMarketingLabel = By.xpath("//input[@data-qa='agree-marketing']/following-sibling::span[1]");
    private By agreeMarketingInput = By.cssSelector("[data-qa='agree-marketing']");
    private By nextBtn = By.cssSelector("[data-qa='btn-terms-next']");

    public TermsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(BaseTest.BASE_URL + "/signup.html");
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }


    // ===== 전체 동의 =====

    public String getCheckAll() {
        return driver.findElement(checkAll).getText();
    }

    public void clickCheckAll() {
        driver.findElement(checkAllInput).click();
    }


    // ===== 약관 항목 =====

    public String getTerms1() {
        return driver.findElement(agreeServiceLabel).getText();
    }

    public String getTerms2() {
        return driver.findElement(agreePrivacyLabel).getText();
    }

    public String getTerms3() {
        return driver.findElement(agreeAgeLabel).getText();
    }

    public String getTerms4() {
        return driver.findElement(agreeMarketingLabel).getText();
    }

    public void clickTerms1() {
        driver.findElement(agreeServiceInput).click();
    }

    public void clickTerms2() {
        driver.findElement(agreePrivacyInput).click();
    }

    public void clickTerms3() {
        driver.findElement(agreeAgeInput).click();
    }

    public void clickTerms4() {
        driver.findElement(agreeMarketingInput).click();
    }


    // ===== 다음 버튼 =====

    public String getNextBtn() {
        return driver.findElement(nextBtn).getText();
    }

    public void clickNextBtn() {
        driver.findElement(nextBtn).click();
    }
}
