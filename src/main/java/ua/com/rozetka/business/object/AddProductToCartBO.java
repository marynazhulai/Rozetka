package ua.com.rozetka.business.object;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.com.rozetka.page.ComputersAndNotebooksPage;
import ua.com.rozetka.page.HomePage;
import ua.com.rozetka.page.ProductOverviewPage;


public class AddProductToCartBO {
    private static final Logger LOG = LogManager.getLogger(AddProductToCartBO.class);
    private HomePage homePage = new HomePage();
    private ComputersAndNotebooksPage computersAndNotebooksPage = new ComputersAndNotebooksPage();
    private ProductOverviewPage productOverviewPage = new ProductOverviewPage();

    public void addProductToCartFromComputersAndNotebooks() {
        LOG.info("Product added to cart from Computers and Notebooks category");
        homePage.openComputersAndNotebooksCategory();
        computersAndNotebooksPage.clickOnProduct();
        productOverviewPage.addProductToCart();
    }
}
