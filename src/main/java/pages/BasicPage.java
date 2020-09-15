package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasicPage{

    public void presenceOfElementLocated(WebDriver driver, By locator, int time){
        (new WebDriverWait(driver, time))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void elementToBeClickable(WebDriver driver, By locator, int time){
        (new WebDriverWait(driver, time))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void numberOfElementsToBeMoreThan(WebDriver driver, By locator, int time, int number){
        (new WebDriverWait(driver, time))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
    }
}
