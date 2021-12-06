package ua.com.rozetka.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.page.HomePage;

public class OpenHomePageTest extends BaseTest {

    @Test(description = "verify Home Page is opened")
    public void openHomePage() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isMenuCategoriesDisplayed(), "Menu 'Categories' is not displayed");
    }
}
