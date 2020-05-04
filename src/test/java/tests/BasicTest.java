package tests;

import data.Data;
import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

public class BasicTest {

    private WebDriver driver;
    private DriverManager driverManager;

    protected LogInPage logInPage;
    protected ProjectPage projectPage;
    protected InProjectPage inProjectPage;
    protected CreateProjectPage createProjectPage;
    protected ComponentPage componentPage;
    protected BillingPage billingPage;
    protected AddCardPage addCardPage;

    @Before
    public void setUP(){
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver
                .manage()
                .timeouts()
                .implicitlyWait(2, TimeUnit.SECONDS);
        driver
                .manage()
                .window()
                .maximize();
        driver.get(PropertyReader.getInstance().get("url"));

        this.logInPage = new LogInPage(driver);
        this.projectPage = new ProjectPage(driver);
        this.inProjectPage = new InProjectPage(driver);
        this.createProjectPage = new CreateProjectPage(driver);
        this.componentPage = new ComponentPage(driver);
        this.billingPage = new BillingPage(driver);
        this.addCardPage = new AddCardPage(driver);

        logInPage.LogIn(new Data().USER_EMAIL, new Data().USER_PASSWORD);
    }

    @After
    public void quit(){
        driverManager.quitWebDriver();
    }
}
