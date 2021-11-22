package ua.com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductOverviewPage extends AbstractPage {

    private WebDriverWait wait;
    public HomePage homePage = new HomePage(driver);
    public ComputersAndNotebooksPage computersAndNotebooksPage = new ComputersAndNotebooksPage(driver);


    private By productTitle = By.xpath(("//h1[contains(@class, 'product__title')]"));  //++++++++++
    private By productPrice = By.cssSelector(".product-prices__inner.ng-star-inserted"); //+++++++++++++
    private By buyButton = By.cssSelector(".product-buttons app-buy-button");  //+++++++++++++


    public ProductOverviewPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }

    public String getProductTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        return driver.findElement(productTitle).getAttribute("innerText");
    }

    public int getProductPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        int productPrice1 = Integer.parseInt(driver.findElement(productPrice).getAttribute("innerText").replaceAll("[^0-9]", ""));
        return productPrice1;
    }

    public void addProductToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buyButton));
        driver.findElement(buyButton).click();
    }

    public void productIsAddedToCart() {
        homePage.openComputersAndNotebooksCategory();
        computersAndNotebooksPage.clickOnProduct();
        addProductToCart();
    }
}
