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
    protected ComponentPage componentPage;
    protected BillingPage billingPage;
    protected AddCardPage addCardPage;
    private String URL="https://dev.integrivideo.com/";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        this.logInPage=new LogInPage(driver);
        this.projectPage=new ProjectPage(driver);
        this.inProjectPage=new InProjectPage(driver);
        this.createProjectPage=new CreateProjectPage(driver);
        this.componentPage =new ComponentPage(driver);
        this.billingPage=new BillingPage(driver);
        this.addCardPage=new AddCardPage(driver);
        logInPage.LogIn(new Data().USER_EMAIL, new Data().USER_PASSWORD);
    }

    //@After
    //public void quit(){
    //    driver.quit();
    //}
}
