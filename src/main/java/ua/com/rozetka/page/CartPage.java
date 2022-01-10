package ua.com.rozetka.page;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends AbstractPage {
    private static final Logger LOG = LogManager.getLogger(CartPage.class);

    @FindBy(css = ".modal__heading")
    private WebElement confirmationPopupTitle;
    @FindBy(css = ".cart-product__title")
    private WebElement productTitleInCart;
    @FindBy(xpath = "//div/p[ contains(@class, 'cart-product__price')]")
    private WebElement productSubtotal;
    @FindBy(css = ".cart-receipt__sum-price")
    private WebElement totalSumInCart;
    @FindBy (css = "[aria-label='Добавить ещё один товар']")
    private WebElement plusIcon;
    @FindBy(css = "input.cart-counter__input")
    private WebElement productQuantity;
    @FindBy(css = ".modal__close")
    private WebElement crossIcon;
    private By modalWithSpinner = By.xpath("//div[contains(@class, 'modal__holder')] [contains(@class, 'modal__holder_show_animation')]");

    public String getConfirmationPopupTitle() {
        LOG.info("Get confirmation popup title");
        return confirmationPopupTitle.getText();
    }

    public String getProductTitleInCart() {
        LOG.info("Get product title in cart");
        return productTitleInCart.getText();
    }
    @Step ("gggggggggggggggggggggggggggggggggggggggggggggg")
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
        WebElement element = plusIcon;
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
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
            wait.until(ExpectedConditions.invisibilityOfElementLocated(modalWithSpinner));
        } catch (TimeoutException ex) {
            LOG.warn("Spinner is not displayed", ex);
        }
    }
}
