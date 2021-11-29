package ua.com.rozetka.page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebDriverUtil;
import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int TIME_OUT = 15;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = WebDriverUtil.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
    }
}
