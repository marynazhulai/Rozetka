package ua.com.rozetka.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private WebDriverWait wait;
    private By computersAndNotebooksLink = By.xpath("//*[contains(@class, 'menu-categories_type_main')]//a[contains(@href, 'computers-notebooks')]");

    public void openComputersAndNotebooksCategory() {
        driver.findElement(computersAndNotebooksLink).click();
    }

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }
}
