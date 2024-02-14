package com.tran.trapp.ozonSteps;

import androidx.test.uiautomator.UiObjectNotFoundException;
import com.tran.trapp.BaseClass;
import org.junit.Assert;



public class AddToCartSteps extends BaseClass {

    public static void addToCart() throws UiObjectNotFoundException, InterruptedException {
        String expectedMsg = "В корзине";

        ozonMainPage.clickMainPageItemResId();
        if(ozonMainPage.addToCart().exists()) {
            ozonMainPage.clickAddToCart();
        } else {
            ozonMainPage.clickAddToCartDeliverToday();
        }
        Assert.assertEquals(expectedMsg, ozonMainPage.itemAddedToCartSuccess().getText());
        ozonMainPage.cartIcon1ItemAdded().click();
        ozonMainPage.deleteItemInCart().click();
        ozonMainPage.deleteItemInCartConfirmBtn().click();
        Thread.sleep(1000);
        Assert.assertEquals("Корзина пуста", ozonMainPage.cartIsEmpty().getText());

    }
    public static void addToCartFromSearch() throws UiObjectNotFoundException, InterruptedException {
        String searchPen = "Ручка";
        ozonMainPage.checkOzonMainPageSearchStroke();
        ozonMainPage.ozonMainPageSearchStroke().click();
        ozonMainPage.inputSearchStroke().setText(searchPen);
        mDevice.pressEnter();
        ozonMainPage.clickAddItemFromSearch();
        ozonMainPage.cartIcon1ItemAdded().click();
        Thread.sleep(2000);
        Assert.assertTrue(ozonMainPage.deliveryTitleInCart().getText(), true);
        Thread.sleep(3000);
        ozonMainPage.deleteItemInCart().click();
        ozonMainPage.deleteItemInCartConfirmBtn().click();

    }
}
