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
    private By lastComponentButtonLoc=By.xpath("//div[@class='col-xl-4 col-sm-6'][last()-1]//a");

    public String getProjectName(){
        return driver.findElement(projectNameLoc).getText();
    }
    public String getDescription(){
        return driver.findElement(descriptionLoc).getText();
    }

    public CreateProjectPage clickEditButton(){
        driver.findElement(editButtonLoc).click();
        return new CreateProjectPage(driver);
    }

    public NewComponentPage clickAddComponentButton(){
        driver.findElement(addComponentButtonLoc).click();
        return new NewComponentPage(driver);
    }

    public NewComponentPage clickLastComponent(){
        driver.findElement(lastComponentButtonLoc).click();
        return new NewComponentPage(driver);
    }

}
