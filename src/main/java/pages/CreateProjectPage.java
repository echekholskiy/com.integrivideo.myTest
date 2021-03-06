package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import utils.Waiter;

import static org.testng.FileAssert.fail;

public class CreateProjectPage extends BasicPage{
    private WebDriver driver;
    private Waiter wait;

    public CreateProjectPage(WebDriver driver) {
        this.driver = driver;
        wait = new Waiter(driver);
    }

    private By projectNameLoc = By.xpath("//input[@name='name']");
    private By descriptionLoc = By.xpath("//textarea[@class='form-control']");
    private By domenLoc = By.xpath("//div[@class='form-group domains']//input[@required]");
    private By buttonLoc = By.xpath("//button[@class='btn']");

    private By openElementLoc = By.xpath("//label[@class='required' and text()='Project name']");

    public void load(){
        driver.get("https://dev.integrivideo.com/app/projects/new");
    }

    public void isLoaded() throws Error{
        try {
            wait.presenceOfElementLocated(openElementLoc);
        } catch (TimeoutException e) {
            fail("Cannot locate openElementLoc of CreateProjectPage");
        }
    }

    public CreateProjectPage typeProjectName(String ProjectName){
        driver.findElement(projectNameLoc).sendKeys(ProjectName);
        return new CreateProjectPage(driver);
    }

    public CreateProjectPage typeDescription(String Description){
        driver.findElement(descriptionLoc).sendKeys(Description);
        return new CreateProjectPage(driver);
    }

    public CreateProjectPage typeDomain(String Domen){
        driver.findElement(domenLoc).sendKeys(Domen);
        return new CreateProjectPage(driver);
    }

    public CreateProjectPage clickCreateButton(){
        driver.findElement(buttonLoc).click();
        return new CreateProjectPage(driver);
    }

    public ProjectPage clickUpdateButton(){
        driver.findElement(buttonLoc).click();
        return new ProjectPage(driver);
    }

    public ProjectPage addProject(String projectName, String description, String domain){
        typeProjectName(projectName)
                .typeDescription(description)
                .typeDomain(domain)
                .clickCreateButton();
        return new ProjectPage(driver);
    }

    public CreateProjectPage editProjectName(String ProjectName){
        driver.findElement(projectNameLoc).clear();
        driver.findElement(projectNameLoc).sendKeys(ProjectName);
        return this;
    }

    public CreateProjectPage editDescription(String Description){
        driver.findElement(descriptionLoc).clear();
        driver.findElement(descriptionLoc).sendKeys(Description);
        return this;
    }

    public CreateProjectPage editDomen(String Domen){
        driver.findElement(domenLoc).clear();
        driver.findElement(domenLoc).sendKeys(Domen);
        return this;
    }

    public ProjectPage editProject(String projectName, String description, String domen){
        return editProjectName(projectName).editDescription(description).editDomen(domen).clickUpdateButton();
    }
}
