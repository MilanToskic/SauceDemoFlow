import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShoppingCartTest {

    @BeforeClass
    public void setUpHomepageLogin() {
        FrequentActions.setUpDriver();
        FrequentActions.homepage();
        LogInAndLogOutMain.logInStandardUsername();
        System.out.println("Driver set, Homepage, Logged in with 'standard_username'. ");
    }

    @Test(priority = 5)
    public void verifyUserAddingAndRemovingItems() {
        ShoppingCartMain.AddTwoItemsToCart();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Sauce Labs Backpack"));
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Sauce Labs Fleece Jacket"));

        ShoppingCartMain.RemoveItemOneFromCart();
        Assert.assertFalse(FrequentActions.driver.getPageSource().contains("Sauce Labs Backpack"));
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Sauce Labs Fleece Jacket"));

        ShoppingCartMain.RemoveItemTwoFromCart();
        Assert.assertFalse(FrequentActions.driver.getPageSource().contains("Sauce Labs Backpack"));
        Assert.assertFalse(FrequentActions.driver.getPageSource().contains("Sauce Labs Fleece Jacket"));

        LogInAndLogOutMain.logOut();

        System.out.println("TEST RESULT: Successfully adding and removing items from cart");

    }

    @Test(priority = 6)
    public void verifyTheItemsStayInCartAfterTheUserLogoutAndLogBackIn() {

        LogInAndLogOutMain.logInStandardUsername();
        ShoppingCartMain.AddTwoItemsToCart();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Sauce Labs Backpack"));
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Sauce Labs Fleece Jacket"));

        LogInAndLogOutMain.logOut();
        LogInAndLogOutMain.logInStandardUsername();
        ShoppingCartMain.goToCart();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Sauce Labs Backpack"));
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Sauce Labs Fleece Jacket"));

        ShoppingCartMain.RemoveItemOneFromCart();
        LogInAndLogOutMain.logOut();
        LogInAndLogOutMain.logInStandardUsername();
        ShoppingCartMain.goToCart();
        Assert.assertFalse(FrequentActions.driver.getPageSource().contains("Sauce Labs Backpack"));
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Sauce Labs Fleece Jacket"));

        LogInAndLogOutMain.logOut();

        System.out.println("TEST RESULT: The items are validly recorded in the Cart when the user is logged out and then login again.");

    }

    @Test(priority = 7)
    public void verifyCheckoutStepOneFormIsValid() {
        // FrequentActions.homepage();

        LogInAndLogOutMain.logInStandardUsername();
        ShoppingCartMain.goToCart();

        ShoppingCartMain.checkoutWithoutCreds();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Error: First Name is required"));
        System.out.println("1. CHECKOUT RESULT: User is unable to proceed with the checkout by leaving the input fields empty.");

        ShoppingCartMain.checkoutWithNameOnly();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Error: Last Name is required"));
        System.out.println("2. CHECKOUT RESULT: User is unable to proceed with the checkout with entering 'Name' only.");

        ShoppingCartMain.checkoutWithLastNameOnly();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Error: First Name is required"));
        System.out.println("3. CHECKOUT RESULT: User is unable to proceed with the checkout with entering 'Last Name' only.");

        ShoppingCartMain.checkoutWithPostalCodeOnly();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Error: First Name is required"));
        System.out.println("4. CHECKOUT RESULT: User is unable to proceed with the checkout with entering 'Postal Code' only.");

        ShoppingCartMain.checkoutWithoutName();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Error: First Name is required"));
        System.out.println("5. CHECKOUT RESULT: User is unable to proceed with the checkout with entering 'Last Name' and 'Postal Code' only.");

        ShoppingCartMain.checkoutWithoutLastName();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Error: Last Name is required"));
        System.out.println("6. CHECKOUT RESULT: User is unable to proceed with the checkout with entering 'Name' and 'Postal Code' only.");

        ShoppingCartMain.checkoutWithoutPostalCode();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Error: Postal Code is required"));
        System.out.println("7. CHECKOUT RESULT: User is unable to proceed with the checkout with entering 'Name' and 'Last Name' only.");

        LogInAndLogOutMain.logOut();
    }


    @Test(priority = 8)
    public void verifySuccessfulCheckout() {

        LogInAndLogOutMain.logInStandardUsername();

        ShoppingCartMain.goToCart();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Your Cart"));

        ShoppingCartMain.successfulCheckout();
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Thank you for your order!"));
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Checkout: Complete!"));
        Assert.assertTrue(FrequentActions.driver.getPageSource().contains("Back Home"));
        String URL = FrequentActions.driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.saucedemo.com/checkout-complete.html");
        System.out.println("The URL of the successfully submitted order is: " + URL);

        System.out.println("8. The user can successfully submit an order.");

        LogInAndLogOutMain.logOut();

    }


    @AfterClass
    public void quit() {
        FrequentActions.quit();

    }


}
