package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.FileAssert.fail;

public class InProjectPage extends BasicPage{
    private WebDriver driver;

    public InProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    private By projectNameLoc = By.xpath("//h1");
    private By descriptionLoc = By.xpath("//div[@class='col-12 description']");
    private By editButtonLoc = By.xpath("//a[text()='Edit']");
    private By addComponentButtonLoc = By.xpath("//div[@class='status']");
    private By lastComponentButtonLoc = By.xpath("//div[@class='col-xl-4 col-sm-6'][last()-1]//a");

    private By openElementLoc=By.xpath("//div[@class='status' and text()='Add new component']");

    public String getProjectName(){
        return driver.findElement(projectNameLoc).getText();
    }
    public String getDescription(){
        return driver.findElement(descriptionLoc).getText();
    }

    public void load(){
        driver.get("//");
    }

    public void isLoaded() throws Error{
        try {
            presenceOfElementLocated(driver, openElementLoc, 5);
        } catch (TimeoutException e) {
            fail("Cannot locate openElementLoc of InProjectPage");
        }
    }

    public CreateProjectPage clickEditButton(){
        driver.findElement(editButtonLoc).click();
        return new CreateProjectPage(driver);
    }

    public ComponentPage clickAddComponentButton(){
        driver.findElement(addComponentButtonLoc).click();
        return new ComponentPage(driver);
    }

    public ComponentPage clickLastComponent(){
        driver.findElement(lastComponentButtonLoc).click();
        return new ComponentPage(driver);
    }
}
