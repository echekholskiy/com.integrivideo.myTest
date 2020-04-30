package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.NewComponentPage;

public class EditProjectTest extends BasicTest {
    //TODO Все входныен тестовые данные в отдельный класс TestData
    private String project="project test";
    private String description="description test";
    private String domen="test.by";  //TODO javafacker библиотека
    private String PN="project1 name";
    private String DES="test1 description";//TODO перенести в data
    private String DOM="test1.by";
    private String videoChatName="VideoChat";
    private String multiVideoPleerName="MultiVideoPleer";
    private String multiPartyVideoName="MultiPartyVideo";
    private String singleVideoName="SingleVideo";

    @Test
    public void ProjectFieldTest(){
        projectPage.clickAddProject();
        createProjectPage.addProject(project, description, domen);
        projectPage.clickLastOfProject();
        Assert.assertEquals(inProjectPage.getProjectName(), project);
        Assert.assertEquals(inProjectPage.getDescription(), description);
    }

    @Test
    public void EditProjectTest(){
        projectPage.clickLastOfProject();
        inProjectPage.clickEditButton();
        editProjectPage.editProject(PN, DES, DOM);
        projectPage.clickLastOfProject();
        Assert.assertEquals(inProjectPage.getProjectName(), PN);
        Assert.assertEquals(inProjectPage.getDescription(), DES);
    }

    @Test
    public void AddComponentsTest(){
        projectPage.clickLastOfProject();
        inProjectPage.clickAddComponentButton();
        newComponentPage
                .addVideoChat(videoChatName)
                .clickAddComponentButton()
                .addMultiPartyVideo(multiPartyVideoName)
                .clickAddComponentButton()
                .addMultiVideoPleer(multiVideoPleerName)
                .clickAddComponentButton()
                .addSingleVideo(singleVideoName)
                .clickAddComponentButton();

    }
    @Test
    public void test(){
        projectPage.clickLastOfProject();
        inProjectPage.clickAddComponentButton();
        newComponentPage.addVideoChat(videoChatName);
        inProjectPage.clickLastComponent();
        Assert.assertEquals(inComponentPage.getTypeComponent(), "Video Chat");
        Assert.assertEquals(inComponentPage.getComponentName(), "Test"+videoChatName);
    }

}
