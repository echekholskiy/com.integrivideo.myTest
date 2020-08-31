package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.FileAssert.fail;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By chatTryItOutLoc = By.xpath("//h3[text()='Chat']/parent::*//a");
    private By openElementLoc = By.xpath("//a[text()='Log in']");

    public void isLoaded() throws Error{
        try {
            (new WebDriverWait(driver, 20))
                    .until(ExpectedConditions.presenceOfElementLocated(openElementLoc));
        } catch (TimeoutException e) {
            fail("Cannot locate openElementLoc of MainPage");
        }
    }

    public ChatPage clickChatTryItOutLoc(){
        driver.findElement(chatTryItOutLoc).click();
        return new ChatPage(driver);
    }
}
