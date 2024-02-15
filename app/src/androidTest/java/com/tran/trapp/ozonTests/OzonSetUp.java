package com.tran.trapp.ozonTests;
import androidx.test.uiautomator.UiObjectNotFoundException;
import com.tran.trapp.BaseClass;
import com.tran.trapp.ozonPageObjects.OzonMainPage;
import com.tran.trapp.rules.RetryTestRule;
import com.tran.trapp.utils.Watcher;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

public class OzonSetUp extends BaseClass {
    protected static OzonMainPage ozonMainPage;
    @Rule
    public RetryTestRule retryRule = new RetryTestRule(2);

    @BeforeClass
    public static void beforeOzonClass() throws Exception {
        ozonMainPage = new OzonMainPage(mDevice);
        BaseClass.setUp();
        openOzon();
        Thread.sleep(2000);
        mDevice.pressRecentApps();
        vkPageObjects.clearAll().click();
        registerWatcher(Watcher.Condition.ALLOW);
        registerWatcher(Watcher.Condition.WHEN_USING_APP);
        registerWatcher(Watcher.Condition.ALLOW_TO_ALL);
        registerWatcher(Watcher.Condition.ALLOW_ALL_NOTIFICATION_OZON);
        registerWatcher(Watcher.Condition.ALLOW_OZON);
    }
    public static void openOzon() {
        ozonMainPage = new OzonMainPage(mDevice);
        ozonMainPage.ozonApp().click();
    }

    public void closeOzon() throws Exception {
        mDevice.pressRecentApps();
        vkPageObjects.clearAll().click();
    }
    @AfterClass
    public static void afterOzonClass() throws Exception {
        BaseClass.setUp();
        backToHomeScreen();
        clearAppData("ru.ozon.app.android");
    }
}
