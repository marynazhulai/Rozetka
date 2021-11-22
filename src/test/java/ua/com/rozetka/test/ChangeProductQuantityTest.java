package ua.com.rozetka.test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.pages.CartPage;
import ua.com.rozetka.pages.ComputersAndNotebooksPage;
import ua.com.rozetka.pages.HomePage;
import ua.com.rozetka.pages.ProductOverviewPage;

public class ChangeProductQuantityTest extends BaseTest {
    WebDriverWait wait;
    ProductOverviewPage productOverviewPage;
    HomePage homePage;
    CartPage cartPage;
    ComputersAndNotebooksPage computersAndNotebooksPage;

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
