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

    private By openElementLoc = By.xpath("//h3[text()='Payment methods']");

    public boolean isPageOpened(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(openElementLoc));
        if(driver.findElements(openElementLoc).size()!=0) {
            return true;
        }
        else return false;
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

    public boolean checkDefaultCard(){
        if(driver.findElement(MakeDefaultButtonLoc).getText() == "Default"){
            return true;
        }
        else return false;
    }
}
