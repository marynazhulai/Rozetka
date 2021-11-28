package ua.com.rozetka.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    private By menuCategories = By.xpath("//ul[contains(@class, 'menu-categories')] [contains(@class, 'menu-categories_type_main')]");
    private By computersAndNotebooksLink = By.xpath("//*[contains(@class, 'menu-categories_type_main')]//a[contains(@href, 'computers-notebooks')]");

    public boolean menuCategoriesIsDisplayed() {
        driver.findElement(menuCategories).isDisplayed();
        return true;
    }

    public void openComputersAndNotebooksCategory() {
        driver.findElement(computersAndNotebooksLink).click();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
