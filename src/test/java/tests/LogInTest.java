package tests;

import org.junit.Test;

public class LogInTest extends BasicTest {

    @Test
    public void LogIn(){
        LP.LogIn(regEmail, regPassword);
    }
}
