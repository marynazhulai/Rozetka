package ua.com.rozetka.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.page.ProductOverviewPage;;
import ua.com.rozetka.page.CartPage;
import util.WebDriverUtil;

public class CartPopupClosedTest extends BaseTest {

    @Test
    public void addProductToCard() {
        ProductOverviewPage productOverviewPage = new ProductOverviewPage(WebDriverUtil.getWebDriver());
        productOverviewPage.productIsAddedToCart();
        CartPage cartPage = new CartPage(WebDriverUtil.getWebDriver());
        cartPage.clickOnCrossIcon();
        boolean popupClosed = cartPage.popupClosed();
        Assert.assertEquals(popupClosed, false);
    }
}