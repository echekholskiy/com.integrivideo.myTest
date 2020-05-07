package tests;

import data.Data;
import org.junit.Assert;
import org.testng.annotations.Test;

public class CardTest extends BasicTest {
    @Test
    public void test(){
        projectPage.clickBillingButton();
        Assert.assertTrue(String.format("Page %s is not opened", "BillingPage"), billingPage.isPageOpened());

        billingPage.clickAddCardButton();
        Assert.assertTrue(String.format("Page %s is not opened", "AddCardPage"), addCardPage.isPageOpened());//TODO isPageOpened() так реализован?

        addCardPage.addCard((new Data()).CARD_NUMBER, new Data().EXPIRATION_MONTH, (new Data()).EXPIRATION_YEAR, (new Data()).CARD_HOLDER_NAME);
        Assert.assertTrue(String.format("Page %s is not opened", "BillingPage"), billingPage.isPageOpened());

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "CARD_NUMBER"), String.format("%.5s", new Data().CARD_NUMBER), billingPage.getNumberOfLastCard());
    }

}
