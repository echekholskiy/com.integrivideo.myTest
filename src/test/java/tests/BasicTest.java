package tests;

import Data.Data;
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
    protected EditProjectPage editProjectPage;
    protected CreateProjectPage createProjectPage;
    protected NewComponentPage newComponentPage;
    protected InComponentPage inComponentPage;
    protected Data data;

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(data.URL);
        this.logInPage=new LogInPage(driver);
        this.projectPage=new ProjectPage(driver);
        this.inProjectPage=new InProjectPage(driver);
        this.editProjectPage=new EditProjectPage(driver);
        this.createProjectPage=new CreateProjectPage(driver);
        this.newComponentPage=new NewComponentPage(driver);
        this.inComponentPage=new InComponentPage(driver);
        this.data=new Data();
        logInPage.LogIn(data.USER_EMAIL, data.USER_PASSWORD);
    }

    @After
    public void quit(){
        driver.quit();
    }
}
