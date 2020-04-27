import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProjectPage {
    WebDriver driver;

    public EditProjectPage(WebDriver driver) {
        this.driver = driver;
    }
    By projectNameLoc=By.xpath("//input[@name='name']");
    By descriptionLoc=By.xpath("//textarea");
    By domenLoc=By.xpath("//div[@class='form-group domains']/div[1]/input");
    By updateButtonLoc=By.xpath("//button[@class='btn']");

    public EditProjectPage editProjectName(String name){
        WebElement projectName=driver.findElement(projectNameLoc);
        projectName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        projectName.sendKeys(name);
        return new EditProjectPage(driver);
    }

    public EditProjectPage editDescription(String description){
        WebElement Description=driver.findElement(descriptionLoc);
        Description.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Description.sendKeys(description);
        return new EditProjectPage(driver);
    }

    public EditProjectPage editDomen(String domen){
        WebElement Domen=driver.findElement(domenLoc);
        Domen.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Domen.sendKeys(domen);
        return new EditProjectPage(driver);
    }

    public ProjectPage clickUpdateButton(){
        driver.findElement(updateButtonLoc).click();
        return new ProjectPage(driver);
    }

    public ProjectPage editProject(String projectName, String description, String domen){
        return editProjectName(projectName).editDescription(description).editDomen(domen).clickUpdateButton();
    }

}

