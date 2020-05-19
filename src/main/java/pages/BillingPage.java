package pages;

import data.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.FileAssert.fail;

public class BillingPage extends LoadableComponent<BillingPage> {

    private WebDriver driver;

    public BillingPage(WebDriver driver) {
        this.driver = driver;
    }
    private By addCardButtonLoc = By.xpath("//div[@class='col-md-6']/a[@class='btn']");
    private By lastCardNumberLoc = By.xpath("//div[@class='cards']/div[last()]/div[@class='col-md-7']");
    private By cardMassLoc = By.xpath("//div[@class='col-md-7']");
    private By MakeDefaultLastCardButtonLoc=By.xpath("//div[@class='cards']/div[last()]//a[text()='Make default']");
    private By removeLastCardButtonLoc=By.xpath("//div[@class='cards']/div[last()]//a[text()='Remove']");
    private By DefaultLastCardLoc=By.xpath("//div[@class='cards']/div[last()]//div[contains(text(),'Default')]");
    private By messageAlertLoc=By.xpath("//span[@data-notify='message']");
    private By listOfCards=By.xpath("//div[@class='cards']/div");

    private By openElementLoc = By.xpath("//h3[text()='Payment methods']");

    @Override
    public void load(){
        driver.get("https://dev.integrivideo.com/app/billing");
    }

    @Override
    public void isLoaded() throws Error{
        try {
            (new WebDriverWait(driver, 5))
                    .until(ExpectedConditions.presenceOfElementLocated(openElementLoc));
        } catch (TimeoutException e) {
            fail("Cannot locate openElementLoc of BillingPage");
        }
    }

    public AddCardPage clickAddCardButton(){
        driver.findElement(addCardButtonLoc).click();

        return new AddCardPage(driver);
    }

    public String getNumberOfLastCard(){
        return driver.findElement(lastCardNumberLoc).getText().substring(0, 16);
    }

    public int getSizeOfCardList(){
        return driver.findElements(cardMassLoc).size();
    }

    public BillingPage clickMakeDefaultButton(){
        driver.findElement(MakeDefaultLastCardButtonLoc).click();

        return this;
    }

    public boolean checkDefaultLastCard() {

        try {
            driver.findElement(DefaultLastCardLoc);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getMessageAlertText(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(messageAlertLoc));

        return driver.findElement(messageAlertLoc).getText();
    }

    public BillingPage clickRemoveLastCard(){
        driver.findElement(removeLastCardButtonLoc).click();

        return this;
    }

    public int getNumberOfCard(){
        return driver.findElements(listOfCards).size();
    }

    public String transformationNumber(String Number){
        return Number.substring(0, 6)+new Data().STARS_FOR_CARD_NUMBER+Number.substring(12, 16);
    }

}
