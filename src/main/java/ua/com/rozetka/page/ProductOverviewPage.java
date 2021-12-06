package ua.com.rozetka.page;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductOverviewPage extends AbstractPage {
    @FindBy (xpath = "//h1[contains(@class, 'product__title')]")
    private WebElement productTitle;
    @FindBy (css = ".product-prices__inner.ng-star-inserted")
    private WebElement productPrice;
    @FindBy (css = ".product-buttons app-buy-button")
    private WebElement buyButton;
    private static final Logger LOG = LoggerFactory.getLogger(ProductOverviewPage.class);

    public String getProductTitle() {
        LOG.info("Get product title");
        return productTitle.getAttribute("innerText");
    }

    public int getProductPrice() {
        LOG.info("Get product price");
        return Integer.parseInt(productPrice.getAttribute("innerText").replaceAll("[^0-9]", ""));
    }

    public void addProductToCart() {
        LOG.info("Add product to cart");
        buyButton.click();
    }
}
