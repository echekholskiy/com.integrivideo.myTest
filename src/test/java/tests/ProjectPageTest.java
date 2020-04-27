package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LogInPage;
import pages.ProjectPage;

public class ProjectPageTest extends BasicPageTest{
    private ProjectPage PP;
    private LogInPage LP;

    @Before
    public void settings(){
        LP=MP.clickLogIn();
        PP=LP.LogIn(regEmail, regPassword);
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
