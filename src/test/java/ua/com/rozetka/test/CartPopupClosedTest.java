package ua.com.rozetka.test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ua.com.rozetka.business.object.AddProductToCartBO;
import ua.com.rozetka.listener.ListenerTest;
import ua.com.rozetka.page.CartPage;

@Listeners(ListenerTest.class)
public class CartPopupClosedTest extends BaseTest  {

    @Test
    public void cartPopupClosed() {
        final AddProductToCartBO addProductToCartBO = new AddProductToCartBO();
        addProductToCartBO.addProductToCartFromComputersAndNotebooks();
        CartPage cartPage = new CartPage();
        cartPage.clickOnCrossIcon();
        Assert.assertFalse(cartPage.isPopupClosed(),"Cart popup window is not closed");
    }


}