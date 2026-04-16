package pages.signup;

import base.BaseTest;
import org.openqa.selenium.WebDriver;

public class RegisterChoicePage {

    private WebDriver driver;

    public RegisterChoicePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(BaseTest.BASE_URL + "/signup.html");
    }
}
