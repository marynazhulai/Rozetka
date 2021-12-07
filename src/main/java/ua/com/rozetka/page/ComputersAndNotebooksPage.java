package ua.com.rozetka.page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputersAndNotebooksPage extends AbstractPage {
    @FindBy(xpath = "(//a[@class='lite-tile__picture'])[1]")
    private WebElement productInPopularProductsSection;
    private static final Logger LOG = LogManager.getLogger(ComputersAndNotebooksPage.class);

    public void clickOnProduct() {
        LOG.info("Click on Product on Computers and Notebooks page");
        productInPopularProductsSection.click();
    }
}
