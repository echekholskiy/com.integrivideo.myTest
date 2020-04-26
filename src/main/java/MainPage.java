import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By loginButton=By.xpath("//a[@class='btn']");

    public LogInPage clickLogIn(){
        driver.findElement(loginButton).click();
        return new LogInPage(driver);
    }

}
