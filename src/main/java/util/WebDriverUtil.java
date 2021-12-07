package util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public final class WebDriverUtil {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger LOG = LogManager.getLogger(WebDriverUtil.class);

    public static void initWebDriver() {
        LOG.info("Open browser");
        WebDriverManager.chromedriver().setup();
        if (driver.get() == null) {
            driver.set(new ChromeDriver());
        }
        WebDriverUtil.getDriver().manage().window().maximize();
        WebDriverUtil.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverUtil.getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
    }

    public static WebDriver getDriver() {
        LOG.info("Get driver");
        return driver.get();
    }

    public static void closeBrowser() {
        LOG.info("Close browser");
        driver.get().quit();
        driver.remove();
    }
}
