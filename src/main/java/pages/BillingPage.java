package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillingPage {
    private WebDriver driver;

    public BillingPage(WebDriver driver) {
        this.driver = driver;
    }
    private By addCardButtonLoc=By.xpath("//div[@class='col-md-6']/a[@class='btn']");
    private By lastCardNumberLoc=By.xpath("//div[@class='col-md-7']");

    public AddCardPage clickAddCardButton(){
        driver.findElement(addCardButtonLoc).click();
        return new AddCardPage(driver);
    }

    public String getNumberOfLastCard(){
        return String.format("%.5s", driver.findElement(lastCardNumberLoc).getText());
    }
}
