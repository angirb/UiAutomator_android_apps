package com.tran.trapp.ozonPageObjects;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Assert;

public class OzonFreshPage {
    protected UiDevice mDevice;

    public OzonFreshPage(UiDevice mDevice) {
        this.mDevice = mDevice;
    }
    protected String currentAddress = "Профсоюзная ул., 56";


    public UiObject ozonFreshPage() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/menu_express")); // add button at the bottom ozon fresh section
    }
    public UiObject showDestinationOnMap() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/titleTv").text("Указать на карте")); // add show delivery destination on a map. need to add waiting
    }
    public UiObject currentAddress() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/titleTv").textContains("Москва, Профсоюзная улица, 56")); // add address of the destination "Москва, Профсоюзная улица, 56"
    }
    public UiObject chooseAnotherAddress() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/buttonAtomTitleTv").text("Искать другой адрес"));
    }
    public UiObject inputAnotherAddressField() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/textinput_placeholder"));
    }
    public UiObject selectAnotherAddress() {
        return mDevice.findObject(new UiSelector().textContains("Варшавское шоссе, 170Ек1"));
    }
    public UiObject continueBtn() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/buttonAtomTitleTv").textContains("Продолжить"));
    }
    public UiObject addressDetailsPageConfirmation() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/titleTv").textContains("Москва, Профсоюзная улица, 56")); // confirm the address on confirmation page
    }
    public UiObject AnotherAddressDetailsPageConfirmation() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/titleTv").textContains("Москва, Варшавское шоссе, 170Ек1")); // confirm another address on confirmation page
    }
    public UiObject saveAddressBtn() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/buttonAtomTitleTv").textContains("Сохранить адрес")); // press confirm button
    }
    public UiObject checkSavedAddressOnFreshMainPage() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/addressTv").textContains("Профсоюзная ул., 56")); // confirm whether address successfully saved
    }


    public void clickOzonFresh() throws UiObjectNotFoundException {
        ozonFreshPage().click();
    }
    public void clickShowDestinationOnMap() {
        try {
            showDestinationOnMap().clickAndWaitForNewWindow(3000);
        } catch (UiObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void checkCurrentAddress() {
        String expectedAddress = "Москва, Профсоюзная улица, 56";
        try {
            Assert.assertEquals(expectedAddress, currentAddress().getText());
        } catch (UiObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickContinueBtn() {
        try {
            continueBtn().click();
        } catch (UiObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickChooseAnotherAddressBtn() {
        try {
            chooseAnotherAddress().click();
        } catch (UiObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void inputAnotherAddress() {
        String anotherAddress = "Варшавское шоссе 170ек1";
        try {
            inputAnotherAddressField().setText(anotherAddress);
        } catch (UiObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickSelectAnotherAddress() throws UiObjectNotFoundException {
        selectAnotherAddress().click();
    }
    public void clickSaveAddressBtn() throws UiObjectNotFoundException {
        saveAddressBtn().click();
    }
    public void checkAddressOnExpressPage() throws UiObjectNotFoundException {
        Assert.assertEquals(currentAddress, checkSavedAddressOnFreshMainPage().getText());
    }
}
