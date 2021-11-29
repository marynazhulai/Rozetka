package ua.com.rozetka.test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import util.WebDriverUtil;


public class BaseTest {


    public static final String BASE_URL = "https://rozetka.com.ua/";

    @BeforeClass
    public void setup() {
        WebDriverUtil.setDriver();
        WebDriverUtil.getDriver().get(BASE_URL);
        WebDriverUtil.initWebDriver();
    }

    @AfterClass
    public void tearDown() {
        WebDriverUtil.closeBrowser();
    }
}
