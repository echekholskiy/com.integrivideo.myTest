package tests;

import org.junit.Before;
import org.junit.Test;

public class InProjectTest extends BasicTest {
    @Before
    public void settings(){
        LP.LogIn(regEmail, regPassword);
        PP.clickLastOfProject();
    }
    @Test
    public void clickEdit(){
        IPP.clickEditButton();
    }
    @Test
    public void clickNewComponent(){
        IPP.clickAddComponentButton();
    }
}
