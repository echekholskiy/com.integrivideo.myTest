package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProjectPage {
    private WebDriver driver;

    public EditProjectPage(WebDriver driver) {
        this.driver = driver;
    }
    private By projectNameLoc=By.xpath("//input[@name='name']");
    private By descriptionLoc=By.xpath("//textarea[@class='form-control']");
    private By domenLoc=By.xpath("//div[@class='form-group domains']//input[@required]");
    private By updateButtonLoc=By.xpath("//button[@class='btn']");

    public EditProjectPage editProjectName(String name){
        driver.findElement(projectNameLoc).clear();
        driver.findElement(projectNameLoc).sendKeys(name);
        return this;
    }

    public EditProjectPage editDescription(String description){
        driver.findElement(descriptionLoc).clear();
        driver.findElement(descriptionLoc).sendKeys(description);
        return this;
    }

    public EditProjectPage editDomen(String domen){
        driver.findElement(domenLoc).clear();
        driver.findElement(domenLoc).sendKeys(domen);
        return this;
    }

    public ProjectPage clickUpdateButton(){
        driver.findElement(updateButtonLoc).click();
        return new ProjectPage(driver);
    }

    public ProjectPage editProject(String projectName, String description, String domen){
        return editProjectName(projectName).editDescription(description).editDomen(domen).clickUpdateButton();
    }

}

