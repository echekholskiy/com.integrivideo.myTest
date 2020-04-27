package tests;

import org.junit.Before;
import org.junit.Test;
import pages.InProjectPage;
import pages.LogInPage;
import pages.ProjectPage;

public class InProjectPageTest extends BasicPageTest{
    public ProjectPage PP;
    public LogInPage LP;
    public InProjectPage IPP;

    @Before
    public void settings(){
        LP=MP.clickLogIn();
        PP=LP.LogIn(regEmail, regPassword);
        IPP=PP.clickLastOfProject();
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
