package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InComponentPage {
    private WebDriver driver;
    private WebDriverWait wait1;

    public InComponentPage(WebDriver driver) {
        this.driver = driver;
    }
    private By componentTypeLoc=By.xpath("//input[@name='type']");
    private By componentNameLoc=By.xpath("//input[@name='name']");
    private By updateButtonLoc=By.xpath("//button[text()='Update']");

    public String getTypeComponent(){
        return driver.findElement(componentTypeLoc).getAttribute("value");
    }

    public String getComponentName(){
        return driver.findElement(componentNameLoc).getAttribute("value");
    }

    public InProjectPage clickUpdateButton(){
        wait1=(new WebDriverWait(driver, 10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(updateButtonLoc));
        driver.findElement(updateButtonLoc).click();
        return new InProjectPage(driver);
    }
}
