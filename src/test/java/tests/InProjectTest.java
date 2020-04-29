package tests;

import org.junit.Test;

public class InProjectTest extends BasicTest {

    @Test
    public void clickEdit(){
        projectPage.clickLastOfProject();
        inProjectPage.clickEditButton();
    }
    @Test
    public void clickNewComponent(){
        projectPage.clickLastOfProject();
        inProjectPage.clickAddComponentButton();
    }
}
