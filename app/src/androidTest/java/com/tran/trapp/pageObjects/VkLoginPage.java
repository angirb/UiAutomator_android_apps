package com.tran.trapp.pageObjects;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiSelector;

public class VkLoginPage {
    protected UiDevice mDevice;
    public VkLoginPage(UiDevice mDevice) {
        this.mDevice = mDevice;
    }

    public UiObject loginInput() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/email_or_phone").text("Телефон или почта"));
    }
    public UiObject loginButton() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/vk_loading_btn_textView").text("Войти"));
    }
    public UiObject passwordInput() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/vk_password").text("Пароль"));
    }
    public UiObject continueLogin() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/vk_loading_btn_textView").text("Продолжить"));
    }
    public UiObject tryAnotherWayPass() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/retry_button").text("Подтвердить другим способом"));
    }
    public UiObject inputPasswordBtn() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/method_selector_type_title").text("Пароль"));

    }
}
