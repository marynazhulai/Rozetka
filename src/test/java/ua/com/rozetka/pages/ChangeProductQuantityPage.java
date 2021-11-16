package ua.com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeProductQuantityPage extends AbstractPage{
    private WebDriverWait wait;
    private By plusIcon  = By.cssSelector("[aria-label='Добавить ещё один товар']");
    private By countOfProduct  = By.cssSelector("input.cart-counter__input");
    private By container  = By.cssSelector(" [class='cart-counter']");



    public ChangeProductQuantityPage (WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }



    public void clickOnPlusIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(plusIcon));
        driver.findElement(plusIcon).click();
    }


    public String countOfProduct() {
       wait.until(ExpectedConditions.visibilityOfElementLocated(container));
       return driver.findElement(countOfProduct).getAttribute("value");
    }


}
