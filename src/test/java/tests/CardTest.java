package tests;

import data.Data;
import org.junit.Assert;
import org.junit.Test;

public class CardTest extends BasicTest {
    @Test
    public void test(){
        projectPage
                .clickBillingButton()
                .clickAddCardButton()
                .addCard((new Data()).CARD_NUMBER, new Data().EXPIRATION_MONTH, (new Data()).EXPIRATION_YEAR, (new Data()).CARD_HOLDER_NAME);

        Assert.assertEquals(String.format(new Data().ASSERT_TEXT, "CARD_NUMBER"), String.format("%.5s", new Data().CARD_NUMBER), billingPage.getNumberOfLastCard());//TODO обсудить: или лучше чекнуть
                                                                                                              // количество блоков до и после добавления карты?
    }

}
