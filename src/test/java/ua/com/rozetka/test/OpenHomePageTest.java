package ua.com.rozetka.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.page.HomePage;
import util.WebDriverUtil;

public class OpenHomePageTest extends BaseTest {

    @Test(description = "verify user can open Home Page")
    public void openHomePage() {
        HomePage homePage = new HomePage(WebDriverUtil.getWebDriver());
        boolean homePageIsOpened = homePage.menuCategoriesIsDisplayed();
        Assert.assertEquals(homePageIsOpened, true);
    }
}
