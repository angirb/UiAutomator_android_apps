package com.tran.trapp.steps;

import androidx.test.uiautomator.UiObjectNotFoundException;
import com.tran.trapp.BaseClass;
import com.tran.trapp.pageObjects.VkMessagePage;
import com.tran.trapp.pageObjects.VkPageObjects;
import com.tran.trapp.pageObjects.VkServicePage;
import org.junit.Assert;



public class FriendPageSteps extends BaseClass {

    public static void openFriendPage() throws UiObjectNotFoundException {
        vkPageObjects = new VkPageObjects(mDevice);
        vkServicePage = new VkServicePage(mDevice);
        vkServicePage.servicesPage().click();
        vkServicePage.friendsSectionBtn().clickAndWaitForNewWindow();
        vkServicePage.AlbertFriendSection().click();
    }

    public static void goBackToMainPage() throws UiObjectNotFoundException {
        while (!vkServicePage.closeWindowBtn().exists()) {
            mDevice.pressBack();
        }
        vkServicePage.closeWindowBtn().click();
        vkPageObjects.mainPageBtn().click();
    }

    public static void clickLikeBtnSteps() throws UiObjectNotFoundException, InterruptedException {
        vkPageObjects = new VkPageObjects(mDevice);
        vkServicePage = new VkServicePage(mDevice);
        openFriendPage();
        Thread.sleep(2000);
        vkServicePage.scrollableToLike();
        vkServicePage.addCommentBtn().click();
        if (!vkServicePage.likeButton().exists()) {
            vkServicePage.addCommentBtn().click();
            Assert.assertTrue(vkServicePage.likeReactionExistInsideComment().exists());
        }
        vkServicePage.likeButton().click();
        Thread.sleep(3000);
        Assert.assertTrue(vkServicePage.likeReactionExistInsideComment().exists());
        vkServicePage.removeLike().click();
        Thread.sleep(2000);
    }


    public static void writeCommentFriendPage() throws UiObjectNotFoundException, InterruptedException {
        vkPageObjects = new VkPageObjects(mDevice);
        vkMessagePage = new VkMessagePage(mDevice);
        vkServicePage = new VkServicePage(mDevice);
        openFriendPage();
        String expectedMsg = "testMessageComment";
        vkServicePage.scrollableToLike();
        vkServicePage.addCommentBtn().click();
        vkServicePage.commentBar().click();
        vkServicePage.commentBar().setText(expectedMsg);
        vkMessagePage.sendMsgButton().click();
        Thread.sleep(1000);
        Assert.assertEquals(expectedMsg, vkServicePage.commentHasBeenSent().getText());
    }

    public static void deleteComment() throws InterruptedException, UiObjectNotFoundException {
        String expectedDeletedComment = "Комментарий удалён";
        writeCommentFriendPage();
        vkServicePage.commentCreated().click();
        vkServicePage.deleteCommentBtn().click();
        Assert.assertEquals(expectedDeletedComment, vkServicePage.commentDeleted().getText());
    }
}
