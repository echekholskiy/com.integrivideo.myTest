package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComponentPage {
    private WebDriver driver;

    public ComponentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By componentTypeSpanLoc=By.xpath("//span[@class='select2-selection__arrow']");
    private By componentTypeInputLoc=By.xpath("//input[@name='type']");
    private By videoChatLoc=By.xpath("//li[contains(text(), 'Video Chat')]");
    private By multiVideoPlayerLoc=By.xpath("//li[contains(text(), 'Multi-device Video Player')]");
    private By singleVideoLoc=By.xpath("//li[contains(text(), 'Single Video')]");
    private By multiPartyVideoLoc=By.xpath("//li[contains(text(), 'Multiparty Video')]");
    private By componentNameLoc=By.xpath("//input[@name='name']");
    private By createButtonLoc=By.xpath("//button[text()='Create']");
    private By updateButtonLoc=By.xpath("//button[text()='Update']");

    private By openElementLoc=By.xpath("//label[text()='Component type']");

    public boolean isPageOpened(){
        if(driver.findElements(openElementLoc).size()!=0) {
            return true;
        }
        else return false;
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
