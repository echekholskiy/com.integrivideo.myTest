package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InComponentPage {
    private WebDriver driver;

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
        driver.findElement(updateButtonLoc).click();
        return new InProjectPage(driver);
    }
}
