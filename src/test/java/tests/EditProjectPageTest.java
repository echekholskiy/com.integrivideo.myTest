package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.EditProjectPage;
import pages.InProjectPage;
import pages.LogInPage;
import pages.ProjectPage;

public class EditProjectPageTest extends BasicPageTest{
    public ProjectPage PP;
    public LogInPage LP;
    public InProjectPage IPP;
    public EditProjectPage EPP;
    public String PN="project1 name";
    public String DES="test1 description";
    public String DOM="test1.by";


    @Before
    public void settings(){
        LP=MP.clickLogIn();
        PP=LP.LogIn(regEmail, regPassword);
        IPP=PP.clickLastOfProject();
        EPP=IPP.clickEditButton();
        EPP.editProject(PN, DES, DOM);
        PP.clickLastOfProject();

    }

    @Test
    public void EditProjectTest(){
        Assert.assertEquals(IPP.getProjectName(), PN);
        Assert.assertEquals(IPP.getDescription(), DES);

    }


}
