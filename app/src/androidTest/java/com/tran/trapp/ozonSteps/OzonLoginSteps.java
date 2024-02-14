package com.tran.trapp.ozonSteps;

import androidx.test.uiautomator.UiObjectNotFoundException;
import com.tran.trapp.BaseClass;
import org.junit.Assert;

public class OzonLoginSteps extends BaseClass {


    public static void loginOzon() throws UiObjectNotFoundException, InterruptedException {

        ozonMainPage.clickMainPageLoginBtn();
        ozonMainPage.checkAndLoginUsingPhoneNumber(); // for Ozon you need to use sim card in order to login. Email is not good for UI tests because you need to open mailbox to input code verification

        Thread.sleep(10000);
//        mDevice.pressBack();
        ozonMainPage.clickOzonProfile();
        Thread.sleep(7000);
        Assert.assertEquals("Анна Заяц", ozonMainPage.ozonProfilePage().getText());
        ozonMainPage.ozonProfilePage().click();
        ozonMainPage.scrollableIntoView();
        ozonMainPage.clickLogOutAcc();
        ozonMainPage.clickNotSaveCredentials();
    }
}
