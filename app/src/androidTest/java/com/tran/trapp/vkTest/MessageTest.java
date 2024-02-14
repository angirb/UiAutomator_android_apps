package com.tran.trapp.vkTest;
import static com.tran.trapp.steps.MessageSteps.sendGeoInMsg;
import static com.tran.trapp.steps.MessageSteps.sendMsg;
import static com.tran.trapp.steps.MessageSteps.sendPhotoInMsg;
import static com.tran.trapp.steps.MessageSteps.sendSongInMsg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;




@RunWith(JUnit4.class)
public class MessageTest extends VkSetUp {

    @Before
    public void beforeVk() {
        openVk();
    }

    @Test
//    @Description("Test include opening VK app, goes to Message section and sends a text message to Albert Kurnev")
    public void testMsg() throws Exception {
        sendMsg();
    }


    @Test
//    @Description("Sending a photo in PM by taking a new picture")
    public void testPhotoSendMsg() throws Exception {
        sendPhotoInMsg();
    }


    @Test
//    @Description("Sending geolocation in PM to a friend from message section")
    public void testGeoSendMsg() throws Exception {
        sendGeoInMsg();
    }


    @Test
//    @Description("Sending a song from playlist and sending it to a friend")
    public void testSongSendMsg() throws Exception {
        sendSongInMsg();
    }
    @After
    public void afterVk() throws Exception {
        closeVk();

    }

}
