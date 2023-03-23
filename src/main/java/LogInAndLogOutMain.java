import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LogInAndLogOutMain {

    //1. Invalid Scenario: click Login without entering Username and/or Password.
    public static void loginWithoutCreds() {

        WebElement clickLoginBtn = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input"));
        clickLoginBtn.click();
        FrequentActions.waitFor(1);

    }

    //2. Invalid Scenario: The Username field is empty and only the Password field has valid credentials.
    public static void loginWithValidPassOnly() {

        WebElement passField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input"));
        passField.sendKeys("secret_sauce");
        FrequentActions.waitFor(1);
        WebElement clickLoginBtn = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input"));
        clickLoginBtn.click();
        FrequentActions.waitFor(1);
    }

    //3. Invalid Scenario: The Username is invalid, the Password is correct.
    public static void loginWithInvalidUsernameAndValidPass() {
        WebElement usernameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input"));
        usernameField.sendKeys("Test1");
        WebElement passField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input"));
        passField.sendKeys("secret_sauce");
        WebElement clickLoginBtn = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input"));
        clickLoginBtn.click();
        FrequentActions.waitFor(1);

    }

    //4. Invalid Scenario: The Username is valid, the Password is not.
    public static void loginWithValidUsernameAndInvalidPass() {

        WebElement usernameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input"));
        usernameField.sendKeys("standard_user");
        WebElement passField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input"));
        passField.sendKeys("invalidPass");
        WebElement clickLoginBtn = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input"));
        clickLoginBtn.click();
        FrequentActions.waitFor(1);

    }

    //5. Invalid Scenario: The Username has valid creds, the Password field is empty.
    public static void loginWithValidUsernameOnly() {
        WebElement usernameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input"));
        usernameField.sendKeys("standard_user");
        WebElement clickLoginBtn = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input"));
        clickLoginBtn.click();
        FrequentActions.waitFor(1);
    }

    //6. Invalid Scenario: The Username and Password credentials are both invalid.
    public static void loginWithInvalidCredentials() {
        WebElement usernameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input"));
        usernameField.sendKeys("Test2");
        WebElement passField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input"));
        passField.sendKeys("AsdDSA#@#()#()()@(*xcamlk1124");
        WebElement clickLoginBtn = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input"));
        clickLoginBtn.click();
        FrequentActions.waitFor(1);

    }

    //1. Valid Scenario: Login with valid credentials. The Username is "standard_user".
    public static void logInStandardUsername() {
        WebElement usernameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input"));
        usernameField.sendKeys("standard_user");
        WebElement passField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input"));
        passField.sendKeys("secret_sauce");
        WebElement clickLoginBtn = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input"));
        clickLoginBtn.click();
        FrequentActions.waitFor(1);


    }

    //2. Valid Scenario: Login with "problem_user".
    public static void logInProblemUser() {
        WebElement usernameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input"));
        usernameField.sendKeys("problem_user");
        WebElement passField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input"));
        passField.sendKeys("secret_sauce");
        WebElement clickLoginBtn = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input"));
        clickLoginBtn.click();
        WebElement clickOnCart = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a"));
        clickOnCart.click();
        WebElement checkOutBtn = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[2]"));
        checkOutBtn.click();
        WebElement firstNameInput = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input"));
        firstNameInput.sendKeys("Malcolm");
        WebElement lastNameInput = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input"));
        lastNameInput.sendKeys("X");
        WebElement zipCodeInput = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input"));
        zipCodeInput.sendKeys("123456");
        WebElement continueBtn = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input"));
        continueBtn.click();
        FrequentActions.waitFor(1);

    }

    //3. Valid Scenario: Login with "locked_out_user".
    public static void logInLockedOutUser() {
        WebElement usernameField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input"));
        usernameField.sendKeys("locked_out_user");
        WebElement passField = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input"));
        passField.sendKeys("secret_sauce");
        WebElement clickLoginBtn = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input"));
        clickLoginBtn.click();
        FrequentActions.waitFor(1);

    }

    // Log out
    public static void logOut() {
        WebElement clickBurgerMenu = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[1]/div/button"));
        clickBurgerMenu.click();
        WebElement logOutBtn = FrequentActions.driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[3]"));
        logOutBtn.click();
        FrequentActions.waitFor(1);

    }


}


