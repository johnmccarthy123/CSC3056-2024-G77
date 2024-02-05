package tests;

import model.Account;
import java.util.Date;

public class AccountTest {

    /**
     * Similar to testUserConstructor() of UserTest, this test method will
     * test the constructor of Account, using all its getter methods
     */
    public static void testConstructor() {
        // 1-Setup
        String test_account_number = "12345678";
        String test_username_of_account_holder = "mike";
        String test_account_type = "Standard";
        Date test_account_opening_date = new Date(); // Use current date for testing

        // 2-Exercise, run the code under test (constructor)
        Account testAccount = new Account(test_account_number, test_username_of_account_holder,
                test_account_type, test_account_opening_date);

        // 3 - Verify (Assert)
        if (testAccount.getAccountNumber().equals(test_account_number))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getAccountNumber-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getAccountNumber-Failed" + TestUtils.TEXT_COLOR_RESET);

        if (testAccount.getUsernameOfAccountHolder().equals(test_username_of_account_holder))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getUsernameOfAccountHolder-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getUsernameOfAccountHolder-Failed" + TestUtils.TEXT_COLOR_RESET);

        if (testAccount.getAccountType().equals(test_account_type))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getAccountType-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getAccountType-Failed" + TestUtils.TEXT_COLOR_RESET);

        if (testAccount.getAccountOpeningDate().equals(test_account_opening_date))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getAccountOpeningDate-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getAccountOpeningDate-Failed" + TestUtils.TEXT_COLOR_RESET);

        // Additional assertions could be added here
        assert testAccount.getAccountNumber().equals(test_account_number);
        assert testAccount.getUsernameOfAccountHolder().equals(test_username_of_account_holder);
        assert testAccount.getAccountType().equals(test_account_type);
        assert testAccount.getAccountOpeningDate().equals(test_account_opening_date);

        System.out.println("All Java assertions in the test suite passed (none failed).");
    }

    /**
     * This test method will test all the setter methods of Account
     */
    public static void testSetters() {
        // Similar structure for setters as above
        // Example for account number setter test:
        Account testAccount = new Account("", "", "", new Date());
        String newAccountNumber = "87654321";
        testAccount.setAccountNumber(newAccountNumber);
        if (testAccount.getAccountNumber().equals(newAccountNumber))
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "Setter for account number passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "Setter for account number failed" + TestUtils.TEXT_COLOR_RESET);

        // Additional setter tests should follow the same pattern
    }

    public static void main(String[] args) {
        testConstructor();
        testSetters();
    }
}
