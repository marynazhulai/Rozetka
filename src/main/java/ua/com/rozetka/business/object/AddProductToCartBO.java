package ua.com.rozetka.business.object;
import ua.com.rozetka.page.ComputersAndNotebooksPage;
import ua.com.rozetka.page.HomePage;
import ua.com.rozetka.page.ProductOverviewPage;


public class AddProductToCartBO {
    private HomePage homePage = new HomePage();
    private ComputersAndNotebooksPage computersAndNotebooksPage = new ComputersAndNotebooksPage();
    private ProductOverviewPage productOverviewPage = new ProductOverviewPage();

    public void addProductToCartFromComputersAndNotebooks() {
        homePage.openComputersAndNotebooksCategory();
        computersAndNotebooksPage.clickOnProduct();
        productOverviewPage.addProductToCart();
    }

}
