package ua.com.rozetka.page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.WebDriverUtil;

public class CartPage extends AbstractPage {
    private By confirmationPopupTitle = By.cssSelector(".modal__heading");
    private By productTitleInCart = By.cssSelector(".cart-product__title");
    private By productSubtotal = By.cssSelector(".cart-product__coast.ng-star-inserted");
    private By totalSumInCart = By.cssSelector(".cart-receipt__sum-price");
    private By plusIcon = By.cssSelector("[aria-label='Добавить ещё один товар']");
    private By productQuantity = By.cssSelector("input.cart-counter__input");
    private By containerOfProductQuantity = By.cssSelector(".cart-counter");
    private By crossIcon = By.cssSelector(".modal__close.ng-star-inserted");
    private By modalWithSpinner = By.xpath("//div[contains(@class, 'modal__holder')] [contains(@class, 'modal__holder_show_animation')]");

    public CartPage() {
        super(WebDriverUtil.getDriver());
    }

    public String getConfirmationPopupTitle() {
        return driver.findElement(confirmationPopupTitle).getText();
    }

    public String getProductTitleInCart() {
        return driver.findElement(productTitleInCart).getText();
    }

    public int getSubtotalSumInCart() {
        int subtotalInCart = Integer.parseInt(driver.findElement(productSubtotal).getText().replaceAll("[^0-9]", ""));
        return subtotalInCart;
    }

    public int getTotalSumInCart() {
        int totalInCart = Integer.parseInt(driver.findElement(totalSumInCart).getText().replaceAll("[^0-9]", ""));
        return totalInCart;
    }

    public void addOneMoreProduct() {
        driver.findElement(plusIcon).click();
    }

    public int countOfProduct() {
        spinnerNotDisplayed();
        int countOfProduct = Integer.parseInt(driver.findElement(productQuantity).getAttribute("value"));
        return countOfProduct;
    }

    public void clickOnCrossIcon() {
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

    public void spinnerNotDisplayed() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(modalWithSpinner));
        } catch (Exception e) {
            System.out.println("Spinner is not displayed" + e);
        }
    }
}
