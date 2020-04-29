package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BasicTest {

    protected WebDriver driver;
    protected LogInPage logInPage;
    protected ProjectPage projectPage;
    protected InProjectPage inProjectPage;
    protected EditProjectPage editProjectPage;
    protected CreateProjectPage createProjectPage;
    private String url="https://dev.integrivideo.com/";
    private String regEmail="integriuser2@mailinator.com";
    private String regPassword="integripassword";


    @Before
    public void setUP(){
        //TODO го в хроме плз, потом с фф
        System.setProperty("webdriver.gecko.driver", "src\\drivers\\geckodriver.exe");
        driver=new FirefoxDriver();
        // TODO а че имплисити такой жирный 10 сек, у тебя перед каждым действием проходит? 1-2 секи достаточно
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        this.logInPage=new LogInPage(driver);
        this.projectPage=new ProjectPage(driver);
        this.inProjectPage=new InProjectPage(driver);
        this.editProjectPage=new EditProjectPage(driver);
        this.createProjectPage=new CreateProjectPage(driver);
        logInPage.LogIn(regEmail, regPassword);
    }

    @After
    public void quit(){
        driver.quit();
    }
}
