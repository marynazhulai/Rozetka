package ua.com.rozetka.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComputersAndNotebooksPage extends AbstractPage {
    private WebDriverWait wait;
    private By productInPopularProductsSection = By.xpath("(//a[@class='lite-tile__picture'])[1]");

    public void clickOnProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productInPopularProductsSection));
        driver.findElement(productInPopularProductsSection).click();
    }

    public ComputersAndNotebooksPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }
}
