package pages.signup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterChoicePage {

    private WebDriver driver;

    private By title = By.cssSelector(".title");
    private By subText = By.cssSelector("p:nth-child(1)");
    private By emailSignupBtn = By.cssSelector(".btn-primary > span");

    public RegisterChoicePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://accounts.example.com/member/register/choice?redirect=https%3A%2F%2Fwww.example.com%2F");
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getSubText() {
        return driver.findElement(subText).getText();
    }

    public String getEmailSignupBtn() {
        return driver.findElement(emailSignupBtn).getText();
    }

    public void clickEmailSignup() {
        driver.findElement(emailSignupBtn).click();
    }
}
