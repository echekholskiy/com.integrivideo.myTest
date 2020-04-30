package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    protected NewComponentPage newComponentPage;
    protected InComponentPage inComponentPage;
    private String url="https://dev.integrivideo.com/";
    private String regEmail="integriuser2@mailinator.com";
    private String regPassword="integripassword";


    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        this.logInPage=new LogInPage(driver);
        this.projectPage=new ProjectPage(driver);
        this.inProjectPage=new InProjectPage(driver);
        this.editProjectPage=new EditProjectPage(driver);
        this.createProjectPage=new CreateProjectPage(driver);
        this.newComponentPage=new NewComponentPage(driver);
        this.inComponentPage=new InComponentPage(driver);
        logInPage.LogIn(regEmail, regPassword);
    }

    @After
    public void quit(){
        driver.quit();
    }
}
