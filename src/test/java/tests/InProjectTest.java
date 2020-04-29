package tests;

import org.junit.Before;
import org.junit.Test;

public class InProjectTest extends BasicTest {
    @Before
    public void settings(){
        projectPage.clickLastOfProject();
    }
    @Test
    public void clickEdit(){
        inProjectPage.clickEditButton();
    }
    @Test
    public void clickNewComponent(){
        inProjectPage.clickAddComponentButton();
    }
}
