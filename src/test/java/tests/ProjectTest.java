package tests;

import data.Data;
import org.junit.Assert;
import org.junit.Test;

public class ProjectTest extends BasicTest {

    @Test
    public void ProjectFieldTest(){

        String project_Name = new Data().PROJECT_NAME;
        String description = new Data().DESCRIPTION;
        String domen = new Data().DOMEN;

        projectPage
                .clickAddProject()
                .addProject(project_Name, description, domen)
                .clickLastOfProject();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "project_Name"), project_Name, inProjectPage.getProjectName());//TODO как сделать читабельнее эта ебана цейво?
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "description"), description, inProjectPage.getDescription());//TODO добавить проверку кол-во проектов+буква проекта
    }

    @Test
    public void EditProjectTest(){

        String project_Name = new Data().PROJECT_NAME;
        String description = new Data().DESCRIPTION;
        String domen = new Data().DOMEN;

        projectPage
                .clickLastOfProject()
                .clickEditButton()
                .editProject(project_Name, description, domen)
                .clickLastOfProject();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "project_Name"), project_Name, inProjectPage.getProjectName());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "description"), description, inProjectPage.getDescription());
    }

    @Test
    public void AddVideoChatTest() {
        projectPage
                .clickLastOfProject()
                .clickAddComponentButton()
                .addVideoChat(new Data().VIDEO_CHAT_NAME)
                .clickLastComponent();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "VideoChatType"), new Data().VIDEO_CHAT_NAME, componentPage.getTypeComponent());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "VideoChatName"), "Test " + new Data().VIDEO_CHAT_NAME, componentPage.getComponentName());//TODO name сделать проще
    }

    @Test
    public void AddMultiVideoPlayerTest() {
        projectPage
                .clickLastOfProject()
                .clickAddComponentButton()
                .addMultiVideoPlayer(new Data().MULTI_VIDEO_PLAYER_NAME)//TODO сделать дата провайдер
                .clickLastComponent();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "MultiVideoPlayerType"), new Data().MULTI_VIDEO_PLAYER_NAME, componentPage.getTypeComponent());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "MultiVideoPlayerName"), "Test " + new Data().MULTI_VIDEO_PLAYER_NAME, componentPage.getComponentName());
    }

    @Test
    public void AddMultiPartyVideoTest() {
        projectPage
                .clickLastOfProject()
                .clickAddComponentButton()
                .addMultiPartyVideo(new Data().MULTIPARTY_VIDEO_NAME)
                .clickLastComponent();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "MultiPartyVideoType"), new Data().MULTIPARTY_VIDEO_NAME, componentPage.getTypeComponent());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "MultiPartyVideoName"), "Test " + new Data().MULTIPARTY_VIDEO_NAME, componentPage.getComponentName());
    }

    @Test
    public void AddSingleVideoTest(){
        projectPage
                .clickLastOfProject()
                .clickAddComponentButton()
                .addSingleVideo(new Data().SINGLE_VIDEO_NAME)
                .clickLastComponent();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "SingleVideoType"), new Data().SINGLE_VIDEO_NAME, componentPage.getTypeComponent());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "SingleVideoName"), "Test "+new Data().SINGLE_VIDEO_NAME, componentPage.getComponentName());
    }
}
