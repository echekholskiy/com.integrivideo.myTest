package tests;

import data.Data;
import org.junit.Assert;
import org.testng.annotations.Test;

public class CardTest extends BasicTest {
    @Test
    public void addCardTest(){

        projectPage
                .clickBillingButton()
                .isBillingPageOpened();

        int sizeOfCardMass=billingPage.getSizeOfCardList();

        billingPage
                .clickAddCardButton()
                .isAddCardPageOpened()
                .addCard((new Data()).CARD_NUMBER, new Data().EXPIRATION_MONTH, (new Data()).EXPIRATION_YEAR, (new Data()).CARD_HOLDER_NAME);

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "NUMBER_OF_CARDS"), sizeOfCardMass+1, billingPage.getSizeOfCardList());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "CARD_NUMBER"), String.format("%.5s", new Data().CARD_NUMBER), billingPage.getNumberOfLastCard());
    }

    @Test
    public void makeDefaultCardTest(){

        projectPage
                .clickBillingButton()
                .isBillingPageOpened()
                .clickAddCardButton()
                .isAddCardPageOpened()
                .addCard((new Data()).CARD_NUMBER, new Data().EXPIRATION_MONTH, (new Data()).EXPIRATION_YEAR, (new Data()).CARD_HOLDER_NAME)
                .isBillingPageOpened()
                .clickMakeDefaultButton();

        Assert.assertEquals("No message that the card is defaulted", new Data().DEFAULT_MESSAGE, billingPage.getDefaultAlertText());
        Assert.assertTrue(String.format("Card is not default"), billingPage.checkDefaultCard());
    }
}
