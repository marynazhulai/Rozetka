package ua.com.rozetka.page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    private static final Logger LOG = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//ul[contains(@class, 'menu-categories')] [contains(@class, 'menu-categories_type_main')]")
    private WebElement menuCategories;
    @FindBy(xpath = "//*[contains(@class, 'menu-categories_type_main')]//a[contains(@href, 'computers-notebooks')]")
    private WebElement computersAndNotebooksLink;

    public boolean isMenuCategoriesDisplayed() {
        LOG.info("Menu Categories is displayed");
        return menuCategories.isDisplayed();
    }

    public void openComputersAndNotebooksCategory() {
        LOG.info("Open Computers and Notebooks category");
        computersAndNotebooksLink.click();
    }
}
