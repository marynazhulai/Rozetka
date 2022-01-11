package ua.com.rozetka.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductOverviewPage extends AbstractPage {
    private static final Logger LOG = LogManager.getLogger(ProductOverviewPage.class);

    @FindBy(xpath = "//h1[contains(@class, 'product__title')]")
    private WebElement productTitle;
    @FindBy(xpath = "//div/p[ contains(@class, 'product-prices__big')]")
    private WebElement productPrice;
    @FindBy(css = ".product-buttons app-buy-button")
    private WebElement buyButton;

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
        WebElement element = buyButton;
        new Actions(driver).moveToElement(element).click().perform();
    }
}
