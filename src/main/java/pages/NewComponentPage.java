package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewComponentPage {
    private WebDriver driver;

    public NewComponentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By componentTypeLoc=By.xpath("//span[@class='select2-selection__arrow']");
    private By videoChatLoc=By.xpath("//li[contains(text(), 'Video Chat')]");
    private By multiVideoPleerLoc=By.xpath("//li[contains(text(), 'Multi-device Video Player')]");
    private By singleVideoLoc=By.xpath("//li[contains(text(), 'Single Video')]");
    private By multiPartyVideoLoc=By.xpath("//li[contains(text(), 'Multiparty Video')]");
    private By componentNameLoc=By.xpath("//input[@class='form-control']");
    private By createButtonLoc=By.xpath("//button[@class='btn']");
    private By updateButtonLoc=By.xpath("//button[text()='Update']");
    WebDriverWait wait1;


    public NewComponentPage clickSelectComponentType(){
        driver.findElement(componentTypeLoc).click();
        return this;
    }

    public NewComponentPage selectComponentType(By loc){
        clickSelectComponentType();
        driver.findElement(loc).click();
        return this;
    }

    public NewComponentPage typeComponentName(String name){
        driver.findElement(componentNameLoc).sendKeys(String.format("Test%s", name));
        return this;
    }

    public NewComponentPage clickCreateButton(){
        driver.findElement(createButtonLoc).click();
        return this;
    }

    public InProjectPage clickUpdateButton(){
        wait1=(new WebDriverWait(driver, 10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(updateButtonLoc));
        driver.findElement(updateButtonLoc).click();
        return new InProjectPage(driver);
    }

    public InProjectPage addVideoChat(){
        selectComponentType(videoChatLoc)
                .typeComponentName("VideoChat")
                .clickCreateButton()
                .clickUpdateButton();
        return new InProjectPage(driver);
    }

    public InProjectPage addMultiVideoPleer(){
        selectComponentType(multiVideoPleerLoc)
                .typeComponentName("MultiVideoPleer")
                .clickCreateButton()
                .clickUpdateButton();
        return new InProjectPage(driver);
    }

    public InProjectPage addSingleVideo(){
        selectComponentType(singleVideoLoc)
                .typeComponentName("SingleVideo")
                .clickCreateButton()
                .clickUpdateButton();
        return new InProjectPage(driver);
    }

    public InProjectPage addMultiPartyVideo(){
        selectComponentType(multiPartyVideoLoc)
                .typeComponentName("MultiPartyVideo")
                .clickCreateButton()
                .clickUpdateButton();
        return new InProjectPage(driver);
    }

}
