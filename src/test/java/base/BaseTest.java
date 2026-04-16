package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected static final String BASE_URL = "https://earhart123.github.io/web-portal-demo-selenium";

    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected WebDriverWait wait;
    protected Map<String, Object> vars;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        if ("true".equalsIgnoreCase(System.getenv("HEADLESS"))) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        vars = new HashMap<>();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        var whNow = driver.getWindowHandles();
        var whThen = (java.util.Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }
}
