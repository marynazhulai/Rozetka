package ua.com.rozetka.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputersAndNotebooksPage extends AbstractPage {
    private By productInPopularProductsSection = By.xpath("(//a[@class='lite-tile__picture'])[1]");

    public void clickOnProduct() {
        driver.findElement(productInPopularProductsSection).click();
    }

    public ComputersAndNotebooksPage(WebDriver driver) {
        super(driver);
    }
}
