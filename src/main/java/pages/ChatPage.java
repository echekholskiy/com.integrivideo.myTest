package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.FileAssert.fail;

public class ChatPage {
    private WebDriver driver;

    public ChatPage(WebDriver driver) {
        this.driver = driver;
    }

    private By settingsLoc = By.xpath("//span[text()=' Settings']");
    private By openElementLoc = By.xpath("//button[@id='invite-users-to-chat']");
    private By userNameLoc = By.xpath("//input[@name='userName']");
    private By userEmailLoc = By.xpath("//input[@name='userEmail']");
    private By pictureAdressLoc = By.xpath("//input[@name='userPic']");
    private By saveButtonLoc = By.xpath("//button[@class='integri-user-settings-save integri-button-blue']");
    private By establishedNameLoc = By.xpath("//div[@class='integri-session-user-name']");
    private By sendMessageButton = By.xpath("//button[@class='integri-chat-send-message integri-chat-action-button']");
    private By textAreaLoc = By.xpath("//textarea[@placeholder='Start typing here']");
    private By messageLoc = By.xpath("//div[@class='integri-chat-message-text']");

    public void isLoaded() throws Error{
        try {
            (new WebDriverWait(driver, 5))
                    .until(ExpectedConditions.presenceOfElementLocated(openElementLoc));
        } catch (TimeoutException e) {
            fail("Cannot locate openElementLoc of ComponentPage");
        }
    }

    public ChatPage settingsClick(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(settingsLoc));
        driver.findElement(settingsLoc).click();
        return new ChatPage(driver);
    }

    public ChatPage typeUserName(String username){
        driver.findElement(userNameLoc).clear();
        driver.findElement(userNameLoc).sendKeys(username);
        return new ChatPage(driver);
    }

    public ChatPage typeUserEmail(String useremail){
        driver.findElement(userEmailLoc).sendKeys(useremail);
        return new ChatPage(driver);
    }

    public ChatPage typePictureAdress(String pictureadress){
        driver.findElement(pictureAdressLoc).sendKeys(pictureadress);
        return new ChatPage(driver);
    }

    public ChatPage clickSaveButton(){
        driver.findElement(saveButtonLoc).click();
        return new ChatPage(driver);
    }

    public ChatPage typeAllSettings(String username, String useremail, String pictureadress){
        settingsClick()
                .typeUserName(username)
                .typeUserEmail(useremail)
                .typePictureAdress(pictureadress)
                .clickSaveButton();
        return new ChatPage(driver);
    }

    public String getUserName(){
        return driver.findElement(userNameLoc).getAttribute("value");
    }

    public String getUserEmail(){
        return driver.findElement(userEmailLoc).getAttribute("value");
    }

    public String getPictureAdress(){
        return driver.findElement(pictureAdressLoc).getAttribute("value");
    }

    public String getEstablishedName(){
        String s=driver.findElement(establishedNameLoc).getText();
        System.out.println(s);
        return s;
    }

    public ChatPage clearUserName(){
        driver.findElement(userNameLoc).clear();
        return new ChatPage(driver);
    }

    public ChatPage clickSendMessage(){
        driver.findElement(sendMessageButton).click();
        return new ChatPage(driver);
    }

    public ChatPage typeMessage(String message){
        driver.findElement(textAreaLoc).sendKeys(message);
        return new ChatPage(driver);
    }

    public ChatPage sendMessage(String message){
        typeMessage(message)
                .clickSendMessage();
        return new ChatPage(driver);
    }

    public String getTextMessage(){
        return driver.findElement(messageLoc).getText();
    }

}
