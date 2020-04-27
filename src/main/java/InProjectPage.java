import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InProjectPage {
    WebDriver driver;

    public InProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    By h1=By.xpath("//h1");
    By locDescription=By.xpath("//div[@class='col-12 description']");

    public String getProjectName(){
        return driver.findElement(h1).getText();
    }

    public String getDescription(){
        return driver.findElement(locDescription).getText();
    }

}
