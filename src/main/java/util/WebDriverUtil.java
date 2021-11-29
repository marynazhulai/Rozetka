package util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

    public final class WebDriverUtil {
        private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

        public static  void setDriver() {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }

        public static WebDriver getDriver() {
            return driver.get();
        }

        public static void closeBrowser() {
            driver.get().close();
            driver.remove();
        }

        public static void initWebDriver() {
            WebDriverManager.chromedriver().setup();
            WebDriverUtil.getDriver();
            WebDriverUtil.getDriver().manage().window().maximize();
            WebDriverUtil.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebDriverUtil.getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        }
    }


    /*public static WebDriver getWebDriver(WebDriver driver){
        if (webDriver == null){
            webDriver = new ThreadLocal<WebDriver>();
        }
        return webDriver;
    }*/
