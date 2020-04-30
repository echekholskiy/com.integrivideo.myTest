package data;

import com.github.javafaker.Faker;

public class Data {
    Faker faker=new Faker();

    public String USER_EMAIL="integriuser2@mailinator.com";
    public String USER_PASSWORD="integripassword";
    public String PROJECT_NAME=faker.lebowski().character();
    public String DESCRIPTION=faker.lebowski().quote();
    public String DOMEN=faker.company().url();
    public String VIDEO_CHAT_NAME="Video Chat";
    public String MULTI_VIDEO_PLAYER_NAME="Multi-device Video Player";
    public String MULTIPARTY_VIDEO_NAME="Multiparty Video";
    public String SINGLE_VIDEO_NAME="Single Video";
}
