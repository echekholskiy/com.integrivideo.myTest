package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import utils.Waiter;

import java.util.logging.Logger;

import static org.testng.FileAssert.fail;

public class AddCardPage extends BasicPage {
    private WebDriver driver;
    private Waiter wait;

    public AddCardPage(WebDriver driver) {
        this.driver = driver;
        wait = new Waiter(driver);
    }

    private By cardNumberLoc = By.xpath("//div[@class='credit-card']/input[@name='number']");
    private By expirationMonthLoc = By.xpath("//div[@class='credit-card']/input[@name='expirationMonth']");
    private By expirationYearLoc = By.xpath("//div[@class='credit-card']/input[@name='expirationYear']");
    private By cardHolderNameLoc = By.xpath("//div[@class='credit-card']/input[@name='cardholderName']");
    private By addButtonLoc = By.xpath("//button[text()='Add']");
    private By openElementLoc=By.xpath("//div[@class='credit-card']");
    private static final Logger log = Logger.getLogger(AddCardPage.class.getName());

    public void load(){
        driver.get("https://dev.integrivideo.com/app/billing/payment-methods/new");
    }

    public void isLoaded() throws Error{
        try {
            wait.presenceOfElementLocated(openElementLoc);
        } catch (TimeoutException e) {
            fail("Cannot locate openElementLoc of AddCardPage");
        }
    }

    public AddCardPage typeCardNumber(String CardNumber){
        driver.findElement(cardNumberLoc).sendKeys(CardNumber);
        log.info("type CardNumber: "+CardNumber);
        return this;
    }

    public AddCardPage typeExpirationMonth(String ExpirationMonth){
        driver.findElement(expirationMonthLoc).sendKeys(ExpirationMonth);
        log.info("type ExpirationMonth: "+ExpirationMonth);
        return this;
    }

    public AddCardPage typeExpirationYear(String ExpirationYear){
        driver.findElement(expirationYearLoc).sendKeys(ExpirationYear);
        log.info("type ExpirationYear: "+ExpirationYear);
        return this;
    }

    public AddCardPage typeCardHolderName(String CardHolderName){
        driver.findElement(cardHolderNameLoc).sendKeys(CardHolderName);
        log.info("type CardHolderName: "+CardHolderName);
        return this;
    }

    public BillingPage clickAddButton(){
        wait.elementToBeClickable(addButtonLoc);
        driver.findElement(addButtonLoc).click();
        return new BillingPage(driver);
    }

    public BillingPage addCard(String CardNumber, String ExpirationMonth, String ExpirationYear, String CardHolderName){
        typeCardNumber(CardNumber)
                .typeExpirationMonth(ExpirationMonth)
                .typeExpirationYear(ExpirationYear)
                .typeCardHolderName(CardHolderName)
                .clickAddButton();
        return new BillingPage(driver);
    }
}
