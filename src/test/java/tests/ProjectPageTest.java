package tests;

import org.junit.Before;
import org.junit.Test;

public class ProjectPageTest extends BasicPageTest{

    @Before
    public void settings(){
        LP.LogIn(regEmail, regPassword);
    }

    @Test
    public void clickAddProjectTest(){
        PP.clickAddProject();
    }
    @Test
    public void clickLastOfProjectTest(){
        PP.clickLastOfProject();
    }


}
