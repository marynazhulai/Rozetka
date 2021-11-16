package ua.com.rozetka.test;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.pages.AddProductToCardPage;
import ua.com.rozetka.pages.HomepagePage;


public class OpenHomePage extends BaseTest {
    WebDriverWait wait;
    HomepagePage homepagePage;


    @Test (description = "verify user is able to log in to app")

    public void openHomePage() {
        homepagePage = new HomepagePage(driver);
        String expectedTitle = "Интернет-магазин ROZETKA™: официальный сайт самого популярного онлайн-гипермаркета в Украине";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
