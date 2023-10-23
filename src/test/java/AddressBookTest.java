import org.example.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import static util.TestUtil.generateRandomEmail;


public class AddressBookTest {
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private CreatedAccountDashboardPage createdAccountDashboardPage;
    private AccountInformationPage accountInformationPage;
    private AddressBookEntriesPage addressBookEntriesPage;
    private AddAddressPage addAddressPage;


    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        createdAccountDashboardPage = new CreatedAccountDashboardPage(driver);
        accountInformationPage = new AccountInformationPage(driver);
        addressBookEntriesPage = new AddressBookEntriesPage(driver);
        addAddressPage = new AddAddressPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        driver.manage().window().maximize();
    }

    public void registerProcess() {
        homePage = new HomePage(driver);
        homePage.clickOnMyAccountDropdown();
        loginPage.clickOnRegisterSectionFromLoginPage();
        registerPage.insertFirstName("John");
        registerPage.insertLastName("Smith");
        registerPage.insertEMail(generateRandomEmail());
        registerPage.insertTelephone("07441212313");
        registerPage.insertPassword("1234qwerty");
        registerPage.insertPasswordConfirmation("1234qwerty");
        registerPage.clickCheckBoxPrivacyPolicy();
        registerPage.clickOnContinueButton();
    }

    public void completeAddressForm() {
        registerPage.insertFirstName("Tom");
        registerPage.insertLastName("Evans");
        addAddressPage.insertAddressOne("Str.Cambridge 25");
        addAddressPage.insertCity("Bristol");
        addAddressPage.insertPostCode("0577123");
        addAddressPage.selectRegionOrState();
        addressBookEntriesPage.clickOnNewAddressButton();
    }

    @Test
    public void checkAddressBookHeader() throws InterruptedException{
        registerProcess();
        Thread.sleep(5000);
        createdAccountDashboardPage.clickOnAddressBookSection();

        Thread.sleep(5000);
        String actualHeaderTxt = accountInformationPage.getHeaderText();
        String expectedTxt = "Address Book Entries";
        Assert.assertEquals(actualHeaderTxt, expectedTxt, "Expected text is different from the actual one!");
        createdAccountDashboardPage.setClickLogout();
    }

    @Test
    public void addNewAddress() throws InterruptedException{
        registerProcess();
        createdAccountDashboardPage.clickOnAddressBookSection();
        addressBookEntriesPage.clickOnNewAddressButton();
        Thread.sleep(5000);

        completeAddressForm();
        Thread.sleep(5000);

        String actualTxt = loginPage.getSuccessMessage();
        String expectedMessage = "Your address has been successfully added";
        Assert.assertEquals(actualTxt, expectedMessage, "Expected text is different from the actual one!");
        createdAccountDashboardPage.setClickLogout();
    }

    @Test
    public void editCreatedAddressBook() throws InterruptedException{
        registerProcess();
        createdAccountDashboardPage.clickOnAddressBookSection();
        addressBookEntriesPage.clickOnNewAddressButton();

        Thread.sleep(5000);
        completeAddressForm();

        addressBookEntriesPage.clickOnEditButtonFromTheCreatedAddress();
        Thread.sleep(8000);
        registerPage.insertFirstName("additionalText");
        registerPage.clickOnContinueButton();

        Thread.sleep(8000);
        String actualTxt = loginPage.getSuccessMessage();
        String expectedMessage = "Your address has been successfully updated";
        Assert.assertEquals(actualTxt, expectedMessage, "Expected text is different from the actual one!");
        createdAccountDashboardPage.setClickLogout();
    }

    @Test
    public void verifyDeleteButtonAddressBook() throws InterruptedException{
        registerProcess();
        createdAccountDashboardPage.clickOnAddressBookSection();
        addressBookEntriesPage.clickOnNewAddressButton();

        Thread.sleep(5000);
        completeAddressForm();
        addressBookEntriesPage.clickOnDeleteButtonFromTheCreatedAddress();

        Thread.sleep(8000);
        String actualTxt = addressBookEntriesPage.getTextFromWarningMessageDelete();
        String expectedTxt = "Warning: You must have at least one address!";
        Assert.assertEquals(actualTxt, expectedTxt, "Expected text is different from the actual one!");
        createdAccountDashboardPage.setClickLogout();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
