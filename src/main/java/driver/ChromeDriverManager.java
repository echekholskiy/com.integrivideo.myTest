package driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.PropertyReader;

public class ChromeDriverManager extends DriverManager {

    public void createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", PropertyReader.getInstance().get("chromedriver"));
        this.driver = new ChromeDriver(options);
    }
}