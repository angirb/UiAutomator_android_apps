package com.tran.trapp.ozonPageObjects;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

public class OzonMainPage {
    protected UiDevice mDevice;

    public OzonMainPage(UiDevice mDevice) {
        this.mDevice = mDevice;
    }

    //MainPage
    public UiObject2 ozonApp() {
        return mDevice.findObject(By.desc("OZON"));
    }
    //bottom buttons section of Main menu
    public UiObject mainPageBtn() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/menu_main"));
    }
    public void clickMainPageBtn() throws UiObjectNotFoundException {
        mainPageBtn().click();
    }

    public UiObject ozonCatalogue() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/menu_catalog"));
    }
    public void clickOzonCatalogue() throws UiObjectNotFoundException {
        ozonCatalogue().click();
    }
    public UiObject ozonBank() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/menu_bank"));
    }
    public void clickOzonBank() throws UiObjectNotFoundException {
        ozonBank().click();
    }
    public UiObject ozonCart() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/menu_cart"));
    }
    public void clickOzonCart() throws UiObjectNotFoundException {
        ozonCart().click();
    }
    public UiObject ozonProfile() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/menu_profile"));
    }
    public void clickOzonProfile() throws UiObjectNotFoundException {
        ozonProfile().click();
    }
    public UiObject enterOrRegister() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/titleTv").text("Войти или зарегистрироваться"));
    }
    public void clickEnterOrRegister() {
        try {
            enterOrRegister().click();
        } catch (UiObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public UiObject ozonProfilePage() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/sellerNameTv").text("Анна Заяц"));
    }
    public UiScrollable scrollableIntoView() throws UiObjectNotFoundException {
        UiScrollable scrollable = new UiScrollable(new UiSelector().scrollable(true).instance(0));
        scrollable.scrollIntoView(new UiSelector().text("Выйти из аккаунта"));
        return scrollable;
    }
    public UiObject logOutAcc() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/logoutTv").text("Выйти из аккаунта"));
    }
    public void clickLogOutAcc() throws UiObjectNotFoundException {
        logOutAcc().click();
    }
    public UiObject notSaveCredentials() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/cancelButton"));
    }
    public void clickNotSaveCredentials() throws UiObjectNotFoundException {
        notSaveCredentials().click();
    }

    public UiObject ozonMainPageSearchStroke() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/searchTv").text("Искать на Ozon"));
    }
    public void checkOzonMainPageSearchStroke() {
        ozonMainPageSearchStroke().exists();
    }
    public UiObject inputSearchStroke() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/etSearch"));
    }
    public UiObject mainPageLoginBtn() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/topRightContainer"));
    }
    public void clickMainPageLoginBtn() throws UiObjectNotFoundException {
        mainPageLoginBtn().click();
    }
    public UiObject mainPageItemResId() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/hammerBodyImageIv"));
    }
    public void clickMainPageItemResId() throws UiObjectNotFoundException {
        mainPageItemResId().click();
    }
    public UiObject pressLoginBtn() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/submitButton"));
    }
    public void clickPressLoginBtn() throws UiObjectNotFoundException {
        pressLoginBtn().click();
    }
    public UiObject checkPhoneNumberIntoLoginCredentials() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/inputEditText").text("999 671 22 60"));
    }

    public UiObject inputLoginPhoneNumberField() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/inputEditText"));
    }

    public void checkAndLoginUsingPhoneNumber() throws UiObjectNotFoundException {
        String yotaPhoneNumber = "999 671 22 60";
        UiObject phoneNumberField = inputLoginPhoneNumberField();
        UiObject existingPhoneNumberField = checkPhoneNumberIntoLoginCredentials();
        if (existingPhoneNumberField.exists()) {
            clickPressLoginBtn();
        } else {
            phoneNumberField.setText(yotaPhoneNumber);
            clickPressLoginBtn();
        }
    }

    //Cart
    public UiObject addToCart() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/btnTitleTv").text("В корзину"));
    }
    public void clickAddToCart() throws UiObjectNotFoundException {
        addToCart().click();
    }
    public UiObject addToCartDeliverToday() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/secondCb"));
    }
    public void clickAddToCartDeliverToday() throws UiObjectNotFoundException {
        addToCartDeliverToday().click();
    }
    public UiObject itemAddedToCartSuccess() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/btnTitleTv").text("В корзине"));
    }
    public void checkItemAddedToCart() throws UiObjectNotFoundException {
        itemAddedToCartSuccess().getText();
    }
    public UiObject cartIcon1ItemAdded() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/tab_badge").text("1"));
    }
    public void checkIf1ItemInCart() {
        cartIcon1ItemAdded().exists();
    }
    public UiObject itemClickRandom() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/itemsRv"));
    }
    public UiObject foundProducts() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/headerTv").text("Найдено 423 936 товаров"));
    }
    public UiObject favouriteIconInsideProduct() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/favIcon"));
    }
    public UiObject addToCartInsideProduct() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/btnTitleTv").text("Завтра"));
    }
    public UiObject deliveryTitleInCart() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/titleSA").text("Доставка Ozon"));
    }
    public UiObject deleteItemInCart() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/removeButton"));
    }
    public UiObject deleteItemInCartConfirmBtn() {
        return mDevice.findObject(new UiSelector().resourceId("android:id/button1").text("УДАЛИТЬ ТОВАР"));
    }
    public UiObject cartIsEmpty() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/emptyCartV2Title").text("Корзина пуста"));
    }
    public UiObject addItemFromSearch() {
        return mDevice.findObject(new UiSelector().resourceId("ru.ozon.app.android:id/addToCartButton"));
    }
    public void clickAddItemFromSearch() throws UiObjectNotFoundException {
        addItemFromSearch().click();
    }
}
