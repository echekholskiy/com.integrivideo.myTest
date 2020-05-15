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
                .isLoaded();

        createProjectPage.addProject(project_Name, description, domen);

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "numberOfProject"), beforeNumberOfProjects+1, projectPage.getSizeOfProjectList());

        if(project_Name.indexOf(" ")!=-1) {
            firstLettersOfProject = Character.toString(project_Name.charAt(0)) + Character.toString(project_Name.charAt(project_Name.indexOf(" ") + 1));//TODO перенести в page(при проверке пробела использовать contains)
        }
        else firstLettersOfProject = Character.toString(project_Name.charAt(0));

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "letters"), projectPage.getLastProjectLetters(), firstLettersOfProject);

        projectPage
                .clickLastOfProject()
                .isLoaded();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "project_Name"), project_Name, inProjectPage.getProjectName());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "description"), description, inProjectPage.getDescription());
    }

    @Test
    public void EditProjectTest(){

        String project_Name = new Data().PROJECT_NAME;
        String description = new Data().DESCRIPTION;
        String domen = new Data().DOMEN;

        projectPage
                .clickLastOfProject()
                .isLoaded();

        inProjectPage
                .clickEditButton()
                .isLoaded();

        createProjectPage
                .editProject(project_Name, description, domen)
                .clickLastOfProject()
                .isLoaded();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "project_Name"), project_Name, inProjectPage.getProjectName());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "description"), description, inProjectPage.getDescription());
    }

    @Test(dataProvider = "components")
    public void AddComponentTest(String Component, String ComponentName){

        projectPage
                .clickLastOfProject().isLoaded();

        inProjectPage
                .clickAddComponentButton()
                .isLoaded();

        componentPage.addComponent(Component, ComponentName)
                .clickLastComponent();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "ComponentType"), Component, componentPage.getTypeComponent());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "ComponentName"), ComponentName, componentPage.getComponentName());
    }

    @DataProvider(name="components")
    public Object[][] getComponentName(){
        Object[][] componentsmass = new Object[4][2];

        componentsmass[0][0] = new Data().VIDEO_CHAT_NAME;
        componentsmass[0][1] = new Data().COMPONENT_NAME;

        componentsmass[1][0] = new Data().MULTI_VIDEO_PLAYER_NAME;
        componentsmass[1][1] = new Data().COMPONENT_NAME;

        componentsmass[2][0] = new Data().MULTIPARTY_VIDEO_NAME;
        componentsmass[2][1] = new Data().COMPONENT_NAME;

        componentsmass[3][0] = new Data().SINGLE_VIDEO_NAME;
        componentsmass[3][1] = new Data().COMPONENT_NAME;

        return componentsmass;
    }

}
