package ua.com.rozetka.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.business.object.AddProductToCartBO;
import ua.com.rozetka.page.CartPage;
import ua.com.rozetka.page.ProductOverviewPage;

public class ChangeProductQuantityTest extends BaseTest {

    @Test
    public void changeProductQuantity() {

        final AddProductToCartBO addProductToCartBO = new AddProductToCartBO();
        addProductToCartBO.addProductToCartFromComputersAndNotebooks();
        CartPage cartPage = new CartPage();
        cartPage.addOneMoreProduct();
        int countOfProduct = cartPage.countOfProduct();
        Assert.assertEquals(countOfProduct, 2);
        ProductOverviewPage productOverviewPage = new ProductOverviewPage();
        int productPrice = productOverviewPage.getProductPrice();
        int recalculatedSubtotal = productPrice * countOfProduct;
        int expectedSubtotal = productPrice * 2;
        Assert.assertEquals(recalculatedSubtotal, expectedSubtotal);
        int recalculatedTotalSumInCart = cartPage.getTotalSumInCart();
        Assert.assertEquals(recalculatedTotalSumInCart, expectedSubtotal);
    }
}
