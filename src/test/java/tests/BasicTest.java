package tests;

import data.Data;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BasicTest {

    protected WebDriver driver;
    protected LogInPage logInPage;
    protected ProjectPage projectPage;
    protected InProjectPage inProjectPage;
    protected CreateProjectPage createProjectPage;
    protected NewComponentPage newComponentPage;
    protected InComponentPage inComponentPage;
    public String URL="https://dev.integrivideo.com/";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        this.logInPage=new LogInPage(driver);
        this.projectPage=new ProjectPage(driver);
        this.inProjectPage=new InProjectPage(driver);
        this.createProjectPage=new CreateProjectPage(driver);
        this.newComponentPage=new NewComponentPage(driver);
        this.inComponentPage=new InComponentPage(driver);
        logInPage.LogIn(new Data().USER_EMAIL, new Data().USER_PASSWORD);
    }

    @After
    public void quit(){
        driver.quit();
    }
}
