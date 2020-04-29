package tests;

import org.junit.Assert;
import org.junit.Test;

public class EditProjectTest extends BasicTest {
    private String PN="project1 name";
    private String DES="test1 description";//TODO перенести в data
    private String DOM="test1.by";

    @Test
    public void EditProjectTest(){
        projectPage.clickLastOfProject();
        inProjectPage.clickEditButton();
        editProjectPage.editProject(PN, DES, DOM);
        projectPage.clickLastOfProject();
        Assert.assertEquals(inProjectPage.getProjectName(), PN);
        Assert.assertEquals(inProjectPage.getDescription(), DES);
    }



}
