package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.FileAssert.fail;

public class ChatPage extends BasicPage{
    private WebDriver driver;

    public ChatPage(WebDriver driver) {
        this.driver = driver;
    }

    private By settingsLoc = By.xpath("//span[text()=' Settings']");
    private By openElementLoc = By.xpath("//button[@id='invite-users-to-chat']");
    private By userNameLoc = By.xpath("//input[@name='userName']");
    private By sessionUserNameLoc = By.xpath("//div[@class='integri-session-user-name']");
    private By userEmailLoc = By.xpath("//input[@name='userEmail']");
    private By pictureAdressLoc = By.xpath("//input[@name='userPic']");
    private By sessionPictureAdressLoc = By.xpath("//div[@class='integri-user-pic integri-session-is-online integri-current-session']");
    private By saveButtonLoc = By.xpath("//button[@class='integri-user-settings-save integri-button-blue']");
    private By establishedNameLoc = By.xpath("//div[@class='integri-session-user-name']");
    private By sendMessageButton = By.xpath("//button[@class='integri-chat-send-message integri-chat-action-button']");
    private By textAreaLoc = By.xpath("//textarea[@placeholder='Start typing here']");
    private By messageLoc = By.xpath("//div[@class='integri-chat-message-text']");
    private By deleteMessageButtonLoc = By.xpath("//span[@class='iv-icon iv-icon-trash2 integri-chat-remove-message']");
    private By deleteMessageDivLoc = By.xpath("//div[text()='removed...']");
    private By editMessageButtonLoc = By.xpath("//span[@class='iv-icon iv-icon-pencil integri-chat-edit-message']");
    private By editTextAreaLoc = By.xpath("//div[@class='integri-chat-message ']/textarea");
    private By editedLabelLoc = By.xpath("//div[@class='integri-chat-message-container integri-chat-message-own integri-chat-message-edited']");
    private By demoVersionWindowLoc = By.xpath("//div[@class='integri-demo-version']");

    public void isLoaded() throws Error{
        try {
            presenceOfElementLocated(driver, openElementLoc, 5);
        } catch (TimeoutException e) {
            fail("Cannot locate openElementLoc of ComponentPage");
        }
    }

    public ChatPage settingsClick(){
        elementToBeClickable(driver, settingsLoc, 10);
        driver.findElement(settingsLoc).click();
        return this;
    }

    public ChatPage typeUserName(String username){
        driver.findElement(userNameLoc).clear();
        driver.findElement(userNameLoc).sendKeys(username);
        return this;
    }

    public ChatPage typeUserEmail(String useremail){
        driver.findElement(userEmailLoc).sendKeys(useremail);
        return this;
    }

    public ChatPage typePictureAdress(String pictureadress){
        driver.findElement(pictureAdressLoc).sendKeys(pictureadress);
        return this;
    }

    public ChatPage clickSaveButton(){
        driver.findElement(saveButtonLoc).click();
        return this;
    }

    public ChatPage typeAllSettings(String username, String useremail, String pictureadress){
        settingsClick()
                .typeUserName(username)
                .typeUserEmail(useremail)
                .typePictureAdress(pictureadress)
                .clickSaveButton();
        return this;
    }

    public String getUserName(){
        return driver.findElement(userNameLoc).getAttribute("value");
    }

    public String getSessionUserName(){
        return driver.findElement(sessionUserNameLoc).getText();
    }

    public String getUserEmail(){
        return driver.findElement(userEmailLoc).getAttribute("value");
    }

    public String getPictureAdress(){
        return driver.findElement(pictureAdressLoc).getAttribute("value");
    }

    public String getSessionPictureAdress(){
        String style = driver.findElement(sessionPictureAdressLoc).getAttribute("style");
        return style.substring(23, style.length()-3);
    }

    public String getEstablishedName(){
        String s=driver.findElement(establishedNameLoc).getText();
        System.out.println(s);
        return s;
    }

    public ChatPage clearUserName(){
        driver.findElement(userNameLoc).clear();
        return this;
    }

    public ChatPage clickSendMessage(){
        driver.findElement(sendMessageButton).click();
        return this;
    }

    public ChatPage typeMessage(String message){
        driver.findElement(textAreaLoc).sendKeys(message);
        return this;
    }

    public ChatPage sendMessage(String message){
        typeMessage(message)
                .clickSendMessage();
        return this;
    }

    public String getTextMessage(){
        return driver.findElement(messageLoc).getText();
    }

    public ChatPage deleteMessage(){
        driver.findElement(deleteMessageButtonLoc).click();
        driver.switchTo().alert().accept();
        presenceOfElementLocated(driver, deleteMessageDivLoc, 10); //ну тут какой-то хуйни нагородил
        return this;
    }

    public ChatPage editMessage(String editText){
        driver.findElement(editMessageButtonLoc).click();
        driver.findElement(editTextAreaLoc).clear();
        driver.findElement(editTextAreaLoc).sendKeys(editText);
        driver.findElement(editTextAreaLoc).sendKeys(Keys.ENTER);
        return this;
    }

    public String getEditedLabelText(){
        presenceOfElementLocated(driver, editedLabelLoc, 10);
        String script = "return window.getComputedStyle(document.querySelector('div.integri-chat-message-text'), ':after').content";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String content = (String) js.executeScript(script);
        return content;
    }

    public ChatPage sendElevenMessages(String textMessages){
        for(int i=0; i<11; i++){
            sendMessage(textMessages);
            if(i<10) {
                numberOfElementsToBeMoreThan(driver, messageLoc, 10, i);
            }
        }
        return this;
    }

    public boolean checkDemoVersionWindow(){
        try{
        driver.findElement(demoVersionWindowLoc);  //Тут можно было сделать через isDisplayed(), но тогла метод будет
        return true;                               //возвращать только true, а в случае бага будет выдавать не
        }catch (NoSuchElementException e){         //assert-несоответсвие, а ошибку на уровне пэйджы
            return false;
        }
    }
}
