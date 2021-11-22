package ua.com.rozetka.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.page.ProductOverviewPage;;
import ua.com.rozetka.page.CartPage;

public class CartPopupClosedTest extends BaseTest {
    private CartPage cartPage;
    private ProductOverviewPage productOverviewPage;

    @Test
    public void addProductToCard() {
        cartPage = new CartPage(driver);
        productOverviewPage = new ProductOverviewPage(driver);
        productOverviewPage.productIsAddedToCart();
        cartPage.clickOnCrossIcon();
        boolean popupClosed = cartPage.popupClosed();
        Assert.assertEquals(popupClosed, false);
    }
}