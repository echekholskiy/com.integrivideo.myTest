package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InProjectPage {
    private WebDriver driver;

    public InProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    private By projectNameLoc=By.xpath("//h1");
    private By descriptionLoc=By.xpath("//div[@class='col-12 description']");
    private By editButtonLoc=By.xpath("//a[text()='Edit']");
    private By addComponentButtonLoc=By.xpath("//div[@class='status']");

    public String getProjectName(){
        return driver.findElement(projectNameLoc).getText();
    }
    public String getDescription(){
        return driver.findElement(descriptionLoc).getText();
    }

    public EditProjectPage clickEditButton(){
        driver.findElement(editButtonLoc).click();
        return new EditProjectPage(driver);
    }

    public NewComponentPage clickAddComponentButton(){
        driver.findElement(addComponentButtonLoc).click();
        return new NewComponentPage(driver);
    }

}
