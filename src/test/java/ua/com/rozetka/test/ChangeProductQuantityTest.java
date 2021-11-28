package ua.com.rozetka.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.page.CartPage;
import ua.com.rozetka.page.ComputersAndNotebooksPage;
import ua.com.rozetka.page.HomePage;
import ua.com.rozetka.page.ProductOverviewPage;
import util.WebDriverUtil;

public class ChangeProductQuantityTest extends BaseTest {

    @Test
    public void changeProductQuantity() throws InterruptedException {

        ProductOverviewPage productOverviewPage = new ProductOverviewPage(WebDriverUtil.getWebDriver());
        productOverviewPage.productIsAddedToCart();
        CartPage cartPage = new CartPage(WebDriverUtil.getWebDriver());
        cartPage.addOneMoreProduct();



        int countOfProduct = cartPage.countOfProduct();
        Assert.assertEquals(countOfProduct, 2);
        int productPrice = productOverviewPage.getProductPrice();
        int recalculatedSubtotal = productPrice * countOfProduct;
        int expectedSubtotal = productPrice * 2;
        Assert.assertEquals(recalculatedSubtotal, expectedSubtotal);
        int recalculatedTotalSumInCart = cartPage.getTotalSumInCart();
        Assert.assertEquals(recalculatedTotalSumInCart, expectedSubtotal);
    }
}
