import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ProjectPage {
    WebDriver driver;

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    By locAddButton=By.xpath("//div[@class='project new']");
    By locProjectButtons=By.xpath("//div[@class='project']/a/div[1]");


    public CreateProjectPage clickAddProject(){
        WebElement addProjectButton=driver.findElement(locAddButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addProjectButton);
        addProjectButton.click();
        return new CreateProjectPage(driver);
    }

    public WebElement getLastOfProject(){
        List<WebElement> listOfProjects=driver.findElements(locProjectButtons);
        return listOfProjects.get(listOfProjects.size()-1);
    }

    public InProjectPage clickLastOfProject(){
        getLastOfProject().click();
        return new InProjectPage(driver);
    }

}
