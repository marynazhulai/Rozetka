package ua.com.rozetka.test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.pages.ProductOverviewPage;;
import ua.com.rozetka.pages.CartPage;

public class CartPopupClosedTest extends BaseTest {
    WebDriverWait wait;
    CartPage cartPage;
    ProductOverviewPage productOverviewPage;


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