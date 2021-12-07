package ua.com.rozetka.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.page.CartPage;
import ua.com.rozetka.page.ComputersAndNotebooksPage;
import ua.com.rozetka.page.HomePage;
import ua.com.rozetka.page.ProductOverviewPage;

public class AddProductToCardTest extends BaseTest {

    @Test
    public void addProductToCard() {
        HomePage homePage = new HomePage();
        homePage.openComputersAndNotebooksCategory();
        ComputersAndNotebooksPage computersAndNotebooksPage = new ComputersAndNotebooksPage();
        computersAndNotebooksPage.clickOnProduct();
        ProductOverviewPage productOverviewPage = new ProductOverviewPage();
        String productTitleOnProductOverviewPage = productOverviewPage.getProductTitle();
        int productPrice = productOverviewPage.getProductPrice();
        productOverviewPage.addProductToCart();
        CartPage cartPage = new CartPage();
        Assert.assertEquals(cartPage.getConfirmationPopupTitle(), "Корзина", "Cart title doesn`t match");
        Assert.assertEquals(cartPage.getProductTitleInCart(), productTitleOnProductOverviewPage, "Product title doesn`t match");
        Assert.assertEquals(cartPage.getSubtotalSumInCart(), productPrice, "Subtotal Sum in cart incorrect");
        Assert.assertEquals(cartPage.getTotalSumInCart(), productPrice, "Total Sum in cart incorrect");
    }
}
