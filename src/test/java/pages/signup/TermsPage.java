package pages.signup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsPage {

    private WebDriver driver;

    private By title = By.cssSelector(".title:nth-child(1)");
    private By desc = By.cssSelector(".desc:nth-child(2)");
    private By checkAll = By.cssSelector(".check-all > label");
    private By over14 = By.id("agreement_over14");
    private By under14 = By.cssSelector(".btn-underline");
    private By under14NoBtn = By.cssSelector(".btn-line > span");
    private By under14YesBtn = By.cssSelector("#agreement_under14 > span");
    private By nextBtn = By.cssSelector(".btn-line");
    private By terms1 = By.cssSelector(".checkbox:nth-child(2) > label");
    private By terms2 = By.cssSelector(".checkbox:nth-child(3) > label");
    private By terms3 = By.cssSelector(".checkbox:nth-child(4) > label");

    public TermsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getDesc() {
        return driver.findElement(desc).getText();
    }


    // ===== 약관 =====

    public String getCheckAll() {
        return driver.findElement(checkAll).getText();
    }

    public void clickCheckAll() {
        driver.findElement(checkAll).click();
    }

    public String getTerms1() {
        return driver.findElement(terms1).getText();
    }

    public String getTerms2() {
        return driver.findElement(terms2).getText();
    }

    public String getTerms3() {
        return driver.findElement(terms3).getText();
    }

    public void clickTerms1() {
        driver.findElement(terms1).click();
    }

    public void clickTerms2() {
        driver.findElement(terms2).click();
    }

    public void clickTerms3() {
        driver.findElement(terms3).click();
    }


    // ===== 만 14세 이상 =====

    public String getOver14() {
        return driver.findElement(over14).getText();
    }

    public void clickOver14() {
        driver.findElement(over14).click();
    }


    // ===== 만 14세 미만 =====

    public String getUnder14() {
        return driver.findElement(under14).getText();
    }

    public String getUnder14Title() {
        return driver.findElement(By.cssSelector(".active .title")).getText();
    }

    public String getUnder14SubText() {
        return driver.findElement(By.cssSelector(".text-align-left:nth-child(1)")).getText();
    }

    public void clickUnder14() {
        driver.findElement(under14).click();
    }

    public String getUnder14NoBtn() {
        return driver.findElement(under14NoBtn).getText();
    }

    public void clickUnder14NoBtn() {
        driver.findElement(under14NoBtn).click();
    }

    public String getUnder14YesBtn() {
        return driver.findElement(under14YesBtn).getText();
    }
}
