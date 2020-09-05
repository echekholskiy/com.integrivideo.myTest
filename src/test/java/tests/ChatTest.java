package tests;

import data.Data;
import org.junit.Assert;
import org.testng.annotations.Test;

public class ChatTest extends BasicTest {

    String chatName = new Data().CHAT_NAME;
    String chatEmail = new Data().CHAT_EMAIL;
    String chatPicture = new Data().CHAT_PICTURE;
    String messageText = new Data().MESSAGE_TEXT;
    String editedText = new Data().EDIT_MESSAGE_TEXT;


    @Test
    public void typeSettingsTest(){

        projectPage
                .clickLogo()
                .isLoaded();

        mainPage
                .clickChatTryItOutLoc()
                .isLoaded();

        chatPage
                .typeAllSettings(chatName, chatEmail, chatPicture)
                .settingsClick();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "chatName"), chatName, chatPage.getUserName());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "chatEmail"), chatEmail, chatPage.getUserEmail());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "chatPicture"), chatPicture, chatPage.getPictureAdress());
    }

    @Test
    public void anonymousNameTest(){

        projectPage
                .clickLogo()
                .isLoaded();

        mainPage
                .clickChatTryItOutLoc()
                .isLoaded();

        chatPage
                .settingsClick()
                .clearUserName()
                .clickSaveButton();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "chatName"), chatPage.getEstablishedName(), new Data().CHAT_ANONYMOUS_NAME);
    }

    @Test
    public void sendMessageTest(){

        projectPage
                .clickLogo()
                .isLoaded();

        mainPage
                .clickChatTryItOutLoc()
                .isLoaded();

        chatPage
                .sendMessage(messageText);

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "chatName"), chatPage.getTextMessage(), messageText);
    }

    @Test
    public void deleteMessageTest(){

        projectPage
                .clickLogo()
                .isLoaded();

        mainPage
                .clickChatTryItOutLoc()
                .isLoaded();

        chatPage
                .sendMessage(messageText)
                .deleteMessage();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "chatName"), chatPage.getTextMessage(), new Data().DELETE_MESSAGE_TEXT);
    }

    @Test
    public void editMessageText(){

        projectPage
                .clickLogo()
                .isLoaded();

        mainPage
                .clickChatTryItOutLoc()
                .isLoaded();

        chatPage
                .sendMessage(messageText)
                .editMessage(editedText);

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "editedLabel"), chatPage.getEditedLabelText(), new Data().EDITED_LABEL);
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "editedText"), chatPage.getTextMessage(), editedText);
    }

}
