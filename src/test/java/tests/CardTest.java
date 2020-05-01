package tests;

import org.junit.Test;

public class CardTest extends BasicTest {
    @Test
    public void test(){
        projectPage
                .clickBillingButton()
                .clickAddCardButton()
                .addCard("5555555555554444", "12", "2021", "EGOR KOMISARUK");

    }

    @Test
    public void test1(){
        projectPage
                .clickBillingButton()
                .clickAddCardButton()
                .clickAddButton();
    }
}
