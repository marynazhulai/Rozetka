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
        //int countOfProduct = cartPage.getCountOfProduct();
        Assert.assertEquals(cartPage.getCountOfProduct(), 2, "Count of product doesn`t match");
        ProductOverviewPage productOverviewPage = new ProductOverviewPage();
        //int productPrice = productOverviewPage.getProductPrice();
        //int recalculatedSubtotal = productOverviewPage.getProductPrice() * countOfProduct;
        int expectedSubtotal = productOverviewPage.getProductPrice() * 2;
        Assert.assertEquals(productOverviewPage.getProductPrice() * cartPage.getCountOfProduct(), expectedSubtotal, "Subtotal in cart doesn`t match");
        //int recalculatedTotalSumInCart = cartPage.getTotalSumInCart();
        Assert.assertEquals(cartPage.getTotalSumInCart(), expectedSubtotal, "Total in cart doesn`t match");
    }
}
