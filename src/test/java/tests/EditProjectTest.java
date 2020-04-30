package tests;

import data.Data;
import org.junit.Assert;
import org.junit.Test;

public class EditProjectTest extends BasicTest {
    private String project_Name=new Data().PROJECT_NAME;
    private String description=new Data().DESCRIPTION;
    private String domen=new Data().DOMEN;

    @Test
    public void ProjectFieldTest(){
        projectPage
                .clickAddProject()
                .addProject(project_Name, description, domen)
                .clickLastOfProject();
        Assert.assertEquals(inProjectPage.getProjectName(), project_Name);
        Assert.assertEquals(inProjectPage.getDescription(), description);
    }

    @Test
    public void EditProjectTest(){
        projectPage
                .clickLastOfProject()
                .clickEditButton()
                .editProject(project_Name, description, domen)
                .clickLastOfProject();
        Assert.assertEquals(inProjectPage.getProjectName(), project_Name);
        Assert.assertEquals(inProjectPage.getDescription(), description);
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
}
