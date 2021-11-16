package ua.com.rozetka.test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.pages.AddProductToCardPage;
import ua.com.rozetka.pages.ChangeProductQuantityPage;
import ua.com.rozetka.pages.PopupClosedPage;

public class PopupClosed extends BaseTest {
    WebDriverWait wait;
    PopupClosedPage popupClosedPage;
    AddProductToCardPage addProductToCardPage;


    @Test
    public void addProductToCard() {
        popupClosedPage = new PopupClosedPage (driver);
        addProductToCardPage = new AddProductToCardPage (driver);
        addProductToCardPage.productIsAddedToCart();
        popupClosedPage.clickOnCrossIcon();
        boolean popupClosed = popupClosedPage.popupClosed();
        Assert.assertEquals(popupClosed, false);
    }





}