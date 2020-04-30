package tests;

import org.junit.Assert;
import org.junit.Test;

public class EditProjectTest extends BasicTest {

    @Test
    public void ProjectFieldTest(){
        projectPage
                .clickAddProject()
                .addProject(data.PROJECT_NAME, data.DESCRIPTION, data.DOMEN)
                .clickLastOfProject();
        Assert.assertEquals(inProjectPage.getProjectName(), data.PROJECT_NAME);
        Assert.assertEquals(inProjectPage.getDescription(), data.DESCRIPTION);
    }

    @Test
    public void EditProjectTest(){
        projectPage
                .clickLastOfProject()
                .clickEditButton()
                .editProject(data.EDIT_PROJECT_NAME, data.EDIT_DESCRIPTION, data.EDIT_DOMEN)
                .clickLastOfProject();
        Assert.assertEquals(inProjectPage.getProjectName(), data.EDIT_PROJECT_NAME);
        Assert.assertEquals(inProjectPage.getDescription(), data.EDIT_DESCRIPTION);
    }

    @Test
    public void AddComponentsTest(){
        projectPage
                .clickLastOfProject()
                .clickAddComponentButton()
                .addVideoChat(data.VIDEO_CHAT_NAME)
                .clickLastComponent();
        Assert.assertEquals(inComponentPage.getTypeComponent(), data.VIDEO_CHAT_NAME);
        Assert.assertEquals(inComponentPage.getComponentName(), "Test "+data.VIDEO_CHAT_NAME);
        inComponentPage
                .clickUpdateButton()
                .clickAddComponentButton()
                .addMultiVideoPlayer(data.MULTI_VIDEO_PLAYER_NAME)
                .clickLastComponent();
        Assert.assertEquals(inComponentPage.getTypeComponent(), data.MULTI_VIDEO_PLAYER_NAME);
        Assert.assertEquals(inComponentPage.getComponentName(), "Test "+data.MULTI_VIDEO_PLAYER_NAME);
        inComponentPage
                .clickUpdateButton()
                .clickAddComponentButton()
                .addMultiPartyVideo(data.MULTIPARTY_VIDEO_NAME)
                .clickLastComponent();
        Assert.assertEquals(inComponentPage.getTypeComponent(), data.MULTIPARTY_VIDEO_NAME);
        Assert.assertEquals(inComponentPage.getComponentName(), "Test "+data.MULTIPARTY_VIDEO_NAME);
        inComponentPage
                .clickUpdateButton()
                .clickAddComponentButton()
                .addSingleVideo(data.SINGLE_VIDEO_NAME)
                .clickLastComponent();
        Assert.assertEquals(inComponentPage.getTypeComponent(), data.SINGLE_VIDEO_NAME);
        Assert.assertEquals(inComponentPage.getComponentName(), "Test "+data.SINGLE_VIDEO_NAME);
    }

    @Test
    public void test(){
        System.out.println();
    }
}
