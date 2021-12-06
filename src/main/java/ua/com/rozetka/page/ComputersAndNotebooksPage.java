package ua.com.rozetka.page;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputersAndNotebooksPage extends AbstractPage {
    @FindBy (xpath = "//a[@class='lite-tile__picture'])[1])")
    private WebElement productInPopularProductsSection;
    private static final Logger LOG = LoggerFactory.getLogger(ComputersAndNotebooksPage.class);

    public void clickOnProduct() {
        LOG.info("Click on Product on Computers and Notebooks page");
        productInPopularProductsSection.click();
    }
}
