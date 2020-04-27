package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateProjectPage {
    WebDriver driver;

    public CreateProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    By projectNameInput=By.xpath("//input[@placeholder='New project']");
    By descriptionInput=By.xpath("//textarea[@class='form-control']");
    By domainInput=By.xpath("//input[@placeholder='example.com']");
    By createButton=By.xpath("//button[@class='btn']");

    public CreateProjectPage typeProjectName(String ProjectName){
        driver.findElement(projectNameInput).sendKeys(ProjectName);
        //TODO по идее ты можешь написать return this; - у тебя this это обьект типа CreateProjectPage,
        // назовем его ПИДАР так вот у ПИДАРА есть драйвер. А ты создаешь ДОЛБАЕБА и передаешь ему драйвер
        // ПИДАРА по сути пидар и долбаеб идентичны но новый обьект нахуя-то создался. Автоматизация это не про
        // производительность но короче лучше.
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
