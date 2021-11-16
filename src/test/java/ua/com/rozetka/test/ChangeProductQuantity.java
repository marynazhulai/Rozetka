package ua.com.rozetka.test;

import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.pages.AddProductToCardPage;
import ua.com.rozetka.pages.ChangeProductQuantityPage;

public class ChangeProductQuantity extends BaseTest {

    WebDriverWait wait;


    ChangeProductQuantityPage changeProductQuantityPage;
    AddProductToCardPage addProductToCardPage;


    @Test
    public void changeProductQuantity () throws InterruptedException {

        changeProductQuantityPage = new ChangeProductQuantityPage(driver);
        addProductToCardPage = new AddProductToCardPage(driver);

        addProductToCardPage.productIsAddedToCart();
        changeProductQuantityPage.clickOnPlusIcon();

        String countOfProduct = changeProductQuantityPage.countOfProduct();
        Assert.assertEquals(countOfProduct, "2");


        String productPrice = addProductToCardPage.getExpectedProductPrice();
        String productPriceAfterConverting = productPrice.replaceAll ("[^A-Za-zА-Яа-я0-9]", "");
        double productPriceAfterConvertingToDouble = Double.parseDouble(productPriceAfterConverting);

        double countOfProductAfterConvertingToDouble = Double.parseDouble(countOfProduct);

        double recalculatedSubtotalInDouble = productPriceAfterConvertingToDouble * countOfProductAfterConvertingToDouble;

        double expectedSubtotal = productPriceAfterConvertingToDouble * 2.0;
        Assert.assertEquals(recalculatedSubtotalInDouble, expectedSubtotal);


        Thread.sleep(2000);
        String getRecalculatedTotal = addProductToCardPage.getActualTotal();
        String recalculatedTotalAfterConverting = getRecalculatedTotal.replaceAll ("[^A-Za-zА-Яа-я0-9]", "");
        double recalculatedTotalInDouble = Double.parseDouble(recalculatedTotalAfterConverting);

        Assert.assertEquals(recalculatedTotalInDouble, expectedSubtotal);


    }





}
