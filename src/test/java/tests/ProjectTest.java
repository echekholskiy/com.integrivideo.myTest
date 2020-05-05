package tests;

import data.Data;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProjectTest extends BasicTest {

    @Test
    public void ProjectFieldTest(){

        String project_Name = new Data().PROJECT_NAME;
        String description = new Data().DESCRIPTION;
        String domen = new Data().DOMEN;

        int beforeNumberOfProjects=projectPage.getSizeOfProjectList();

        projectPage
                .clickAddProject()
                .addProject(project_Name, description, domen);

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "numberOfProject"), beforeNumberOfProjects+1, projectPage.getSizeOfProjectList());

        projectPage.clickLastOfProject();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "project_Name"), project_Name, inProjectPage.getProjectName());//TODO как сделать читабельнее эта ебана цейво?
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "description"), description, inProjectPage.getDescription());//TODO добавить проверку буква проекта
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
        String component_Name=new Data().COMPONENT_NAME;

        projectPage
                .clickLastOfProject()
                .clickAddComponentButton()
                .addVideoChat(component_Name)
                .clickLastComponent();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "VideoChatType"), new Data().VIDEO_CHAT_NAME, componentPage.getTypeComponent());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "VideoChatName"), component_Name, componentPage.getComponentName());//TODO name сделать проще
    }

    @Test
    public void AddMultiVideoPlayerTest() {
        String component_Name=new Data().COMPONENT_NAME;

        projectPage
                .clickLastOfProject()
                .clickAddComponentButton()
                .addMultiVideoPlayer(component_Name)//TODO сделать дата провайдер
                .clickLastComponent();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "MultiVideoPlayerType"), new Data().MULTI_VIDEO_PLAYER_NAME, componentPage.getTypeComponent());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "MultiVideoPlayerName"), component_Name, componentPage.getComponentName());
    }

    @Test
    public void AddMultiPartyVideoTest() {
        String component_Name=new Data().COMPONENT_NAME;

        projectPage
                .clickLastOfProject()
                .clickAddComponentButton()
                .addMultiPartyVideo(component_Name)
                .clickLastComponent();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "MultiPartyVideoType"), new Data().MULTIPARTY_VIDEO_NAME, componentPage.getTypeComponent());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "MultiPartyVideoName"), component_Name, componentPage.getComponentName());
    }

    @Test
    public void AddSingleVideoTest(){
        String component_Name=new Data().COMPONENT_NAME;

        projectPage
                .clickLastOfProject()
                .clickAddComponentButton()
                .addSingleVideo(component_Name)
                .clickLastComponent();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "SingleVideoType"), new Data().SINGLE_VIDEO_NAME, componentPage.getTypeComponent());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "SingleVideoName"), component_Name, componentPage.getComponentName());
    }
}
