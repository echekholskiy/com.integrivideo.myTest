package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

//TODO название классов с тестами BaseTest, ProjectTest итд. Попутал с классами Step-ов что я показывал
public class BasicPageTest {
    //TODO драйвер модификатор доступа protected достаточно по идее
    protected WebDriver driver;
    //TODO сдесь в BaseTest сразу инициализировать все пейджы, т.к твои тесты наследуются от него
    // соответсвенно имеют ко всем пейджам доступ -> обьявить пейджы как поля класса, и в метода Before создать для них обьекты и передать туда драйвер
    //TODO название пейджы mainPage с маленькой буквы - переменные именуем с маленькой буквы или _ но не цифры. Большой буквами тольок константы
    // модификатор доступа protected достаточно, чтобы ток наследники могли пользоваться а не все
    protected LogInPage LP;
    protected ProjectPage PP;
    protected InProjectPage IPP;
    protected EditProjectPage EPP;
    protected CreateProjectPage CPP;

    //TODO когда перенесу авторизацию в бэйсик-поставить private
    protected String url="https://dev.integrivideo.com/";
    protected String regEmail="integriuser2@mailinator.com";
    protected String regPassword="integripassword";


    @Before
    public void setUP(){
        //TODO драйвер разместить в структуре проекта и залить в гит, я выкачал твой проект а стартануть не могу т.к драйвера у меня там нету
        //TODO го в хроме плз, потом с фф
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\nazhivka.by\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver=new FirefoxDriver();
        // TODO а че имплисити такой жирный 10 сек, у тебя перед каждым действием проходит? 1-2 секи достаточно
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        this.LP=new LogInPage(driver);
        this.PP=new ProjectPage(driver);
        this.IPP=new InProjectPage(driver);
        this.EPP=new EditProjectPage(driver);
        this.CPP=new CreateProjectPage(driver);
    }

    @After
    public void quit(){
        driver.quit();
    }
}
