package ua.com.rozetka.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComputersAndNotebooksPage extends AbstractPage {
    private WebDriverWait wait;
    private By productInPopularProductsSection = By.xpath("/html/body/app-root/div/div/rz-super-portal/div/main/section/div[2]/rz-dynamic-widgets/rz-widget-goods/div/ul/app-slider/div[1]/div/ul/li[1]/li/app-goods-tile-lite/div/div[2]/a[2]");

    public void clickOnProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productInPopularProductsSection));
        driver.findElement(productInPopularProductsSection).click();
    }

    public ComputersAndNotebooksPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }
}
