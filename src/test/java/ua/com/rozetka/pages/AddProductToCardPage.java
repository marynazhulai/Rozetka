package ua.com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductToCardPage extends AbstractPage {

    private WebDriverWait wait;
    private By link = By.linkText("Ноутбуки и компьютеры");
    private By firstProductTitle = By.xpath("//ul/li[1]/li/app-goods-tile-lite/div/div[2]/a[1]/img");
    private By expectedProductPrice  = By.xpath("//*[@class='product-prices__big product-prices__big_color_red']");
    private By addProductToCart  = By.xpath("//*[@id='#scrollArea']/div[1]/div[2]/rz-product-main-info/div[2]/div[1]/ul/li[1]/app-product-buy-btn/app-buy-button/button/span");
    private By confirmationPopupTitle = By.cssSelector("[class='modal__heading']");
    private By actualProductTitle = By.cssSelector("[class='cart-product__title']");
    private By actualSubtotal = By.xpath("//*[@class='cart-product__price cart-product__price--red']");
    private By actualTotal = By.xpath("//*[@class='cart-receipt__sum-price']");

    public AddProductToCardPage (WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }




    public void goToLink() {
        driver.findElement(link).click();
    }

    public String getExpectedProductTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductTitle));
        return driver.findElement(firstProductTitle).getAttribute("alt");
    }

    public void clickOnProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductTitle));
        driver.findElement(firstProductTitle).click();
    }

    public String getExpectedProductPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(expectedProductPrice));
        return driver.findElement(expectedProductPrice).getAttribute("innerText");
        /*String expectedProductPrice = driver.findElement(expectedProductPrice).getAttribute("innerText");             //не працює
        String expectedProductPriceAfterConverting = expectedProductPrice.replaceAll ("[^A-Za-zА-Яа-я0-9]", "");
        return expectedProductPriceAfterConverting;*/
    }


    public void addProductToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addProductToCart));
        driver.findElement(addProductToCart).click();
    }


    public String getConfirmationPopupTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationPopupTitle));
        return driver.findElement(confirmationPopupTitle).getAttribute("innerText");
    }

    public String getActualProductTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(actualProductTitle));
        return driver.findElement(actualProductTitle).getAttribute("innerText");
    }

    public String getActualSubtotal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(actualSubtotal));
        return driver.findElement(actualSubtotal).getAttribute("textContent");
    }


    public String getActualTotal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(actualTotal));
        return driver.findElement(actualTotal).getAttribute("innerText");
    }


    public void productIsAddedToCart (){
        goToLink();
        clickOnProduct();
        addProductToCart();
   }


}
