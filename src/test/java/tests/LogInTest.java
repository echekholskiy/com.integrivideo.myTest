package tests;

import org.junit.Test;

public class LogInTest extends BasicTest {

    @Test
    public void LogIn(){
        logInPage.LogIn(regEmail, regPassword);
    }
}
