package util;

import java.util.Random;

public class TestUtil {

    public void errorMessageTimerForArticlePage() {
        try {
            Thread.sleep(8000); //test will wait 8 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String generateRandomEmail() {
        Random random = new Random();
        String email = "mike" + random.nextLong() + "@gmail.com";
        System.out.println("Used email is: " + email);
        return email;
    }

    /*
    OBSERVATIONS:
    1)
    My Account Information:
    - First Name
    - Last Name
    - E-mail
    - Telephone
    Password:
    - Password
    - Password Confirm
    All mentioned fields can be tested through RegisterPage elements,
    as the locators are the same, including Continue button!

    2)
    Alert success message can be used from LoginPage!

    3)
    Address Book Header can be identified based on Account Information Page!

    4)
    FirstName & LastName from AddAddressPage can be used from Register!
    */


}
