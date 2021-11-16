package ua.com.rozetka.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public WebDriver driver;
    /*public AddProductToCard addProductToCard;
    public ChangeProductQuantity changeProductQuantity;*/

    @BeforeClass

    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
       /* addProductToCard = PageFactory.initElements(driver, AddProductToCard.class);
        changeProductQuantity = PageFactory.initElements(driver, ChangeProductQuantity.class);*/
    }

    @AfterClass
    public void tearDown () {
        driver.close();
    }

}
