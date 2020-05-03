package driver;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.PropertyReader;

public class FirefoxDriverManager extends DriverManager {

    public void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver", PropertyReader.getInstance().get("geckodriver"));
        this.driver = new FirefoxDriver(options);
    }
}