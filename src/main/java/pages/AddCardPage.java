package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.FileAssert.fail;

public class AddCardPage extends LoadableComponent<AddCardPage> {
    private WebDriver driver;

    public AddCardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cardNumberLoc = By.xpath("//div[@class='credit-card']/input[@name='number']");
    private By expirationMonthLoc = By.xpath("//div[@class='credit-card']/input[@name='expirationMonth']");
    private By expirationYearLoc = By.xpath("//div[@class='credit-card']/input[@name='expirationYear']");
    private By cardHolderNameLoc = By.xpath("//div[@class='credit-card']/input[@name='cardholderName']");
    private By addButtonLoc = By.xpath("//button[text()='Add']");

    private By openElementLoc=By.xpath("//div[@class='credit-card']");

    @Override
    public void load(){
        driver.get("https://dev.integrivideo.com/app/billing/payment-methods/new");
    }

    @Override
    public void isLoaded() throws Error{
        try {
            (new WebDriverWait(driver, 5))
                    .until(ExpectedConditions.presenceOfElementLocated(openElementLoc));
        } catch (TimeoutException e) {
            fail("Cannot locate openElementLoc of AddCardPage");
        }
    }

    public AddCardPage typeCardNumber(String CardNumber){
        driver.findElement(cardNumberLoc).sendKeys(CardNumber);
        return this;
    }

    public AddCardPage typeExpirationMonth(String ExpirationMonth){
        driver.findElement(expirationMonthLoc).sendKeys(ExpirationMonth);
        return this;
    }

    public AddCardPage typeExpirationYear(String ExpirationYear){
        driver.findElement(expirationYearLoc).sendKeys(ExpirationYear);
        return this;
    }

    public AddCardPage typeCardHolderName(String CardHolderName){
        driver.findElement(cardHolderNameLoc).sendKeys(CardHolderName);
        return this;
    }

    public BillingPage clickAddButton(){
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.elementToBeClickable(addButtonLoc));
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
