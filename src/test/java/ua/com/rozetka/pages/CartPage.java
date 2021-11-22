package ua.com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage {
    private WebDriverWait wait;
    private By confirmationPopupTitle = By.cssSelector(".modal__heading");  //++++++++++
    private By productTitleInCart = By.cssSelector(".cart-product__title"); //++++++++++
    private By productSubtotal = By.cssSelector(".cart-product__coast.ng-star-inserted"); //++++++++++
    private By totalSumInCart = By.cssSelector(".cart-receipt__sum-price"); //++++++++++
    private By plusIcon = By.cssSelector("[aria-label='Добавить ещё один товар']");
    private By productQuantity = By.cssSelector("input.cart-counter__input"); //++++++++++
    private By containerOfProductQuantity = By.cssSelector(".cart-counter"); //++++++++++
    private By crossIcon = By.cssSelector(".modal__close.ng-star-inserted"); //++++++++++


    public CartPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }


    public String getConfirmationPopupTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationPopupTitle));
        return driver.findElement(confirmationPopupTitle).getText();
    }

    public String getProductTitleInCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitleInCart));
        return driver.findElement(productTitleInCart).getText();
    }

    public int getSubtotalSumInCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productSubtotal));
        int subtotalInCart = Integer.parseInt(driver.findElement(productSubtotal).getText().replaceAll("[^0-9]", ""));
        return subtotalInCart;
    }


    public int getTotalSumInCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalSumInCart));
        int totalInCart = Integer.parseInt(driver.findElement(totalSumInCart).getText().replaceAll("[^0-9]", ""));
        return totalInCart;
    }


    public void addOneMoreProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(plusIcon));
        driver.findElement(plusIcon).click();
    }


    public int countOfProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(containerOfProductQuantity));
        int countOfProduct = Integer.parseInt (driver.findElement(productQuantity).getAttribute("value"));
        return countOfProduct;
    }


    public void clickOnCrossIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(crossIcon));
        driver.findElement(crossIcon).click();
    }

    public boolean popupClosed() {
        try {
            driver.findElement(confirmationPopupTitle).isDisplayed();
            return true;
        } catch (Exception cartTitleNotFound) {
            return false;
        }

    }

}
