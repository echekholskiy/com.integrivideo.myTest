package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import utils.Waiter;

import static org.testng.FileAssert.fail;

public class MainPage extends BasicPage{
    private WebDriver driver;
    private Waiter wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new Waiter(driver);
    }

    private By chatTryItOutLoc = By.xpath("//h3[text()='Chat']/parent::*//a");
    private By openElementLoc = By.xpath("//a[text()='Log in']");

    public void isLoaded() throws Error{
        try {
            wait.presenceOfElementLocated(openElementLoc);
        } catch (TimeoutException e) {
            fail("Cannot locate openElementLoc of MainPage");
        }
    }

    public ChatPage clickChatTryItOutLoc(){
        driver.findElement(chatTryItOutLoc).click();
        return new ChatPage(driver);
    }
}
