package tests;

import data.Data;
import org.junit.Assert;
import org.testng.annotations.Test;

public class CardTest extends BasicTest {

    @Test
    public void addCardTest(){

        projectPage
                .clickBillingButton()
                .isLoaded();

        int sizeOfCardMass=billingPage.getSizeOfCardList();

        billingPage
                .clickAddCardButton()
                .isLoaded();

        addCardPage
                .addCard((new Data()).CARD_NUMBER, new Data().EXPIRATION_MONTH, (new Data()).EXPIRATION_YEAR, (new Data()).CARD_HOLDER_NAME)
                .isLoaded();

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "NUMBER_OF_CARDS"), sizeOfCardMass+1, billingPage.getSizeOfCardList());
        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "CARD_NUMBER"), billingPage.transformationNumber(new Data().CARD_NUMBER), billingPage.getNumberOfLastCard());
    }

    @Test
    public void makeDefaultCardTest(){

        projectPage
                .clickBillingButton()
                .isLoaded();

        billingPage
                .clickAddCardButton()
                .isLoaded();

        addCardPage
                .addCard((new Data()).CARD_NUMBER, new Data().EXPIRATION_MONTH, (new Data()).EXPIRATION_YEAR, (new Data()).CARD_HOLDER_NAME)
                .isLoaded();

        billingPage.clickMakeDefaultButton();

        Assert.assertEquals("No message that the card is defaulted", new Data().DEFAULT_MESSAGE, billingPage.getMessageAlertText());
        Assert.assertTrue(String.format("Card is not default"), billingPage.checkDefaultLastCard());
    }

    @Test
    public void removeCardTest(){

        projectPage
                .clickBillingButton()
                .isLoaded();

        billingPage
                .clickAddCardButton()
                .isLoaded();

        addCardPage
                .addCard((new Data()).CARD_NUMBER, new Data().EXPIRATION_MONTH, (new Data()).EXPIRATION_YEAR, (new Data()).CARD_HOLDER_NAME)
                .isLoaded();

        int numberOfCards=billingPage.getSizeOfCardList();

        billingPage.clickRemoveLastCard();

        Assert.assertEquals("No message that the card is defaulted", new Data().REMOVE_MESSAGE, billingPage.getMessageAlertText());
        Assert.assertEquals("Card is not remove", numberOfCards-1, billingPage.getSizeOfCardList());
    }
}
