package tests;

import model.User;

public class UserTest {

    public static void main(String[] args) {
        testUserConstructor();
    }

    public static void testUserConstructor() {
        // move all the test code of User Constructor from the main() to this method
        // 1-Setup
        String test_username = "mike";
        String test_password = "my_passw0rd";
        String test_first_name = "Mike";
        String test_last_name = "Smith";
        String test_mobile_number = "07771234567";

        // 2-Exercise, run the code under test (constructor)
        User testUser = new User(test_username, test_password, test_first_name,
                test_last_name, test_mobile_number);

        // 3 - Verify (Assert)
        if (testUser.getUsername()==(test_username))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-Failed" + TestUtils.TEXT_COLOR_RESET);

        if (testUser.getPassword()==(test_password))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getPassword-Failed" + TestUtils.TEXT_COLOR_RESET);

        // Verify first name
        if (testUser.getFirst_name()==(test_first_name))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getFirst_name-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getFirst_name-Failed" + TestUtils.TEXT_COLOR_RESET);

        // Verify last name
        if (testUser.getLast_name()==(test_last_name))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getLast_name-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getLast_name-Failed" + TestUtils.TEXT_COLOR_RESET);

        // Verify mobile number
        if (testUser.getMobile_number()==(test_mobile_number))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC5-getMobile_number-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC5-getMobile_number-Failed" + TestUtils.TEXT_COLOR_RESET);
    }
    
}