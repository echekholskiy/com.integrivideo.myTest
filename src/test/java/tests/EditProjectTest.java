package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EditProjectTest extends BasicTest {
    private String PN="project1 name";
    private String DES="test1 description";//TODO перенести в data
    private String DOM="test1.by";


    @Before
    public void settings(){
        LP.LogIn(regEmail, regPassword);
        PP.clickLastOfProject();
        IPP.clickEditButton();
        EPP.editProject(PN, DES, DOM);
        PP.clickLastOfProject();

    }

    @Test
    public void EditProjectTest(){
        Assert.assertEquals(IPP.getProjectName(), PN);
        Assert.assertEquals(IPP.getDescription(), DES);
    }



}
