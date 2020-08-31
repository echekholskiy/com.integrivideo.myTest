package tests;

import data.Data;
import org.junit.Assert;
import org.testng.annotations.Test;

public class ChatTest extends BasicTest {
    String chatName = new Data().CHAT_NAME;
    String chatEmail = new Data().CHAT_EMAIL;
    String chatPicture = new Data().CHAT_PICTURE;


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
}
