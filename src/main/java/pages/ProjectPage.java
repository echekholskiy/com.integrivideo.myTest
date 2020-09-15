package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.LoadableComponent;


import static org.testng.FileAssert.fail;


public class ProjectPage extends BasicPage {
    private WebDriver driver;

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addButtonLoc = By.xpath("//div[@class='project new']");
    private By lastProjectLoc = By.xpath("//div[@class='col-xl-4 col-sm-6'][last()-1]/div//div[1]");
    private By billingButtonLoc = By.xpath("//a[text()='Billing']");
    private By projectList = By.xpath("//div[@class='col-xl-4 col-sm-6']");
    private By lastProjectLetters = By.xpath("//div[@class='col-xl-4 col-sm-6'][last()-1]/div//div[@class='circle']");
    private By logoLoc = By.xpath("//a[@class='navbar-brand logo']");
    private By openElementLoc = By.xpath("//div[@class='status' and text()='Add project']");

    public void load(){
        driver.get("https://dev.integrivideo.com/app/projects");
    }

    public void isLoaded() throws Error{
        try {
            presenceOfElementLocated(driver, openElementLoc, 20);
        } catch (TimeoutException e) {
            fail("Cannot locate openElementLoc of ProjectPage");
        }
    }

    public MainPage clickLogo(){
        elementToBeClickable(driver, logoLoc, 20);

        driver.findElement(logoLoc).click();
        return new MainPage(driver);
    }

    public CreateProjectPage clickAddProject(){
        presenceOfElementLocated(driver, addButtonLoc, 20);

        WebElement addProjectButton = driver.findElement(addButtonLoc);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addProjectButton);
        addProjectButton.click();
        return new CreateProjectPage(driver);
    }

    public InProjectPage clickLastOfProject(){
        presenceOfElementLocated(driver, addButtonLoc, 20);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(lastProjectLoc));
        driver.findElement(lastProjectLoc).click();
        return new InProjectPage(driver);
    }

    public BillingPage clickBillingButton(){
        driver.findElement(billingButtonLoc).click();
        return new BillingPage(driver);
    }

    public int getSizeOfProjectList(){
        presenceOfElementLocated(driver, projectList, 20);

        return driver.findElements(projectList).size();
    }

    public String getLastProjectLetters(){
        return driver.findElement(lastProjectLetters).getText();
    }

    public String getExpectedProjectLetters(String ProjectName){
        if(ProjectName.contains(" ")){
            return Character.toString(ProjectName.charAt(0)) + Character.toString(ProjectName.charAt(ProjectName.indexOf(" ") + 1));
        }
        else return Character.toString(ProjectName.charAt(0));
    }
}
