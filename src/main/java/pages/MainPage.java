package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By chatTryItOutLoc = By.xpath("//h3[text()='Chat']/parent::*//a");

    public ChatPage clickChatTryItOutLoc(){
        driver.findElement(chatTryItOutLoc).click();
        return new ChatPage(driver);
    }
}
