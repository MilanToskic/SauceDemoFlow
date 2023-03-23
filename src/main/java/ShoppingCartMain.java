import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ShoppingCartMain {

    public static void AddTwoItemsToCart() {
        WebElement itemOne = FrequentActions.driver.findElement(By.id("item_4_title_link"));
        itemOne.click();
        WebElement addItemOne = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/button"));
        addItemOne.click();
        WebElement backToProductsButton = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/button"));
        backToProductsButton.click();
        WebElement itemTwo = FrequentActions.driver.findElement(By.id("item_5_img_link"));
        itemTwo.click();
        WebElement addItemTwo = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/button"));
        addItemTwo.click();
        System.out.println("'Sauce Labs Backpack' and 'Sauce Labs Fleece Jacket' added to cart.");
        WebElement goToCart = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a"));
        goToCart.click();
        FrequentActions.waitFor(1);
    }

    public static void RemoveItemOneFromCart() {
        WebElement removeItemOne = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/button"));
        removeItemOne.click();
        FrequentActions.waitFor(1);
        System.out.println("'Sauce Labs Backpack' removed from cart.");
    }

    public static void RemoveItemTwoFromCart() {
        WebElement removeItemTwo = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/div[2]/button"));
        removeItemTwo.click();
        FrequentActions.waitFor(1);
        System.out.println("'Sauce Labs Fleece Jacket' removed from cart.");
    }

    public static void goToCart() {
        WebElement goToCart = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a"));
        goToCart.click();
        FrequentActions.waitFor(1);
    }


    // 1. Invalid Scenario: To continue without entering any values in the required fields.
    public static void checkoutWithoutCreds() {
        WebElement checkoutButton = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[2]"));
        checkoutButton.click();
        WebElement continueButton = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input"));
        continueButton.click();
        FrequentActions.waitFor(1);
    }

    //2. Invalid Scenario: To continue with 'Name' only.
    public static void checkoutWithNameOnly() {
        FrequentActions.driver.get("https://www.saucedemo.com/checkout-step-one.html");
        WebElement nameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input"));
        nameField.sendKeys("NameTest");
        WebElement continueButton = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input"));
        continueButton.click();
        FrequentActions.waitFor(1);
    }

    //3. Invalid Scenario: To continue with 'Last Name' only.
    public static void checkoutWithLastNameOnly() {
        FrequentActions.driver.get("https://www.saucedemo.com/checkout-step-one.html");
        WebElement lastNameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input"));
        lastNameField.sendKeys("SurnameTest");
        WebElement continueButton = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input"));
        continueButton.click();
        FrequentActions.waitFor(1);
    }

    //4. Invalid Scenario: To continue with 'Postal Code' only.
    public static void checkoutWithPostalCodeOnly() {
        FrequentActions.driver.get("https://www.saucedemo.com/checkout-step-one.html");
        WebElement postalCodeField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input"));
        postalCodeField.sendKeys("PostalFieldTest");
        WebElement continueButton = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input"));
        continueButton.click();
        FrequentActions.waitFor(1);

    }

    //5. Invalid Scenario: To continue with 'Last Name' and 'Postal Code' only.
    public static void checkoutWithoutName() {
        FrequentActions.driver.get("https://www.saucedemo.com/checkout-step-one.html");
        WebElement lastNameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input"));
        lastNameField.sendKeys("SurnameTest");
        WebElement postalCodeField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input"));
        postalCodeField.sendKeys("PostalFieldTest");
        WebElement continueButton = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input"));
        continueButton.click();
        FrequentActions.waitFor(1);
    }

    //6. Invalid Scenario: To continue with 'Name' and 'Postal Code' only.
    public static void checkoutWithoutLastName() {
        FrequentActions.driver.get("https://www.saucedemo.com/checkout-step-one.html");
        WebElement nameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input"));
        nameField.sendKeys("NameTest");
        WebElement postalCodeField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input"));
        postalCodeField.sendKeys("PostalFieldTest");
        WebElement continueButton = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input"));
        continueButton.click();
        FrequentActions.waitFor(1);
    }

    //7. Invalid Scenario: To continue with 'Name' and 'Last Name' only.
    public static void checkoutWithoutPostalCode() {
        FrequentActions.driver.get("https://www.saucedemo.com/checkout-step-one.html");
        WebElement nameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input"));
        nameField.sendKeys("NameTest");
        WebElement lastNameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input"));
        lastNameField.sendKeys("SurnameTest");
        WebElement continueButton = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input"));
        continueButton.click();
        FrequentActions.waitFor(1);
    }

    //8. Valid Scenario: Checkout with valid credentials.
    public static void successfulCheckout() {
        WebElement checkoutButton = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[2]"));
        checkoutButton.click();
        WebElement nameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input"));
        nameField.sendKeys("NameTest");
        WebElement lastNameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input"));
        lastNameField.sendKeys("SurnameTest");
        WebElement postalCodeField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input"));
        postalCodeField.sendKeys("PostalFieldTest");
        FrequentActions.waitFor(1);
        WebElement continueButton = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input"));
        continueButton.click();
        WebElement finishButton = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[9]/button[2]"));
        finishButton.click();
        FrequentActions.waitFor(1);

    }

}
