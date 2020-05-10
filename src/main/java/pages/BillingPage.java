package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingPage {
    private WebDriver driver;

    public BillingPage(WebDriver driver) {
        this.driver = driver;
    }
    private By addCardButtonLoc = By.xpath("//div[@class='col-md-6']/a[@class='btn']");
    private By lastCardNumberLoc = By.xpath("//div[@class='cards']/div[last()]/div[@class='col-md-7']");
    private By cardMassLoc = By.xpath("//div[@class='col-md-7']");
    private By MakeDefaultButtonLoc=By.xpath("//div[@class='cards']/div[last()]//a[text()='Make default']");
    private By removeButtonLoc=By.xpath("//div[@class='cards']/div[last()]//a[text()='Remove']");
    private By DefaultCardLoc=By.xpath("//div[@class='cards']/div[last()]//div[contains(text(),'Default')]");
    private By messageAlertLoc=By.xpath("//span[@data-notify='message']");
    private By listOfCards=By.xpath("//div[@class='cards']/div");

    private By openElementLoc = By.xpath("//h3[text()='Payment methods']");

    public BillingPage isBillingPageOpened(){
        try {
            (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(openElementLoc));
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("BillingPage is not opened!");

            return null;
        }
    }

    public AddCardPage clickAddCardButton(){
        driver.findElement(addCardButtonLoc).click();

        return new AddCardPage(driver);
    }

    public String getNumberOfLastCard(){
        return String.format("%.5s", driver.findElement(lastCardNumberLoc).getText());
    }

    public int getSizeOfCardList(){
        return driver.findElements(cardMassLoc).size();
    }

    public BillingPage clickMakeDefaultButton(){
        driver.findElement(MakeDefaultButtonLoc).click();

        return this;
    }

    public boolean checkDefaultCard() {

        try {
            driver.findElement(DefaultCardLoc);
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

    public BillingPage clickRemoveCard(){
        driver.findElement(removeButtonLoc).click();

        return this;
    }

    public int getNumberOfCard(){
        return driver.findElements(listOfCards).size();
    }
}
