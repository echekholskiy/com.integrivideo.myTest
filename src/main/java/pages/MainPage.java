package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    //TODO private надо, используем только внутри этого класса
    private WebDriver driver;

    //TODO Не обязательно дробить все так как это сделано на сайте все окна итд.
    // Делаем чтобы нам было удобно, Надо обьединить эту страницу с LoginPage и тока LP пусть будет
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO Где модификатор доступа? private
    By loginButton=By.xpath("//a[@class='btn']");


    public LogInPage clickLogIn(){
        driver.findElement(loginButton).click();
        return new LogInPage(driver);
    }

}
