package ua.com.rozetka.page;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int TIME_OUT = 5;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
