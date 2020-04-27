package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.CreateProjectPage;
import pages.InProjectPage;
import pages.LogInPage;
import pages.ProjectPage;

public class CreateProjectPageTest extends BasicPageTest{
    //TODO пейджей уже не будет т.к все будут в бейз тесте обьявлены а с этого лкасса спокойно к ним обращаемся
    public CreateProjectPage CPP;
    public ProjectPage PP;
    public LogInPage LP; //loginPage
    public InProjectPage IPP;

    //TODO Все входныен тестовые данные в отдельный класс TestData
    public String project="project test";
    public String description="description test";
    public String domen="test.by";

    //TODO нахуя тут BEFORE? в бефоре метода в бейз тесте ты уже запустил браузер, настроил его и открыл проект. Все что надо выполнять перелд каждым тестом
    // это у тебя уже сам тест пошел
    @Before
    public void settings(){
        MP.clickLogIn().LogIn(regEmail, regPassword);
        PP.clickAddProject();
        CPP.addProject(project, description, domen);
        PP.clickLastOfProject();
    }

    //TODO метод выше должен бтыь в жэтом методе, класик структура теста выполнил действия провел асерт тест закончен.
    @Test
    public void ProjectFieldTest(){
        Assert.assertEquals(IPP.getProjectName(), project);
        Assert.assertEquals(IPP.getDescription(), description);
    }


}
