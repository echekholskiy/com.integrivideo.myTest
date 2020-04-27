import org.junit.Before;
import org.junit.Test;

public class ProjectPageTest extends BasicPageTest{
    private ProjectPage PP;
    private LogInPage LP;

    @Before
    public void settings(){
        LP=MP.clickLogIn();
        PP=LP.LogIn("integriuser2@mailinator.com", "integripassword");
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
