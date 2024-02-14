package com.tran.trapp.vkTest;
import static com.tran.trapp.steps.FriendPageSteps.clickLikeBtnSteps;
import static com.tran.trapp.steps.FriendPageSteps.deleteComment;
import static com.tran.trapp.steps.FriendPageSteps.writeCommentFriendPage;

import androidx.test.uiautomator.UiObjectNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import io.qameta.allure.Description;


@RunWith(JUnit4.class)
public class FriendPageTest extends VkSetUp {

    @Before
    public void beforeVk() {
        openVk();
    }

    @Test
    @Description("Go to friend page list and click like button on a first post")
    public void clickLikeBtn() throws Exception {
        clickLikeBtnSteps();
    }

    @Test
    @Description("Go to friend page and write a comment under his post. Search created post")
    public void writeCommentTest() throws Exception {
        writeCommentFriendPage();
    }
    @Test
    public void deleteCommentTest() throws InterruptedException, UiObjectNotFoundException {
        deleteComment();
    }
    @After
    public void afterVk() throws Exception {
        closeVk();
    }
}
