package ua.com.rozetka.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.pages.CartPage;
import ua.com.rozetka.pages.ComputersAndNotebooksPage;
import ua.com.rozetka.pages.HomePage;
import ua.com.rozetka.pages.ProductOverviewPage;


public class AddProductToCardTest extends BaseTest {
    ProductOverviewPage productOverviewPage;
    HomePage homePage;
    CartPage cartPage;
    ComputersAndNotebooksPage computersAndNotebooksPage;

    @Test
    public void addProductToCard() {
        productOverviewPage = new ProductOverviewPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        computersAndNotebooksPage = new ComputersAndNotebooksPage(driver);

        homePage.openComputersAndNotebooksCategory();
        computersAndNotebooksPage.clickOnProduct();
        String ProductTitleOnProductOverviewPage = productOverviewPage.getProductTitle();
        int productPrice = productOverviewPage.getProductPrice();
        productOverviewPage.addProductToCart();
        String cartTitle = cartPage.getConfirmationPopupTitle();
        Assert.assertEquals(cartTitle, "Корзина");

        String ProductTitleOnCartPage  = cartPage.getProductTitleInCart();
        Assert.assertEquals(ProductTitleOnCartPage , ProductTitleOnProductOverviewPage);

        int subtotalSumInCart = cartPage.getSubtotalSumInCart();
        int totalSumInCart = cartPage.getTotalSumInCart();
        Assert.assertEquals(subtotalSumInCart, productPrice);
        Assert.assertEquals(totalSumInCart, productPrice);

    }
}
