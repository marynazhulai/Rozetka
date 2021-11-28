package ua.com.rozetka.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.WebDriverUtil;

public class ProductOverviewPage extends AbstractPage {
    private HomePage homePage = new HomePage(WebDriverUtil.getWebDriver());
    private ComputersAndNotebooksPage computersAndNotebooksPage = new ComputersAndNotebooksPage(WebDriverUtil.getWebDriver());
    private By productTitle = By.xpath(("//h1[contains(@class, 'product__title')]"));
    private By productPrice = By.cssSelector(".product-prices__inner.ng-star-inserted");
    private By buyButton = By.cssSelector(".product-buttons app-buy-button");

    public ProductOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        return driver.findElement(productTitle).getAttribute("innerText");
    }

    public int getProductPrice() {
        int productPrice1 = Integer.parseInt(driver.findElement(productPrice).getAttribute("innerText").replaceAll("[^0-9]", ""));
        return productPrice1;
    }

    public void addProductToCart() {
        driver.findElement(buyButton).click();
    }

        public void productIsAddedToCart() {
        homePage.openComputersAndNotebooksCategory();
        computersAndNotebooksPage.clickOnProduct();
        addProductToCart();
    }
}
