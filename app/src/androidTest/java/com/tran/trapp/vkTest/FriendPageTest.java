package com.tran.trapp.vkTest;
import static com.tran.trapp.steps.FriendPageSteps.clickLikeBtnSteps;
import static com.tran.trapp.steps.FriendPageSteps.deleteComment;
import static com.tran.trapp.steps.FriendPageSteps.writeCommentFriendPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

import androidx.test.uiautomator.UiObjectNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;


@RunWith(JUnit4.class)
public class FriendPageTest extends VkSetUp {



    @Before
    public void beforeVk() {
        openVk();
    }

    @Test
    @DisplayName("Taping like button")
    @Description("Go to friend page list and click like button on a first post")
    @Severity(CRITICAL)
    @Owner("Ang")
    public void clickLikeBtn() throws Exception {
        clickLikeBtnSteps();
    }

    @Test
    @DisplayName("Writing a comment")
    @Description("Go to friend page and write a comment under his post. Search created post")
    @Severity(CRITICAL)
    @Owner("Ang")
    public void writeCommentTest() throws Exception {
        writeCommentFriendPage();
    }
    @Test
    @DisplayName("Deleting a comment")
    @Description("Go to friend page, write a comment under his post and delete it")
    @Severity(CRITICAL)
    @Owner("Ang")
    public void deleteCommentTest() throws InterruptedException, UiObjectNotFoundException {
        deleteComment();
    }
    @After
    public void afterVk() throws Exception {
        closeVk();
    }
}
