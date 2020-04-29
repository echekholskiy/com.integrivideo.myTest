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
        projectPage.clickLastOfProject();
        inProjectPage.clickEditButton();
        editProjectPage.editProject(PN, DES, DOM);
        projectPage.clickLastOfProject();

    }

    @Test
    public void EditProjectTest(){
        Assert.assertEquals(inProjectPage.getProjectName(), PN);
        Assert.assertEquals(inProjectPage.getDescription(), DES);
    }



}
