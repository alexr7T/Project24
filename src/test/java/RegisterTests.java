import org.example.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import util.TestUtil;

public class RegisterTests {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private CreatedAccountDashboardPage createdAccountDashboardPage;

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
        registerPage = new RegisterPage(driver);
        createdAccountDashboardPage = new CreatedAccountDashboardPage(driver);
    }

    @Test
    public void registerWithoutFirstName() throws InterruptedException{
        homePage.clickOnMyAccountDropdown();
        loginPage.clickOnRegisterSectionFromLoginPage();

        Thread.sleep(5000);
        registerPage.insertLastName("Smith");
        registerPage.insertEMail("mike@gmail.com");
        registerPage.insertTelephone("07441212313");
        registerPage.insertPassword("12345qwerty");
        registerPage.insertPasswordConfirmation("12345qwerty");
        registerPage.clickCheckBoxPrivacyPolicy();
        registerPage.clickOnContinueButton();

        String actualTextFFameMessage = registerPage.getFirstNameMissingFieldText();
        String expectedFNameMessage = "First Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualTextFFameMessage, expectedFNameMessage, "Expected text is different from the actual one!");
        Thread.sleep(5000);
    }

    @Test
    public void checkInvalidPasswordMessage() throws InterruptedException{
        homePage.clickOnMyAccountDropdown();
        loginPage.clickOnRegisterSectionFromLoginPage();

        Thread.sleep(5000);
        registerPage.insertFirstName("John");
        registerPage.insertLastName("Smith");
        registerPage.insertEMail("mike@gmail.com");
        registerPage.insertTelephone("07441212313");
        registerPage.insertPassword("1234qwer");
        registerPage.insertPasswordConfirmation("1234qwerty");
        registerPage.clickCheckBoxPrivacyPolicy();
        registerPage.clickOnContinueButton();

        String actualTextP = registerPage.getInvalidPasswordFieldText();
        String expectedTextP = "Password confirmation does not match password!";
        Assert.assertEquals(actualTextP, expectedTextP, "Expected text is different from the actual one!");
        Thread.sleep(5000);
    }

    @Test
    public void registerWithoutEmail() throws InterruptedException{
        homePage.clickOnMyAccountDropdown();
        loginPage.clickOnRegisterSectionFromLoginPage();

        Thread.sleep(5000);
        registerPage.insertFirstName("John");
        registerPage.insertLastName("Smith");
        registerPage.insertTelephone("07441212313");
        registerPage.insertPassword("1234qwerty");
        registerPage.insertPasswordConfirmation("1234qwerty");
        registerPage.clickCheckBoxPrivacyPolicy();
        registerPage.clickOnContinueButton();

        String actualTextEmlM = registerPage.getEmailMissingFieldText();
        String expectedTextEmlM = "E-Mail Address does not appear to be valid!";
        Assert.assertEquals(actualTextEmlM, expectedTextEmlM, "Expected text is different from the actual one!");
        Thread.sleep(5000);
    }

    @Test
    public void registerIntoAccount() throws InterruptedException{
        homePage.clickOnMyAccountDropdown();
        loginPage.clickOnRegisterSectionFromLoginPage();

        Thread.sleep(5000);
        registerPage.insertFirstName("John");
        registerPage.insertLastName("Smith");
        registerPage.insertEMail(TestUtil.generateRandomEmail());
        registerPage.insertTelephone("07441212313");
        registerPage.insertPassword("1234qwerty");
        registerPage.insertPasswordConfirmation("1234qwerty");
        registerPage.clickCheckBoxPrivacyPolicy();
        registerPage.clickOnContinueButton();

        String actualTextCA = createdAccountDashboardPage.getSuccessMessageTextHeader();
        String expectedCA = "Your Account Has Been Created!";
        Assert.assertEquals(actualTextCA, expectedCA, "Expected text is different from the actual one!");
        Thread.sleep(5000);
        createdAccountDashboardPage.setClickLogout();
    }

    @AfterTest
    public void tearDown() throws InterruptedException{
        driver.quit();
        Thread.sleep(5000);
    }

}
