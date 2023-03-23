import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginLogoutTest {

    @BeforeClass
    public void setUpAndHomepage() {
        FrequentActions.setUpDriver();
        FrequentActions.homepage();

    }

    @Test(priority = 5)
    public void loginWithoutCreds() {
        LogInAndLogOutMain.loginWithoutCreds();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Epic sadface: Username is required"));
        FrequentActions.homepage();
        System.out.println("1. Invalid Scenario: PASS");
    }

    @Test(priority = 6)
    public void loginWithValidPassOnly() {
        LogInAndLogOutMain.loginWithValidPassOnly();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Epic sadface: Username is required"));
        FrequentActions.homepage();
        System.out.println("2. Invalid Scenario: PASS");
    }

    @Test(priority = 7)
    public void loginWithInvalidUsernameAndValidPass() {
        LogInAndLogOutMain.loginWithInvalidUsernameAndValidPass();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Epic sadface: Username and password do not match any user in this service"));
        FrequentActions.homepage();
        System.out.println("3. Invalid Scenario: PASS");
    }

    @Test(priority = 8)
    public void loginWithValidUsernameAndInvalidPass() {
        LogInAndLogOutMain.loginWithValidUsernameAndInvalidPass();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Epic sadface: Username and password do not match any user in this service"));
        FrequentActions.homepage();
        System.out.println("4. Invalid Scenario: PASS");
    }

    @Test(priority = 8)
    public void loginWithValidUsernameAndPasswordFieldEmpty() {
        LogInAndLogOutMain.loginWithValidUsernameOnly();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Epic sadface: Password is required"));
        FrequentActions.homepage();
        System.out.println("5. Invalid Scenario: PASS");
    }

    @Test(priority = 9)
    public void loginWithInvalidCreds() {
        LogInAndLogOutMain.loginWithInvalidCredentials();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Epic sadface: Username and password do not match any user in this service"));
        FrequentActions.homepage();
        System.out.println("6. Invalid Scenario: PASS");
    }

    @Test(priority = 10)
    public void loginWithStandardUser() {
        LogInAndLogOutMain.logInStandardUsername();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Products"));
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Name (A to Z)"));
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains(" Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"));
        System.out.println("7. Valid Scenario(Standard User): PASS");

    }

    @Test(priority = 11)
    public void logOutStandardUser() {
        FrequentActions.homepage();
        LogInAndLogOutMain.logInStandardUsername();
        LogInAndLogOutMain.logOut();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Accepted usernames are:"));
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Password for all users:"));
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("locked_out_user"));
        System.out.println("8. Log out 'Standard User': PASS");
    }

    @Test(priority = 12)
    public void loginAndLogoutWithProblemUser() {
        FrequentActions.homepage();
        LogInAndLogOutMain.logInProblemUser();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Error: Last Name is required"));
        LogInAndLogOutMain.logOut();
        System.out.println("9. Login and Logout 'Problem User': PASS");
    }

    @Test(priority = 13)
    public void loginLockedOutUser() {
        FrequentActions.homepage();
        LogInAndLogOutMain.logInLockedOutUser();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Epic sadface: Sorry, this user has been locked out."));
        System.out.println("9. Login 'Locked Out User': PASS");

    }

    @AfterClass
    public void quit() {
        FrequentActions.quit();
        System.out.println("End of Login/Logout flow");

    }

}
