package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

//TODO название классов с тестами BaseTest, ProjectTest итд. Попутал с классами Step-ов что я показывал
public class BasicPageTest {

    //TODO драйвер модификатор доступа protected достаточно по идее
    public WebDriver driver;

    //TODO сдесь в BaseTest сразу инициализировать все пейджы, т.к твои тесты наследуются от него
    // соответсвенно имеют ко всем пейджам доступ -> обьявить пейджы как поля класса, и в метода Before создать для них обьекты и передать туда драйвер


    //TODO название пейджы mainPage с маленькой буквы - переменные именуем с маленькой буквы или _ но не цифры. Большой буквами тольок константы
    // модификатор доступа protected достаточно, чтобы ток наследники могли пользоваться а не все
    public MainPage MP;

    //TODO private тут можно
    public String url="https://dev.integrivideo.com/";
    public String regEmail="integriuser2@mailinator.com";
    public String regPassword="integripassword";


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
        MP=new MainPage(driver);
    }


    @After
    public void quit(){
        driver.quit();
    }
}
