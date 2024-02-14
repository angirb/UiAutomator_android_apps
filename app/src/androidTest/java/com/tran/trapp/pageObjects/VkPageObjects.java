package com.tran.trapp.pageObjects;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;


public class VkPageObjects {

    protected UiDevice mDevice;

    public VkPageObjects(UiDevice mDevice) {
        this.mDevice = mDevice;
    }


    public UiObject2 vk() {
        return mDevice.findObject(By.desc("VK"));
    }


    public UiObject clearAll() {
        return mDevice.findObject(new UiSelector().resourceId("com.transsion.hilauncher:id/ts_btn_recents_clear"));
    }

    public void scrollableIntoViewVk() throws UiObjectNotFoundException {
        UiScrollable scrollable = new UiScrollable(new UiSelector().scrollable(true).instance(0));
        scrollable.setAsVerticalList(); // Set the scrollable view as a vertical list
        scrollable.scrollForward(2); // Scroll backward (from right to left) until it finds "VK"
        scrollable.scrollTextIntoView("VK");
    }
    public UiScrollable scrollableHorizontal() throws UiObjectNotFoundException {
        UiScrollable scrollable = new UiScrollable(new UiSelector().scrollable(true).instance(0));
        scrollable.setAsHorizontalList(); // Set the scrollable view as a horizontal list
        scrollable.scrollForward(); // Scroll backward (from right to left) until it finds "VK"
        return scrollable;
    }



    //Main Page
    public UiObject mainPage() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/title").text("Главная"));
    }
    public boolean mainPageExists() {
        UiObject mainPageTrue = mainPage();
      return mainPageTrue.exists();
    }
    public UiObject mainPageBtn() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/navigation_bar_item_small_label_view").text("Главная"));
    }
    public UiObject userPhotoMainPage() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/user_photo"));
    }
    public boolean userPhotoMainPageExists() {
        UiObject checkUserPhoto = userPhotoMainPage();
        return checkUserPhoto.exists();
    }



    //Settings
    public UiObject preSettButton() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/menu"));
    }
    public UiObject settingsButton() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/title").text("Настройки"));
    }
    public UiObject appSettings() {
        return mDevice.findObject(new UiSelector().resourceId("android:id/text1").text("Приложение"));
    }
    public UiObject logOutButton() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/logout").text("Выйти"));
    }
    public UiObject logOutButtonTitle() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/item_logout_title").text("Выйти"));
    }
    public UiScrollable scrollableIntoView() throws UiObjectNotFoundException {
        UiScrollable scrollable = new UiScrollable(new UiSelector().scrollable(true).instance(0));
        scrollable.scrollIntoView(new UiSelector().text("Очистить всё и выйти"));
        return scrollable;
    }
    public UiObject cleanAndLogOut() {
        return mDevice.findObject(new UiSelector().text("Очистить всё и выйти"));
    }
    public UiObject okButton() {
        return mDevice.findObject(new UiSelector().resourceId("android:id/button1"));
    }
    public UiObject2 logOutSettingsButton() {
        return mDevice.findObject(By.res("com.vkontakte.android:id/settings"));
    }
    public UiObject clearAccInfoIcon() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/delete_icon"));
    }
    public UiObject deleteAccConfirm() {
        return mDevice.findObject(new UiSelector().resourceId("android:id/button1").text("Удалить"));
    }
    //Settings



    //Photo
    public UiObject takePicBtn() {
        return mDevice.findObject(new UiSelector().resourceId("com.transsion.camera:id/shutter_button"));
    }
    public UiObject takePhotoBtnInMsg() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/picker_attach_gallery_photo_text_view"));
    }
    public UiObject2 btnEditorComplete() {
        return mDevice.findObject(By.res("com.vkontakte.android:id/button_editor_complete"));
    }
    //Photo
}
