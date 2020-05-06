package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProjectPage {
    private WebDriver driver;

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addButtonLoc = By.xpath("//div[@class='project new']");
    private By lastProjectLoc = By.xpath("//div[@class='col-xl-4 col-sm-6'][last()-1]/div//div[1]");
    private By billingButtonLoc = By.xpath("//a[text()='Billing']");
    private By projectList = By.xpath("//div[@class='col-xl-4 col-sm-6']");
    private By lastProjectLetters=By.xpath("//div[@class='col-xl-4 col-sm-6'][last()-1]/div//div[@class='circle']");


    public CreateProjectPage clickAddProject(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(addButtonLoc));

        WebElement addProjectButton = driver.findElement(addButtonLoc);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addProjectButton);
        addProjectButton.click();
        return new CreateProjectPage(driver);
    }

    public InProjectPage clickLastOfProject(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(addButtonLoc));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(lastProjectLoc));
        driver
                .findElement(lastProjectLoc)
                .click();
        return new InProjectPage(driver);
    }

    public BillingPage clickBillingButton(){
        driver
                .findElement(billingButtonLoc)
                .click();
        return new BillingPage(driver);
    }

    public int getSizeOfProjectList(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(projectList));
        return driver.findElements(projectList).size();
    }

    public String getLastProjectLetters(){
        return driver.findElement(lastProjectLetters).getText();
    }


}
