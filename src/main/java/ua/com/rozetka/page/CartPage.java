package ua.com.rozetka.page;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CartPage extends AbstractPage {
    private static final Logger LOG = LoggerFactory.getLogger(CartPage.class);

    @FindBy (css = ".modal__heading")
    private WebElement confirmationPopupTitle;
    @FindBy (css = ".cart-product__title")
    private WebElement productTitleInCart;
    @FindBy (css = ".cart-product__coast.ng-star-inserted")
    private WebElement productSubtotal;
    @FindBy (css = ".cart-receipt__sum-price")
    private WebElement totalSumInCart;
    @FindBy (css = "[aria-label='Добавить ещё один товар']")
    private WebElement plusIcon;
    @FindBy (css = "input.cart-counter__input")
    private WebElement productQuantity;
    @FindBy (css = ".modal__close.ng-star-inserted")
    private WebElement crossIcon;
    @FindBy (xpath = "//div[contains(@class, 'modal__holder')] [contains(@class, 'modal__holder_show_animation')]")
    private WebElement modalWithSpinner;

    public String getConfirmationPopupTitle() {
        LOG.info("Get confirmation popup title");
        return confirmationPopupTitle.getText();
    }

    public String getProductTitleInCart() {
        LOG.info("Get product title in cart");
        return productTitleInCart.getText();
    }

    public int getSubtotalSumInCart() {
        LOG.info("Get Subtotal sum in cart");
        return Integer.parseInt(productSubtotal.getText().replaceAll("[^0-9]", ""));
    }

    public int getTotalSumInCart() {
        LOG.info("Get Total sum in cart");
        return Integer.parseInt(totalSumInCart.getText().replaceAll("[^0-9]", ""));
    }

    public void addOneMoreProduct() {
        LOG.info("Click on plus icon in cart to add more product");
        plusIcon.click();
    }

    public int getCountOfProduct() {
        LOG.info("Get count of product in cart");
        waitForSpinnerNotDisplayed();
        return Integer.parseInt(productQuantity.getAttribute("value"));
    }

    public void clickOnCrossIcon() {
        LOG.info("Click on cross icon in cart");
        crossIcon.click();
    }

    public boolean isPopupClosed() {
        try {
            LOG.warn("Popup is not closed");
            return confirmationPopupTitle.isDisplayed();
        } catch (NoSuchElementException ex) {
            LOG.warn("Popup is closed", ex);
            return false;
        }
    }

    private void waitForSpinnerNotDisplayed() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated((By) modalWithSpinner));
        } catch (TimeoutException ex) {
            LOG.warn("Spinner is not displayed", ex);
        }
    }
}
