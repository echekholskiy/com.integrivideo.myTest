package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.FileAssert.fail;

public class LogInPage extends BasicPage{
    private WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginLoc = By.xpath("//a[@class='btn']");
    private By emailInputLoc = By.xpath("//input[@type='email']");
    private By passwordInputLoc = By.xpath("//input[@type='password']");
    private By loginButtonLoc = By.xpath("//button[@class='btn btn-primary']");

    private By openElementLoc=By.xpath("//div[text()='Please Log in to continue']");

    public void load(){
        driver.get("https://dev.integrivideo.com/login");
    }

    public void isLoaded() throws Error{
        try {
            presenceOfElementLocated(driver, openElementLoc, 5);
        } catch (TimeoutException e) {
            fail("Cannot locate openElementLoc of LogInPage");
        }
    }

    public LogInPage clickLogIn(){
        driver.findElement(loginLoc).click();
        return this;
    }

    public LogInPage typeEmail(String email){
        driver.findElement(emailInputLoc).sendKeys(email);
        return this;
    }

    public LogInPage typePassword(String password){
        driver.findElement(passwordInputLoc).sendKeys(password);
        return this;
    }

    public LogInPage clickLoginButton(){
        driver.findElement(loginButtonLoc).click();
        return this;
    }

    public ProjectPage LogIn(String email, String password){
        typeEmail(email)
                .typePassword(password)
                .clickLoginButton();
        return new ProjectPage(driver);
    }
}
