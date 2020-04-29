package tests;

import org.junit.Assert;
import org.junit.Test;

public class CreateProjectTest extends BasicTest {
    //TODO Все входныен тестовые данные в отдельный класс TestData
    private String project="project test";
    private String description="description test";
    private String domen="test.by";  //TODO javafacker библиотека

    @Test
    public void ProjectFieldTest(){
        projectPage.clickAddProject();
        createProjectPage.addProject(project, description, domen);
        projectPage.clickLastOfProject();
        Assert.assertEquals(inProjectPage.getProjectName(), project);
        Assert.assertEquals(inProjectPage.getDescription(), description);
    }


}
