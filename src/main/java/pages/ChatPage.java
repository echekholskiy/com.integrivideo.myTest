package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatPage {
    private WebDriver driver;

    public ChatPage(WebDriver driver) {
        this.driver = driver;
    }

    private By settingsLoc = By.xpath("//span[text()=' Settings']");

    public void settingsClick(){
        driver.findElement(settingsLoc).click();
    }


}
