package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    private WebDriver driver;
    private WebDriverWait wait;

    public Waiter(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void presenceOfElementLocated(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void elementToBeClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void numberOfElementsToBeMoreThan(By locator, int number){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
    }
}
