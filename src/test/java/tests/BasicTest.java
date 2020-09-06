package tests;

import data.Data;
import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

public class BasicTest {

    protected WebDriver driver;
    private DriverManager driverManager;

    protected LogInPage logInPage;
    protected ProjectPage projectPage;
    protected InProjectPage inProjectPage;
    protected CreateProjectPage createProjectPage;
    protected ComponentPage componentPage;
    protected BillingPage billingPage;
    protected AddCardPage addCardPage;
    protected MainPage mainPage;
    protected ChatPage chatPage;

    @BeforeMethod
    public void setUP(){
        driverManager = DriverManagerFactory.getDriverManager(DriverType.FIREFOX);
        driver = driverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(PropertyReader.getInstance().get("url"));

        this.logInPage = new LogInPage(driver);
        this.projectPage = new ProjectPage(driver);
        this.inProjectPage = new InProjectPage(driver);
        this.createProjectPage = new CreateProjectPage(driver);
        this.componentPage = new ComponentPage(driver);
        this.billingPage = new BillingPage(driver);
        this.addCardPage = new AddCardPage(driver);
        this.mainPage = new MainPage(driver);
        this.chatPage = new ChatPage(driver);

        logInPage
                .clickLogIn()
                .isLoaded();

        logInPage
                .LogIn(new Data().USER_EMAIL, new Data().USER_PASSWORD)
                .isLoaded();
    }

    @AfterMethod
    public void quit(){
        driverManager.quitWebDriver();
    }
}
