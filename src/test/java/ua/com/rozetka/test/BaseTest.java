package ua.com.rozetka.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.WebDriverUtil;

public class BaseTest {

    public static final String BASE_URL = "https://rozetka.com.ua/";

    @BeforeMethod
    public void setup() {
        WebDriverUtil.initWebDriver();
        WebDriverUtil.getDriver().get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverUtil.closeBrowser();
    }
}
