package tests;

import data.Data;
import org.junit.Assert;
import org.testng.annotations.Test;

public class CardTest extends BasicTest {
    @Test
    public void addCardTest(){

        projectPage.clickBillingButton();
        Assert.assertTrue(String.format("Page %s is not opened", "BillingPage"), billingPage.isPageOpened());

        int sizeOfCardMass=billingPage.getSizeOfCardList();

        billingPage.clickAddCardButton();
        Assert.assertTrue(String.format("Page %s is not opened", "AddCardPage"), addCardPage.isPageOpened());//TODO isPageOpened() так реализован?

        addCardPage.addCard((new Data()).CARD_NUMBER, new Data().EXPIRATION_MONTH, (new Data()).EXPIRATION_YEAR, (new Data()).CARD_HOLDER_NAME);
        Assert.assertTrue(String.format("Page %s is not opened", "BillingPage"), billingPage.isPageOpened());

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "NUMBER_OF_CARDS"), sizeOfCardMass+1, billingPage.getSizeOfCardList());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "CARD_NUMBER"), String.format("%.5s", new Data().CARD_NUMBER), billingPage.getNumberOfLastCard());
    }

    @Test
    public void makeDefaultCardTest(){

        projectPage.clickBillingButton();
        Assert.assertTrue(String.format("Page %s is not opened", "BillingPage"), billingPage.isPageOpened());

        billingPage.clickMakeDefaultButton();
        Assert.assertTrue(String.format("Card is not default"), billingPage.checkDefaultCard());

    }

}
