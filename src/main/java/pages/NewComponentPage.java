package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public InComponentPage clickCreateButton(){
        driver.findElement(createButtonLoc).click();
        return new InComponentPage(driver);
    }

    public InProjectPage addVideoChat(String videoChatName){
        selectComponentType(videoChatLoc)
                .typeComponentName(videoChatName)
                .clickCreateButton()
                .clickUpdateButton();
        return new InProjectPage(driver);
    }

    public InProjectPage addMultiVideoPleer(String multiVideoPleerName){
        selectComponentType(multiVideoPleerLoc)
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

}
