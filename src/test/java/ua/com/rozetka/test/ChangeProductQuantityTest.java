package ua.com.rozetka.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.page.CartPage;
import ua.com.rozetka.page.ComputersAndNotebooksPage;
import ua.com.rozetka.page.HomePage;
import ua.com.rozetka.page.ProductOverviewPage;

public class ChangeProductQuantityTest extends BaseTest {
    private ProductOverviewPage productOverviewPage;
    private HomePage homePage;
    private CartPage cartPage;
    private ComputersAndNotebooksPage computersAndNotebooksPage;

    @Test
    public void changeProductQuantity() throws InterruptedException {
        productOverviewPage = new ProductOverviewPage(driver);
        cartPage = new CartPage(driver);
        homePage = new HomePage(driver);
        computersAndNotebooksPage = new ComputersAndNotebooksPage(driver);
        productOverviewPage.productIsAddedToCart();
        cartPage.addOneMoreProduct();
        int countOfProduct = cartPage.countOfProduct();
        Assert.assertEquals(countOfProduct, 2);
        int productPrice = productOverviewPage.getProductPrice();
        int recalculatedSubtotal = productPrice * countOfProduct;
        int expectedSubtotal = productPrice * 2;
        Assert.assertEquals(recalculatedSubtotal, expectedSubtotal);
        Thread.sleep(2000);
        int recalculatedTotalSumInCart = cartPage.getTotalSumInCart();
        Assert.assertEquals(recalculatedTotalSumInCart, expectedSubtotal);
    }
}
