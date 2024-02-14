package com.tran.trapp.ozonSteps;

import androidx.test.uiautomator.UiObjectNotFoundException;
import com.tran.trapp.BaseClass;
import org.junit.Assert;


public class SearchItemSteps extends BaseClass {

    public static void searchItem() throws UiObjectNotFoundException, InterruptedException {
        String searchPen = "Ручка";

        ozonMainPage.checkOzonMainPageSearchStroke();
        ozonMainPage.ozonMainPageSearchStroke().click();
        ozonMainPage.inputSearchStroke().setText(searchPen);
        mDevice.pressEnter();
        Thread.sleep(2000);
        Assert.assertNotNull(ozonMainPage.foundProducts());
        Thread.sleep(2000);
    }
}
