package tests;

import data.Data;
import org.junit.Assert;
import org.testng.annotations.*;

public class ProjectTest extends BasicTest {

    @Test
    public void ProjectFieldTest(){

        String project_Name = new Data().PROJECT_NAME;
        String description = new Data().DESCRIPTION;
        String domen = new Data().DOMEN;
        String firstLettersOfProject;

        int beforeNumberOfProjects=projectPage.getSizeOfProjectList();

        projectPage
                .clickAddProject()
                .addProject(project_Name, description, domen);

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "numberOfProject"), beforeNumberOfProjects+1, projectPage.getSizeOfProjectList());

        if(project_Name.indexOf(" ")!=-1) {//TODO мб перенести в какой-то класс в utils?
            firstLettersOfProject = Character.toString(project_Name.charAt(0)) + Character.toString(project_Name.charAt(project_Name.indexOf(" ") + 1));
        }
        else firstLettersOfProject = Character.toString(project_Name.charAt(0));

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "letters"), projectPage.getLastProjectLetters(), firstLettersOfProject);



        projectPage.clickLastOfProject();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "project_Name"), project_Name, inProjectPage.getProjectName());//TODO как сделать читабельнее эта ебана цейво?
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "description"), description, inProjectPage.getDescription());
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
    public void AddComponentTest(){
        String component_Name=new Data().COMPONENT_NAME;

        projectPage
                .clickLastOfProject()
                .clickAddComponentButton()
                .addComponent("Single Video", component_Name)
                .clickLastComponent();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "ComponentType"), new Data().SINGLE_VIDEO_NAME, componentPage.getTypeComponent());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "ComponentName"), component_Name, componentPage.getComponentName());
    }

}
