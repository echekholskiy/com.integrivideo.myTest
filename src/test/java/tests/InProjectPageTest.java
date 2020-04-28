package tests;

import org.junit.Before;
import org.junit.Test;
import pages.InProjectPage;
import pages.LogInPage;
import pages.ProjectPage;

public class InProjectPageTest extends BasicPageTest{
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
