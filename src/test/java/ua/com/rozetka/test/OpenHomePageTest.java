package ua.com.rozetka.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.page.HomePage;

public class OpenHomePageTest extends BaseTest {
    private HomePage homePage;

    @Test(description = "verify user can open Home Page")
    public void openHomePage() {
        homePage = new HomePage(driver);
        String expectedTitle = "Интернет-магазин ROZETKA™: официальный сайт самого популярного онлайн-гипермаркета в Украине";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
