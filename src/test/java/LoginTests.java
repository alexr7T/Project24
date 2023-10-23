import org.example.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ForgottenPasswordPage forgottenPasswordPage;
    private CreatedAccountDashboardPage createdAccountDashboardPage;
    private LogoutPage logoutPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void BeforeMethod() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        forgottenPasswordPage = new ForgottenPasswordPage(driver);
        createdAccountDashboardPage = new CreatedAccountDashboardPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    @Test
    public void loginWithInvalidEmailOrPassword() {
        homePage.clickOnMyAccountDropdown();
        loginPage.insertEmailAddressOnLoginPage("al@gmail.com");
        loginPage.insertPasswordOnLoginPage("123");
        loginPage.clickOnSubmitButtonFromLogPage();

        String actualTextLog = loginPage.getTextWarningLogin();
        String expectedLogText = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualTextLog, expectedLogText, "Warning message is not the expected one!");
    }

    @Test
    public void checkForgotPasswordPage() {
        homePage.clickOnMyAccountDropdown();
        loginPage.clickOnForgottenPassword();
        forgottenPasswordPage.insertTextOnEmailAddressField("la@gmail.com");
        forgottenPasswordPage.clickOnContinueButtonFromForgottenPasswordPage();

        String actualTextConfirmation = loginPage.getSuccessMessage();
        String expectedText = "An email with a confirmation link has been sent your email address.";
        Assert.assertEquals(actualTextConfirmation, expectedText, "Confirmation message is not the expected one!");
    }

    @Test
    public void loginAndLogout() {
        homePage.clickOnMyAccountDropdown();
        loginPage.insertEmailAddressOnLoginPage("lav@gmail.com");
        loginPage.insertPasswordOnLoginPage("1234");
        loginPage.clickOnSubmitButtonFromLogPage();
        createdAccountDashboardPage.setClickLogout();

        String actualText = logoutPage.getTextFromLogoutMessage();
        String expectedT = "You have been logged off your account. It is now safe to leave the computer.";
        Assert.assertEquals(actualText, expectedT, "Logout expected message is different from actual one!");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
