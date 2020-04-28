package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InProjectPage {
    private WebDriver driver;

    public InProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO это че xpath?
    private By h1=By.xpath("//h1"); //TODO h1-переименовать
    private By locDescription=By.xpath("//div[@class='col-12 description']");
    private By editButton=By.xpath("//a[text()='Edit']");
    private By addComponentButton=By.xpath("//div[@class='status']");

    public String getProjectName(){
        return driver.findElement(h1).getText();
    }

    public String getDescription(){
        return driver.findElement(locDescription).getText();
    }

    public EditProjectPage clickEditButton(){
        driver.findElement(editButton).click();
        return new EditProjectPage(driver);
    }

    public NewComponentPage clickAddComponentButton(){
        driver.findElement(addComponentButton).click();
        return new NewComponentPage(driver);
    }

}
