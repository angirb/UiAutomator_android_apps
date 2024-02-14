package com.tran.trapp.steps;

import androidx.test.uiautomator.UiObjectNotFoundException;
import com.tran.trapp.BaseClass;
import com.tran.trapp.pageObjects.VkMessagePage;
import com.tran.trapp.pageObjects.VkPageObjects;
import org.junit.Assert;


public class MessageSteps extends BaseClass {

    public static void sendMsg() throws UiObjectNotFoundException, InterruptedException {
        vkPageObjects = new VkPageObjects(mDevice);
        vkMessagePage = new VkMessagePage(mDevice);

        String expectedMsg = "thisIsTestMessageInEnglish, а это сообщение на русском языке";
        vkMessagePage.msgButton().clickAndWaitForNewWindow();
        vkMessagePage.sendMsgToUser().clickAndWaitForNewWindow();
        vkMessagePage.sendMsgInput().setText(expectedMsg);
        vkMessagePage.sendMsgButton().click();
        Thread.sleep(2000);
        Assert.assertEquals(expectedMsg, vkMessagePage.textMsgSent().getText());


    }

    public static void sendPhotoInMsg() throws UiObjectNotFoundException, InterruptedException {
        vkPageObjects = new VkPageObjects(mDevice);
        vkMessagePage = new VkMessagePage(mDevice);

        vkMessagePage.msgButton().clickAndWaitForNewWindow();
        vkMessagePage.sendMsgToUser().click();
        vkMessagePage.attachBtnInMsg().click();
        vkPageObjects.takePhotoBtnInMsg().click();
        vkPageObjects.takePicBtn().click();
        vkMessagePage.confirmPicBtn().clickAndWaitForNewWindow(1000);
        vkPageObjects.btnEditorComplete().isClickable();
        vkPageObjects.btnEditorComplete().click();
        Thread.sleep(2000);
        vkMessagePage.sendMsgButton().clickAndWaitForNewWindow();
        Thread.sleep(2000);
        Assert.assertTrue(vkMessagePage.photoHasBeenSent().exists());
    }

    public static void sendGeoInMsg() throws UiObjectNotFoundException, InterruptedException {
        vkPageObjects = new VkPageObjects(mDevice);
        vkMessagePage = new VkMessagePage(mDevice);

        vkMessagePage.msgButton().clickAndWaitForNewWindow();
        vkMessagePage.sendMsgToUser().click();
        vkMessagePage.attachBtnInMsg().click();
        vkPageObjects.scrollableHorizontal().scrollTextIntoView("Место");
        vkMessagePage.sendGeoBtn().click();
        Thread.sleep(2000);
        vkMessagePage.currentLocationBtn().click();
        Thread.sleep(2000);
        vkMessagePage.sendMsgButton().click();
        Thread.sleep(2000);
        Assert.assertTrue(vkMessagePage.geoHasBeenSent().exists());

    }
    public static void sendSongInMsg() throws UiObjectNotFoundException, InterruptedException {
        vkPageObjects = new VkPageObjects(mDevice);
        vkMessagePage = new VkMessagePage(mDevice);

        vkMessagePage.msgButton().clickAndWaitForNewWindow();
        vkMessagePage.sendMsgToUser().click();
        vkMessagePage.attachBtnInMsg().click();

        vkMessagePage.songBtn().click();
        Thread.sleep(1000);
        vkMessagePage.sendSongInMsg().click();
        Thread.sleep(1000);
        vkMessagePage.addSongBtn().click();
        Thread.sleep(1000);
        vkMessagePage.sendMsgButton().click();
        Thread.sleep(2000);
        Assert.assertTrue(vkMessagePage.songHasBeenSent().exists());
    }
}
