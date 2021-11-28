package util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public final class WebDriverUtil {
    private static ThreadLocal<WebDriver> webDriver;

    public static WebDriver getWebDriver(){
        if (webDriver == null){
            webDriver = new ThreadLocal<WebDriver>();
        }
        return webDriver.get();
    }

    public static void initWebDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriverUtil.getWebDriver();
        WebDriverUtil.getWebDriver().manage().window().maximize();
        WebDriverUtil.getWebDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverUtil.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverUtil.getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
    }

    public static void closeDriver(){
        WebDriverManager.chromedriver().quit();
    }
}
