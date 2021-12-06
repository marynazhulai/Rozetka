package ua.com.rozetka.page;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy (xpath = "//ul[contains(@class, 'menu-categories')] [contains(@class, 'menu-categories_type_main')]")
    private WebElement menuCategories;
    @FindBy (xpath = "//*[contains(@class, 'menu-categories_type_main')]//a[contains(@href, 'computers-notebooks')]")
    private WebElement computersAndNotebooksLink;
    private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

    public boolean isMenuCategoriesDisplayed() {
        LOG.info("Menu Categories is displayed");
       return menuCategories.isDisplayed();
    }

    public void openComputersAndNotebooksCategory() {
        LOG.info("Open Computers and Notebooks category");
        computersAndNotebooksLink.click();
    }
}
