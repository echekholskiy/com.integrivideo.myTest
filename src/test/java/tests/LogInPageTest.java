package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LogInPage;

public class LogInPageTest extends BasicPageTest {
    private LogInPage LP;
    @Before
    public void settings(){
        LP=MP.clickLogIn();
    }
    @Test
    public void LogIn(){
        LP.typeEmail(regEmail).typePassword(regPassword).clickLoginButton();
    }
}
