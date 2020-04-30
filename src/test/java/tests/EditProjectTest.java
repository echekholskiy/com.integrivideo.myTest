package tests;

import data.Data;
import org.junit.Assert;
import org.junit.Test;

public class EditProjectTest extends BasicTest {

    @Test
    public void ProjectFieldTest(){
        projectPage
                .clickAddProject()
                .addProject(new Data().PROJECT_NAME, new Data().DESCRIPTION, new Data().DOMEN)
                .clickLastOfProject();
        Assert.assertEquals(inProjectPage.getProjectName(), new Data().PROJECT_NAME);
        Assert.assertEquals(inProjectPage.getDescription(), new Data().DESCRIPTION);
    }

    @Test
    public void EditProjectTest(){
        projectPage
                .clickLastOfProject()
                .clickEditButton()
                .editProject(new Data().EDIT_PROJECT_NAME, new Data().EDIT_DESCRIPTION, new Data().EDIT_DOMEN)
                .clickLastOfProject();
        Assert.assertEquals(inProjectPage.getProjectName(), new Data().EDIT_PROJECT_NAME);
        Assert.assertEquals(inProjectPage.getDescription(), new Data().EDIT_DESCRIPTION);
    }

    @Test
    public void AddComponentsTest(){
        projectPage
                .clickLastOfProject()
                .clickAddComponentButton()
                .addVideoChat(new Data().VIDEO_CHAT_NAME)
                .clickLastComponent();
        Assert.assertEquals(inComponentPage.getTypeComponent(), new Data().VIDEO_CHAT_NAME);
        Assert.assertEquals(inComponentPage.getComponentName(), "Test "+new Data().VIDEO_CHAT_NAME);
        inComponentPage
                .clickUpdateButton()
                .clickAddComponentButton()
                .addMultiVideoPlayer(new Data().MULTI_VIDEO_PLAYER_NAME)
                .clickLastComponent();
        Assert.assertEquals(inComponentPage.getTypeComponent(), new Data().MULTI_VIDEO_PLAYER_NAME);
        Assert.assertEquals(inComponentPage.getComponentName(), "Test "+new Data().MULTI_VIDEO_PLAYER_NAME);
        inComponentPage
                .clickUpdateButton()
                .clickAddComponentButton()
                .addMultiPartyVideo(new Data().MULTIPARTY_VIDEO_NAME)
                .clickLastComponent();
        Assert.assertEquals(inComponentPage.getTypeComponent(), new Data().MULTIPARTY_VIDEO_NAME);
        Assert.assertEquals(inComponentPage.getComponentName(), "Test "+new Data().MULTIPARTY_VIDEO_NAME);
        inComponentPage
                .clickUpdateButton()
                .clickAddComponentButton()
                .addSingleVideo(new Data().SINGLE_VIDEO_NAME)
                .clickLastComponent();
        Assert.assertEquals(inComponentPage.getTypeComponent(), new Data().SINGLE_VIDEO_NAME);
        Assert.assertEquals(inComponentPage.getComponentName(), "Test "+new Data().SINGLE_VIDEO_NAME);
    }

    @Test
    public void test(){
        System.out.println();
    }
}
