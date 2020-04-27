package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailInput=By.xpath("//input[@type='email']");
    By passwordInput=By.xpath("//input[@type='password']");
    By loginButton=By.xpath("//button[@class='btn btn-primary']");

    public LogInPage typeEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
        return new LogInPage(driver);
    }

    public LogInPage typePassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
        return new LogInPage(driver);
    }

    public LogInPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new LogInPage(driver);
    }

    public ProjectPage LogIn(String email, String password){
        typeEmail(email).typePassword(password).clickLoginButton();
        return new ProjectPage(driver);
    }

}
