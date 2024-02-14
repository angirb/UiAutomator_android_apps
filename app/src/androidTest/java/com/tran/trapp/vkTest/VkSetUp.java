package com.tran.trapp.vkTest;

import androidx.test.uiautomator.UiObjectNotFoundException;
import com.tran.trapp.BaseClass;
import com.tran.trapp.pageObjects.VkLoginPage;
import com.tran.trapp.pageObjects.VkPageObjects;
import com.tran.trapp.utils.Watcher;
import com.tran.trapp.pageObjects.VkServicePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;


public class VkSetUp extends BaseClass {

    protected static VkPageObjects vkPageObjects;
    protected static VkLoginPage vkLoginPage;
    protected static String EMAIL = "tra*******b@gmail.com";
    protected static String PASSWORD = "*********";

    public static void openVk()  {
        vkPageObjects = new VkPageObjects(mDevice);
        vkPageObjects.vk().click();
    }

    public void closeVk() throws Exception {
        mDevice.pressRecentApps();
        vkPageObjects.clearAll().click();
    }

    @BeforeClass
    public static void beforeVkClass() throws Exception {
        setUp();
        openVk();
        loginVk();
        Thread.sleep(2000);
        mDevice.pressRecentApps();
        vkPageObjects.clearAll().click();
    }

    @AfterClass
    public static void afterVkClass() throws Exception {
        setUp();
        openVk();
        logOutVk();
        clearAppData("com.vkontakte.android");
        backToHomeScreen();
    }


    public static void loginVk() throws Exception {
        try {
            vkPageObjects = new VkPageObjects(mDevice);
            vkLoginPage = new VkLoginPage(mDevice);
            registerWatcher(Watcher.Condition.ALLOW);
            registerWatcher(Watcher.Condition.WHEN_USING_APP);
            registerWatcher(Watcher.Condition.ALLOW_TO_ALL);
            registerWatcher(Watcher.Condition.VK_NOT_NOW_UPDATE);

            if (vkPageObjects.mainPageExists()) {
                backToHomeScreen();
            } else {
                Thread.sleep(2000);
//            vkLoginPage.loginInput().waitForExists(LAUNCH_TIMEOUT);
                vkLoginPage.loginInput().setText(EMAIL);
                Thread.sleep(1000);
                vkLoginPage.loginButton().clickAndWaitForNewWindow();
                Thread.sleep(1000);
                vkLoginPage.tryAnotherWayPass().exists();
                vkLoginPage.tryAnotherWayPass().clickAndWaitForNewWindow(2000);
                vkLoginPage.inputPasswordBtn().click();
                vkLoginPage.passwordInput().setText(PASSWORD);
                vkLoginPage.continueLogin().click();
                vkPageObjects.mainPage().waitForExists(1000);
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logOutVk() throws Exception {
        vkPageObjects = new VkPageObjects(mDevice);
        vkServicePage = new VkServicePage(mDevice);
        vkServicePage.servicesPage().click();
        vkPageObjects.preSettButton().click();
        Thread.sleep(1000);
        try {
            vkPageObjects.settingsButton().click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        vkPageObjects.appSettings().click();
        vkPageObjects.scrollableIntoView();
        vkPageObjects.cleanAndLogOut().click();
        vkPageObjects.okButton().click();
    }
}
