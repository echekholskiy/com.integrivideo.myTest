package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.FileAssert.fail;

public class ComponentPage extends LoadableComponent<ComponentPage> {
    private WebDriver driver;

    public ComponentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By componentTypeSpanLoc = By.xpath("//span[@class='select2-selection__arrow']");
    private By componentTypeInputLoc = By.xpath("//input[@name='type']");
    private By componentNameLoc = By.xpath("//input[@name='name']");
    private By createButtonLoc = By.xpath("//button[text()='Create']");
    private By updateButtonLoc = By.xpath("//button[text()='Update']");
    private By openElementLoc = By.xpath("//label[text()='Component type']");

    @Override
    public void load(){
        driver.get("https://dev.integrivideo.com/app/projects/5a75c2f1c9be4c063d6122bd/components/new");
    }

    @Override
    public void isLoaded() throws Error{
        try {
            (new WebDriverWait(driver, 5))
                    .until(ExpectedConditions.presenceOfElementLocated(openElementLoc));
        } catch (TimeoutException e) {
            fail("Cannot locate openElementLoc of ComponentPage");
        }
    }

    public ComponentPage clickSelectComponentType(){
        driver.findElement(componentTypeSpanLoc).click();
        return this;
    }

    public ComponentPage selectComponentType(String typeComponent){
        clickSelectComponentType();
        driver.findElement(By.xpath(String.format("//li[contains(text(), '%s')]", typeComponent))).click();
        return this;
    }

    public ComponentPage typeComponentName(String name){
        driver.findElement(componentNameLoc).sendKeys(name);
        return this;
    }

    public ComponentPage clickCreateButton(){
        driver.findElement(createButtonLoc).click();
        return this;
    }

    public InProjectPage clickUpdateButton(){
        driver.findElement(updateButtonLoc).click();
        return new InProjectPage(driver);
    }

    public InProjectPage addComponent(String ComponentType, String ComponentName){
        selectComponentType(ComponentType)
                .typeComponentName(ComponentName)
                .clickCreateButton()
                .clickUpdateButton();
        return new InProjectPage(driver);
    }

    public String getTypeComponent(){
        return driver.findElement(componentTypeInputLoc).getAttribute("value");
    }
    public String getComponentName(){
        return driver.findElement(componentNameLoc).getAttribute("value");
    }
}
