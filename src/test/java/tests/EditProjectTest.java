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
    private String videoChatName="Video Chat";
    private String multiVideoPleerName="Multi-device Video Player";
    private String multiPartyVideoName="Multiparty Video";
    private String singleVideoName="Single Video";

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
        projectPage
                .clickLastOfProject()
                .clickAddComponentButton()
                .addVideoChat(videoChatName)
                .clickLastComponent();
        Assert.assertEquals(inComponentPage.getTypeComponent(), "Video Chat");
        Assert.assertEquals(inComponentPage.getComponentName(), "Test "+videoChatName);
        inComponentPage
                .clickUpdateButton()
                .clickAddComponentButton()
                .addMultiVideoPlayer(multiVideoPleerName)
                .clickLastComponent();
        Assert.assertEquals(inComponentPage.getTypeComponent(), "Multi-device Video Player");
        Assert.assertEquals(inComponentPage.getComponentName(), "Test "+multiVideoPleerName);
        inComponentPage
                .clickUpdateButton()
                .clickAddComponentButton()
                .addMultiPartyVideo(multiPartyVideoName)
                .clickLastComponent();
        Assert.assertEquals(inComponentPage.getTypeComponent(), "Multiparty Video");
        Assert.assertEquals(inComponentPage.getComponentName(), "Test "+multiPartyVideoName);
        inComponentPage
                .clickUpdateButton()
                .clickAddComponentButton()
                .addSingleVideo(singleVideoName)
                .clickLastComponent();
        Assert.assertEquals(inComponentPage.getTypeComponent(), "Single Video");
        Assert.assertEquals(inComponentPage.getComponentName(), "Test "+singleVideoName);
    }

}
