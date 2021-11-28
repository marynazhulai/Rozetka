package ua.com.rozetka.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.page.CartPage;
import ua.com.rozetka.page.ComputersAndNotebooksPage;
import ua.com.rozetka.page.HomePage;
import ua.com.rozetka.page.ProductOverviewPage;
import util.WebDriverUtil;

public class AddProductToCardTest extends BaseTest {

    @Test
    public void addProductToCard() {
        HomePage homePage = new HomePage(WebDriverUtil.getWebDriver());
        homePage.openComputersAndNotebooksCategory();
        ComputersAndNotebooksPage computersAndNotebooksPage = new ComputersAndNotebooksPage(WebDriverUtil.getWebDriver());
        computersAndNotebooksPage.clickOnProduct();
        ProductOverviewPage productOverviewPage = new ProductOverviewPage(WebDriverUtil.getWebDriver());
        String ProductTitleOnProductOverviewPage = productOverviewPage.getProductTitle();
        int productPrice = productOverviewPage.getProductPrice();
        productOverviewPage.addProductToCart();
        CartPage cartPage = new CartPage(WebDriverUtil.getWebDriver());
        String cartTitle = cartPage.getConfirmationPopupTitle();
        Assert.assertEquals(cartTitle, "Корзина");
        String ProductTitleOnCartPage = cartPage.getProductTitleInCart();
        Assert.assertEquals(ProductTitleOnCartPage, ProductTitleOnProductOverviewPage);
        int subtotalSumInCart = cartPage.getSubtotalSumInCart();
        int totalSumInCart = cartPage.getTotalSumInCart();
        Assert.assertEquals(subtotalSumInCart, productPrice);
        Assert.assertEquals(totalSumInCart, productPrice);
    }
}
