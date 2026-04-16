package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage {

    private WebDriver driver;

    private By title = By.tagName("h1");

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
