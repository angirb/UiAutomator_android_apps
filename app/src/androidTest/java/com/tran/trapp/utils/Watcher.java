package com.tran.trapp.utils;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiWatcher;

import com.google.firebase.crashlytics.buildtools.reloc.javax.annotation.Nonnull;

import java.util.regex.Pattern;

public class Watcher {

    private final UiDevice mDevice;

    public Watcher(UiDevice mDevice) {
        this.mDevice = mDevice;
    }
    public UiWatcher getWatcher(Condition condition) {
        return () -> {
            Pattern p = Pattern.compile("^(?i)" + condition.toString() + "$");
            UiObject2 popUpWindow = mDevice.findObject(By.text(p));
            while (popUpWindow != null) {
                popUpWindow.click();
                popUpWindow = mDevice.findObject(By.text(p));
            }
            return true;
        };
    }
    public enum Condition {
        //System popup permission
        ALLOW("РАЗРЕШИТЬ"),
        WHEN_USING_APP("ПРИ ИСПОЛЬЗОВАНИИ ПРИЛОЖЕНИЯ"),
        ALLOW_TO_ALL("Разрешить ко всем"), // new in Android 14
        //Vk popup permission
        VK_NOT_NOW_UPDATE("Не сейчас"),
        //Ozon popup permission
        ALLOW_ALL_NOTIFICATION_OZON("Разрешить уведомления"),
        ALLOW_OZON("Разрешить");

        private final String conditionName;

        Condition(String name) {
            conditionName = name;
        }

        @Nonnull
        @Override
        public String toString() {
            return conditionName;
        }
    }
}
