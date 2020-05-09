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
    private By DefaultCardLoc=By.xpath("//div[@class='cards']/div[last()]//div[contains(text(),'Default')]");

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

    public boolean clickMakeDefaultButton(){

        try {
            driver.findElement(MakeDefaultButtonLoc).click();//TODO ну это продолжения того пиздец
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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


}
