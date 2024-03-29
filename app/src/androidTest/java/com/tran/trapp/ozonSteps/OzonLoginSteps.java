package com.tran.trapp.ozonSteps;

import androidx.test.uiautomator.UiObjectNotFoundException;
import com.tran.trapp.BaseClass;
import org.junit.Assert;

public class OzonLoginSteps extends BaseClass {


    public static void loginOzon() throws UiObjectNotFoundException, InterruptedException {

        ozonMainPage.clickOzonProfile();
        ozonMainPage.clickEnterOrRegister();
        ozonMainPage.checkAndLoginUsingPhoneNumber(); // for Ozon you need to use sim card in order to login. Email is not good for UI tests because you need to open mailbox to input code verification
        mDevice.waitForIdle(10000);
        ozonMainPage.clickOzonProfile();
        Thread.sleep(5000);
        Assert.assertEquals("Анна Заяц", ozonMainPage.ozonProfilePage().getText());
        ozonMainPage.ozonProfilePage().click();
        ozonMainPage.scrollableIntoView();
        ozonMainPage.clickLogOutAcc();
        ozonMainPage.clickNotSaveCredentials();
    }
}
