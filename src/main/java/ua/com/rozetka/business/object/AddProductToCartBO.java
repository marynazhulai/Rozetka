package ua.com.rozetka.business.object;
import ua.com.rozetka.page.ComputersAndNotebooksPage;
import ua.com.rozetka.page.HomePage;
import ua.com.rozetka.page.ProductOverviewPage;


public class AddProductToCartBO {
    private HomePage homePage = new HomePage();
    private ComputersAndNotebooksPage computersAndNotebooksPage = new ComputersAndNotebooksPage();
    private ProductOverviewPage productOverviewPage = new ProductOverviewPage();

    public void addProductToCartFromComputersAndNotebooks() {
        LOG.info("Open Computers and Notebooks category");
        homePage.openComputersAndNotebooksCategory();
        LOG.info("Click on Product on Computers and Notebooks page");
        computersAndNotebooksPage.clickOnProduct();
        LOG.info("Add product to cart");
        productOverviewPage.addProductToCart();
    }

}
