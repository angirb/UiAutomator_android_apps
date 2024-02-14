package com.tran.trapp;

import android.view.KeyEvent;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;

import com.tran.trapp.ozonPageObjects.OzonFreshPage;
import com.tran.trapp.ozonPageObjects.OzonMainPage;
import com.tran.trapp.pageObjects.VkLoginPage;
import com.tran.trapp.pageObjects.VkMessagePage;
import com.tran.trapp.pageObjects.VkPageObjects;
import com.tran.trapp.pageObjects.VkServicePage;
import com.tran.trapp.utils.Watcher;

import org.junit.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class BaseClass {
    protected static UiDevice mDevice; // объявляем защищенную статическую переменную mDevice типа UiDevice
    protected static final int LAUNCH_TIMEOUT = 5000; // объявляем защищенную статическую константу типа int
    public static final long WAIT_TIME = 5000; // объявляем открытую статическую константу типа long
    protected static Watcher myWatcher; // объявляем защищенную статическую переменную myWatcher типа Watcher
    protected static VkPageObjects vkPageObjects; // объявляем защищенную статическую переменную vkPageObjects типа VkPageObjects
    protected static VkMessagePage vkMessagePage;
    protected static VkLoginPage vkLoginPage;
    protected static VkServicePage vkServicePage;
    protected static OzonMainPage ozonMainPage;
    protected static OzonFreshPage ozonFreshPage;


    /**
     * clear app data
     */
    public static void clearAppData(String packageName) throws IOException {
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).executeShellCommand("pm clear " + packageName);
    }

    /**
     * set up including launcher package
     */
    protected static void setUp() throws Exception {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        final String launcherPackage = mDevice.getLauncherPackageName();
        startDut();
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);
        myWatcher = new Watcher(mDevice);
        vkPageObjects = new VkPageObjects(mDevice);
        vkMessagePage = new VkMessagePage(mDevice);
        vkLoginPage = new VkLoginPage(mDevice);
        vkServicePage = new VkServicePage(mDevice);
        ozonMainPage = new OzonMainPage(mDevice);
        ozonFreshPage = new OzonFreshPage(mDevice);
    }

    public static void startDut() throws Exception {
        screenOn();
        unLockSettings();
    }

    public static void sleepDut() throws Exception {
        backToHomeScreen();
        BaseClass.mDevice.sleep();
    }

    /**
     * watcher to confirm on android pop up alert windows
     */
    public static void registerWatcher(Watcher.Condition condition) {
        mDevice.registerWatcher(condition.toString(), myWatcher.getWatcher(condition));
    }
    /**
     * wake up screen
     */
    public static void screenOn() throws Exception {
        if (!mDevice.isScreenOn()) {
            mDevice.wakeUp();
            Thread.sleep(3000);
            boolean screenState = mDevice.isScreenOn();
            Assert.assertTrue(screenState);
        }
    }
    /**
     * back to home screen
     */
    public static void backToHomeScreen() throws Exception {
        for (int i = 0; i < 8; i++) {
            if (mDevice.findObject(By.descContains("Home screen")) == null) {
                mDevice.pressHome();
                Thread.sleep(500);
            } else {
                break;
            }
        }
        mDevice.pressHome();
        Thread.sleep(1000);
    }
    /**
     * click pin code
     */
    private static void clickSystemNumberKey(String number) {
        for (int i = 0; i <number.length(); i++) {
            char c = number.charAt(i);
            int keyCode = KeyEvent.KEYCODE_0 + Character.getNumericValue(c);
            mDevice.pressKeyCode(keyCode);
        }
    }
    /**
     * input pin code or password with certain digit numbers
     */

    public static void unLockSettings()  {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put ("Введите PIN-код", "0000");
        hashMap.put("Введите пароль","0000");
        UiObject2 lockType = mDevice.wait(Until.findObject(By.res("com.android.systemui:id/keyguard_message_area")), WAIT_TIME);
        if (lockType != null) {
            String lockText = lockType.getText();
            if (lockText.equals("Введите PIN-код")) {
                clickSystemNumberKey(Objects.requireNonNull(hashMap.get("Введите PIN-код")));
            } else if (lockText.equals("Введите пароль")) {
                clickSystemNumberKey(Objects.requireNonNull(hashMap.get("Введите пароль")));
            } else {
                mDevice.pressHome();
            }
        }
    }
}
