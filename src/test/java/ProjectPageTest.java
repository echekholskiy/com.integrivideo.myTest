import org.junit.Before;
import org.junit.Test;

public class ProjectPageTest extends BasicPageTest{
    private ProjectPage PP;
    private LogInPage LP;

    @Before
    public void newObject(){
        LP=MP.clickLogIn();
        PP=LP.LogIn("integriuser2@mailinator.com", "integripassword");
    }

    @Test
    public void clickAddProjectTest(){
        PP.clickAddProject();
    }


}
