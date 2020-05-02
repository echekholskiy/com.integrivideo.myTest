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

    public ComponentPage clickSelectComponentType(){
        driver
                .findElement(componentTypeSpanLoc)
                .click();
        return this;
    }

    public ComponentPage selectComponentType(By loc){
        clickSelectComponentType();
        driver
                .findElement(loc)
                .click();
        return this;
    }

    public ComponentPage typeComponentName(String name){
        driver
                .findElement(componentNameLoc)
                .sendKeys(String.format("Test %s", name));
        return this;
    }

    public ComponentPage clickCreateButton(){
        driver
                .findElement(createButtonLoc)
                .click();
        return this;
    }

    public InProjectPage clickUpdateButton(){
        driver
                .findElement(updateButtonLoc)
                .click();
        return new InProjectPage(driver);
    }

    public InProjectPage addVideoChat(String videoChatName){
        selectComponentType(videoChatLoc)
                .typeComponentName(videoChatName)
                .clickCreateButton()
                .clickUpdateButton();
        return new InProjectPage(driver);
    }

    public InProjectPage addMultiVideoPlayer(String multiVideoPleerName){
        selectComponentType(multiVideoPlayerLoc)
                .typeComponentName(multiVideoPleerName)
                .clickCreateButton()
                .clickUpdateButton();
        return new InProjectPage(driver);
    }

    public InProjectPage addSingleVideo(String singleVideoName){
        selectComponentType(singleVideoLoc)
                .typeComponentName(singleVideoName)
                .clickCreateButton()
                .clickUpdateButton();
        return new InProjectPage(driver);
    }

    public InProjectPage addMultiPartyVideo(String multiPartyVideo){
        selectComponentType(multiPartyVideoLoc)
                .typeComponentName(multiPartyVideo)
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
