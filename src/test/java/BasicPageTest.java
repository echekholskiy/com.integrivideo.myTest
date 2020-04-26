import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BasicPageTest {
    public WebDriver driver;
    public MainPage MP;
    public String url="https://dev.integrivideo.com/";

    @Before
    public void setUP(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\nazhivka.by\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver=new FirefoxDriver();
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
