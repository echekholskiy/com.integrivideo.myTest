package tests;

import org.junit.Before;
import org.junit.Test;

public class LogInPageTest extends BasicPageTest {

    @Test
    public void LogIn(){
        LP.LogIn(regEmail, regPassword);
    }
}
