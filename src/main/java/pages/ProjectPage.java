package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class ProjectPage {
    private WebDriver driver;

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addButtonLoc=By.xpath("//div[@class='project new']");
    private By lastProjectLoc=By.xpath("//div[@class='project']/a/div[1]");


    public CreateProjectPage clickAddProject(){
        WebElement addProjectButton=driver.findElement(addButtonLoc);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addProjectButton);
        addProjectButton.click();
        return new CreateProjectPage(driver);
    }

    public InProjectPage clickLastOfProject(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@class='col-xl-4 col-sm-6'][last()-1]/div//div[1]")));
        driver.findElement(By.xpath("//div[@class='col-xl-4 col-sm-6'][last()-1]/div//div[1]")).click();
        return new InProjectPage(driver);
    }

}
