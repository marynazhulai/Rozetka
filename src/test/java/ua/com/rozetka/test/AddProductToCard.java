package ua.com.rozetka.test;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.com.rozetka.pages.AddProductToCardPage;


public class AddProductToCard extends BaseTest {

    WebDriverWait wait;
    AddProductToCardPage addProductToCardPage;




    @Test
    public void addProductToCard() {
        addProductToCardPage = new AddProductToCardPage(driver);

        addProductToCardPage.goToLink();

        String expectedProductTitle = addProductToCardPage.getExpectedProductTitle();

        addProductToCardPage.clickOnProduct();

        String expectedProductPrice = addProductToCardPage.getExpectedProductPrice();
        String expectedProductPriceAfterConverting = expectedProductPrice.replaceAll ("[^A-Za-zА-Яа-я0-9]", "");

        addProductToCardPage.addProductToCart();

        String confirmationPopupTitle = addProductToCardPage.getConfirmationPopupTitle();
        Assert.assertEquals(confirmationPopupTitle, "Корзина");

        String actualProductTitle = addProductToCardPage.getActualProductTitle();
        Assert.assertEquals(actualProductTitle, expectedProductTitle);


        String actualSubtotal = addProductToCardPage.getActualSubtotal();
        String actualSubtotalAfterConverting = actualSubtotal.replaceAll ("[^A-Za-zА-Яа-я0-9]", "");
        String actualTotal = addProductToCardPage.getActualTotal();
        String actualTotalAfterConverting = actualTotal.replaceAll ("[^A-Za-zА-Яа-я0-9]", "");

        Assert.assertEquals(actualSubtotalAfterConverting, expectedProductPriceAfterConverting);
        Assert.assertEquals(actualTotalAfterConverting, expectedProductPriceAfterConverting);

    }
}
