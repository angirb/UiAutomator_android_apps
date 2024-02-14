package com.tran.trapp.pageObjects;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

public class VkServicePage {
    protected UiDevice mDevice;

    public VkServicePage(UiDevice mDevice) {
        this.mDevice = mDevice;
    }

    public UiObject servicesPage() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/navigation_bar_item_small_label_view").text("Сервисы"));
    }
    public UiObject likeButton() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/iv_likes"));
    }
    public UiObject friendsSectionBtn() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/title").text("Друзья"));
    }
    public UiObject AlbertFriendSection() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/title").text("Альберт Курнев"));
    }
    public UiObject addCommentBtn() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/comments_wrapper"));
    }
    public UiObject closeWindowBtn() {
        return mDevice.findObject(new UiSelector().className("android.widget.ImageButton").descriptionContains("Закрыть экран"));
    }
    public UiObject likeIsClicked() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/footer_reaction"));
    }
    public UiObject likeReactionExistInsideComment() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/reactions_preview_stack"));
    }
    public UiObject likeReactionNotExistInsideComment() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/empty_reactions_text_view"));
    }
    public UiObject commentBar() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/writebar_edit").text("Комментарий"));
    }
    public UiObject commentHasBeenSent() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/text"));
    }
    public UiObject commentCreated() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/text"));
    }
    public UiObject deleteCommentBtn() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/action_text").textContains("Удалить комментарий"));
    }
    public UiObject commentDeleted() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/deleted_comment_title").text("Комментарий удалён"));
    }
    public UiObject removeLike() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/likes").descriptionContains("Убрать реакцию «Нравится»"));
    }
    public UiObject btnLikeNotClicked() {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/likes").description("Нравится"));
    }
    public UiObject likesBtnTrue()  {
        return mDevice.findObject(new UiSelector().resourceId("com.vkontakte.android:id/tv_likes").text("1"));
    }

    public UiScrollable scrollableToLike() throws UiObjectNotFoundException {
        UiScrollable uiScrollable = new UiScrollable(new UiSelector().scrollable(true).instance(0));
        uiScrollable.setAsVerticalList();
        uiScrollable.scrollIntoView(likeButton());

        return uiScrollable;
    }

}
