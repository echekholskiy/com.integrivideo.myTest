package data;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

public class Data {
    Faker faker = new Faker();

    public String USER_EMAIL = "integriuser2@mailinator.com";
    public String USER_PASSWORD = "integripassword";
    public String PROJECT_NAME = faker.lebowski().character();
    public String DESCRIPTION = faker.lebowski().quote();
    public String DOMEN = faker.company().url();
    public String VIDEO_CHAT_NAME = "Video Chat";
    public String MULTI_VIDEO_PLAYER_NAME = "Multi-device Video Player";
    public String MULTIPARTY_VIDEO_NAME = "Multiparty Video";
    public String SINGLE_VIDEO_NAME = "Single Video";
    public String CARD_NUMBER = "5555555555554444";
    public String EXPIRATION_MONTH = "12";
    public String EXPIRATION_YEAR = "2021";
    public String CARD_HOLDER_NAME = "EGOR KOMISARUK";
    public String ASSERT_TEXT = "\"Actual value does not match the %s\"";
    public String COMPONENT_NAME=faker.beer().name();
    public String DEFAULT_MESSAGE="Default payment method successfully changed";
    public String REMOVE_MESSAGE="Payment method successfully removed";
}
