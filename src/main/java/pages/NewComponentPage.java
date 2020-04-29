package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewComponentPage {
    private WebDriver driver;

    public NewComponentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By componentTypeLoc=By.xpath("//span[@class='select2-selection__arrow']");
    private By videoChatLoc=By.xpath("//li[@id='select2-type-6e-result-cicy-Chat']");
    private By multiVideoPleerLoc=By.xpath("//li[@id='select2-type-6e-result-r435-Playback']");
    private By singleVideoLoc=By.xpath("//li[@id='select2-type-6e-result-erlc-VideoSingle']");
    private By multiPartyVideoLoc=By.xpath("//li[@id='select2-type-6e-result-oq8q-VideoMulti']");
    private By componentNameLoc=By.xpath("//input[@class='form-control']");
    private By createButtonLoc=By.xpath("//button[@class='btn']");


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

    public InProjectPage addVideoChat(){
        selectComponentType(videoChatLoc).typeComponentName("VideoChat").clickCreateButton().clickCreateButton();
        return new InProjectPage(driver);
    }

    public InProjectPage addMultiVideoPleer(){
        selectComponentType(multiVideoPleerLoc).typeComponentName("MultiVideoPleer").clickCreateButton().clickCreateButton();
        return new InProjectPage(driver);
    }

    public InProjectPage addSingleVideo(){
        selectComponentType(singleVideoLoc).typeComponentName("SingleVideo").clickCreateButton().clickCreateButton();
        return new InProjectPage(driver);
    }

    public InProjectPage addMultiPartyVideo(){
        selectComponentType(multiPartyVideoLoc).typeComponentName("MultiPartyVideo").clickCreateButton().clickCreateButton();
        return new InProjectPage(driver);
    }

}
