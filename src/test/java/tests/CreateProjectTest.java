package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateProjectTest extends BasicTest {
    //TODO Все входныен тестовые данные в отдельный класс TestData
    private String project="project test";
    private String description="description test";
    private String domen="test.by";  //TODO javafacker библиотека


    //TODO нахуя тут BEFORE? в бефоре метода в бейз тесте ты уже запустил браузер, настроил его и открыл проект. Все что надо выполнять перелд каждым тестом
    // это у тебя уже сам тест пошел
    @Before
    public void settings(){
        //TODO перенести авторизацию в basic
        projectPage.clickAddProject();
        createProjectPage.addProject(project, description, domen);
        projectPage.clickLastOfProject();
    }

    //TODO метод выше должен бтыь в жэтом методе, класик структура теста выполнил действия провел асерт тест закончен.
    @Test
    public void ProjectFieldTest(){
        Assert.assertEquals(inProjectPage.getProjectName(), project);
        Assert.assertEquals(inProjectPage.getDescription(), description);
    }


}
