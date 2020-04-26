import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage {
    WebDriver driver;

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    By addProjectButton=By.xpath("//div[@class='project new']/a");

    public CreateProjectPage clickAddProject(){
        driver.findElement(addProjectButton).click();
        return new CreateProjectPage(driver);
    }

}
