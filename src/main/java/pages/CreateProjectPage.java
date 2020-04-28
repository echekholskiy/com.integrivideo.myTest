package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateProjectPage {
    private WebDriver driver;

    public CreateProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    private By projectNameInput=By.xpath("//input[@placeholder='New project']");
    private By descriptionInput=By.xpath("//textarea[@class='form-control']");
    private By domainInput=By.xpath("//input[@placeholder='example.com']");
    private By createButton=By.xpath("//button[@class='btn']");

    public CreateProjectPage typeProjectName(String ProjectName){
        driver.findElement(projectNameInput).sendKeys(ProjectName);
        return new CreateProjectPage(driver);
    }

    public CreateProjectPage typeDescription(String Description){
        driver.findElement(descriptionInput).sendKeys(Description);
        return new CreateProjectPage(driver);
    }

    public CreateProjectPage typeDomain(String Domain){
        driver.findElement(domainInput).sendKeys(Domain);
        return new CreateProjectPage(driver);
    }

    public CreateProjectPage clickCreate(){
        driver.findElement(createButton).click();
        return new CreateProjectPage(driver);
    }

    public ProjectPage addProject(String projectName, String description, String domain){
        typeProjectName(projectName).typeDescription(description).typeDomain(domain).clickCreate();
        return new ProjectPage(driver);
    }

}
