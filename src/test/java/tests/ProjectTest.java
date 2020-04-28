package tests;

import org.junit.Before;
import org.junit.Test;

public class ProjectTest extends BasicTest {

    @Before
    public void settings(){
        logInPage.LogIn(regEmail, regPassword);
    }

    @Test
    public void clickAddProjectTest(){
        projectPage.clickAddProject();
    }
    @Test
    public void clickLastOfProjectTest(){
        projectPage.clickLastOfProject();
    }


}
