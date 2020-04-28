package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    private WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By login=By.xpath("//a[@class='btn']");
    private By emailInput=By.xpath("//input[@type='email']");
    private By passwordInput=By.xpath("//input[@type='password']");
    private By loginButton=By.xpath("//button[@class='btn btn-primary']");

    public LogInPage clickLogIn(){
        driver.findElement(login).click();
        return this;
    }

    public LogInPage typeEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public LogInPage typePassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public LogInPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return this;
    }

    public ProjectPage LogIn(String email, String password){
        clickLogIn().typeEmail(email).typePassword(password).clickLoginButton();
        return new ProjectPage(driver);
    }

}
