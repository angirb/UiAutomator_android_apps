package com.tran.trapp.pageObjects;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiSelector;

public class VkMessagePage {
    protected UiDevice mDevice;

    public VkMessagePage(UiDevice mDevice) {
        this.mDevice = mDevice;
    }

    public UiObject msgButton() {
        return mDevice.findObject(new UiSelector().text("Мессенджер"));
    }
    public UiObject sendMsgToUser() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/dialog_item_title").text("+79775990424"));
    }
    public UiObject sendMsgInput() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/writebar_edit").text("Сообщение"));
    }
    public UiObject sendMsgButton() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/writebar_send")); //can be used to send msg in comments as well
    }
    public UiObject userMainPage() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/user_photo"));
    }
    public UiObject postMsgButton() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/tv_primary_action").text("Опубликовать"));
    }
    public UiObject createPost() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/create_post").text("Запись"));
    }
    public UiObject inputTextPost() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/posting_edit_text").text("Что у вас нового?"));
    }
    public UiObject publishPostButton() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/btn_done").text("Опубликовать"));
    }
    public UiObject textMsgSent() {
        return mDevice.findObject(new UiSelector().className("android.widget.TextView").text("thisIsTestMessageInEnglish, а это сообщение на русском языке"));
    }
    public UiObject photoHasBeenSent() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/image").descriptionContains("Фотография"));
    }
    public UiObject geoHasBeenSent() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/map").descriptionContains("Местоположение"));
    }
    public UiObject songHasBeenSent() {
        return mDevice.findObject(new UiSelector().className("android.view.ViewGroup").descriptionContains("Воспроизвести Legendary Welshly Arms"));
    }


    //Messages
    public UiObject msgPhotoBtn() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/tv_title").text("Фото/Видео"));
    }
    public UiObject attachBtnInMsg() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/writebar_attach"));
    }

    public UiObject sendGeoBtn() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/tv_title").text("Место"));
    }
    public UiObject currentLocationBtn() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/vkim_location_title").text("Текущее местоположение"));
    }
    public UiObject songBtn() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/tv_title").text("Музыка"));
    }
    public UiObject sendSongInMsg() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/audio_title").text("Legendary"));
    }
    public UiObject addSongBtn() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/attach_counter_title_text_view").text("Добавить"));
    }
    public UiObject confirmPicBtn() {
        return mDevice.findObject(new UiSelector().resourceId("com.transsion.camera:id/done_button"));
    }
}
