package com.tran.trapp.vkTest;
import static com.tran.trapp.steps.MessageSteps.sendGeoInMsg;
import static com.tran.trapp.steps.MessageSteps.sendMsg;
import static com.tran.trapp.steps.MessageSteps.sendPhotoInMsg;
import static com.tran.trapp.steps.MessageSteps.sendSongInMsg;
import static io.qameta.allure.SeverityLevel.CRITICAL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.junit4.DisplayName;


@RunWith(JUnit4.class)
public class MessageTest extends VkSetUp {


    @Before
    public void beforeVk() {
        openVk();
    }

    @Test
    @DisplayName("Sending message test")
    @Description("Test include opening VK app, goes to Message section and sends a text message to Albert Kurnev")
    @Severity(CRITICAL)
    @Owner("Ang")
    public void testMsg() throws Exception {
        sendMsg();
    }


    @Test
    @DisplayName("Sending photo test")
    @Description("Sending a photo in PM by taking a new picture")
    @Severity(CRITICAL)
    @Owner("Ang")
    public void testPhotoSendMsg() throws Exception {
        sendPhotoInMsg();
    }


    @Test
    @DisplayName("Sending geo position test")
    @Description("Sending geolocation in PM to a friend from message section")
    @Severity(CRITICAL)
    @Owner("Ang")
    public void testGeoSendMsg() throws Exception {
        sendGeoInMsg();
    }


    @Test
    @DisplayName("Sending song test")
    @Description("Sending a song from playlist and sending it to a friend")
    @Severity(CRITICAL)
    @Owner("Ang")
    public void testSongSendMsg() throws Exception {
        sendSongInMsg();
    }
    @After
    public void afterVk() throws Exception {
        closeVk();

    }

}
