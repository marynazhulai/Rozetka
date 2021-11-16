package ua.com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupClosedPage extends AbstractPage {
    private WebDriverWait wait;
    private By crossIcon  = By.cssSelector("[aria-label='Закрыть модальное окно']");
    private By confirmationPopupTitle = By.cssSelector("[class='modal__heading']");

    public PopupClosedPage (WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }


    public void clickOnCrossIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(crossIcon));
        driver.findElement(crossIcon).click();
    }

    public boolean popupClosed() {
        try {
            driver.findElement(confirmationPopupTitle).isDisplayed();
            return true;
        }
        catch (Exception cartTitleNotFound){
            return false;
        }




    }





}
