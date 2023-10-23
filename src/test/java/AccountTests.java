import org.example.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private RegisterPage registerPage;
    private CreatedAccountDashboardPage createdAccountDashboardPage;
    private AccountInformationPage accountInformationPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void BeforeMethod() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        registerPage = new RegisterPage(driver);
        createdAccountDashboardPage = new CreatedAccountDashboardPage(driver);
        accountInformationPage = new AccountInformationPage(driver);
    }

    @Test
    public void editFirstNameAccount() {
        loginPage.insertEmailAddressOnLoginPage("lav@gmail.com");
        loginPage.insertPasswordOnLoginPage("1234");
        loginPage.clickOnSubmitButtonFromLogPage();
        myAccountPage.clickOnEditAccountInfo();
        registerPage.insertFirstName("r");
        registerPage.clickOnContinueButton();

        String actualText = loginPage.getSuccessMessage();
        String expectedText = "Success: Your account has been successfully updated.";
        Assert.assertEquals(actualText, expectedText, "Your account wasn't successfully updated!");
        createdAccountDashboardPage.setClickLogout();
    }

    @Test
    public void checkSuccessMessageIsAbsentBasedOnBackButton() {
        loginPage.insertEmailAddressOnLoginPage("lav@gmail.com");
        loginPage.insertPasswordOnLoginPage("1234");
        loginPage.clickOnSubmitButtonFromLogPage();
        myAccountPage.clickOnEditAccountInfo();
        registerPage.insertLastName("b");
        registerPage.clickOnContinueButton();

        String actualText = loginPage.getSuccessMessage();
        String expectedText = "Success: Your account has been successfully updated.";
        Assert.assertEquals(actualText, expectedText, "Your account wasn't successfully updated!");

        myAccountPage.clickOnEditAccountInfo();
        accountInformationPage.clickOnBackButtonEditAccount();
        Assert.assertFalse(actualText.isEmpty(), "The message must be present only after clicking on Continue button!");
        createdAccountDashboardPage.setClickLogout();
    }

    @Test
    public void checkHeaderFromAccInfo() {
        loginPage.insertEmailAddressOnLoginPage("lav@gmail.com");
        loginPage.insertPasswordOnLoginPage("1234");
        loginPage.clickOnSubmitButtonFromLogPage();
        myAccountPage.clickOnEditAccountInfo();

        String actualTxt = accountInformationPage.getHeaderText();
        String expectedTxt = "My Account Information";
        Assert.assertEquals(actualTxt, expectedTxt, "The header text from expected is different from actual one!");
        createdAccountDashboardPage.setClickLogout();
    }

    @Test
    public void updatePassword() {
        loginPage.insertEmailAddressOnLoginPage("lav@gmail.com");
        loginPage.insertPasswordOnLoginPage("1234");
        loginPage.clickOnSubmitButtonFromLogPage();
        myAccountPage.clickOnPasswordSection();
        registerPage.insertPassword("1234");
        registerPage.insertPasswordConfirmation("1234");
        registerPage.clickOnContinueButton();

        String actualMessage = loginPage.getSuccessMessage();
        String expectedMessage = "Success: Your password has been successfully updated.";
        Assert.assertEquals(actualMessage, expectedMessage, "The password failed to be successfully updated!");
        createdAccountDashboardPage.setClickLogout();
    }

    @Test
    public void verifyInvalidPasswordConfirmMessage() {
        loginPage.insertEmailAddressOnLoginPage("lav@gmail.com");
        loginPage.insertPasswordOnLoginPage("1234");
        loginPage.clickOnSubmitButtonFromLogPage();
        myAccountPage.clickOnPasswordSection();
        registerPage.insertPassword("1234");
        registerPage.insertPasswordConfirmation("12345");
        registerPage.clickOnContinueButton();

        String actualMessage = registerPage.getInvalidPasswordFieldText();
        String expectedTxt = "Password confirmation does not match password!";
        Assert.assertEquals(actualMessage, expectedTxt, "Expected text is different from the actual one!");
        createdAccountDashboardPage.setClickLogout();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
