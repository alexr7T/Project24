import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static util.TestUtil.generateRandomEmail;

public class ProductAndOrderHistoryTests {

    private WebDriver driver;
    private RegisterPage registerPage;
    private HomePage homePage;
    private ProductsPage productsPage;
    private ChosenProductPage chosenProductPage;
    private LoginPage loginPage;
    private CreatedAccountDashboardPage createdAccountDashboardPage;
    private CheckoutPage checkoutPage;
    private JavascriptExecutor js;
    private ConfirmOrderPage confirmOrderPage;
    private OrderSuccessfullyProcessedPage orderSuccessfullyProcessedPage;
    private OrderHistorySectionPage orderHistorySectionPage;
    private ProductOrderHistoryViewButtonPage productOrderHistoryViewButtonPage;
    private ReturnProductFormPage returnProductFormPage;
    private SuccessReturnProductPage successReturnProductPage;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void BeforeMethod() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        registerPage = new RegisterPage(driver);
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        chosenProductPage = new ChosenProductPage(driver);
        loginPage = new LoginPage(driver);
        createdAccountDashboardPage = new CreatedAccountDashboardPage(driver);
        checkoutPage = new CheckoutPage(driver);
        js = (JavascriptExecutor)driver;
        confirmOrderPage = new ConfirmOrderPage(driver);
        orderSuccessfullyProcessedPage = new OrderSuccessfullyProcessedPage(driver);
        orderHistorySectionPage = new OrderHistorySectionPage(driver);
        productOrderHistoryViewButtonPage = new ProductOrderHistoryViewButtonPage(driver);
        returnProductFormPage = new ReturnProductFormPage(driver);
        successReturnProductPage = new SuccessReturnProductPage(driver);
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

    public void completeAddressFormForCheckout() {
        checkoutPage.insertPaymentFirstName("Christian");
        checkoutPage.insertPaymentLastName("Brown");
        checkoutPage.insertPaymentAddressOne("Str.London D1");
        checkoutPage.insertPaymentCity("Bristol");
        checkoutPage.insertPaymentPostCode("407869498");
        checkoutPage.selectPayRegionOrState();
    }

    public void fullOrderMethod() throws InterruptedException{
        registerProcess();
        homePage.clickOnSearchBar();
        homePage.insertProductNameOnSearchBar("ipod");
        homePage.clickOnSearchButtonFromSearchBar();
        productsPage.clickOnProductTitle();
        chosenProductPage.clickOnBuyButton();
        Thread.sleep(5000);
        completeAddressFormForCheckout();
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0, 350)","");
        Thread.sleep(2000);

        WebElement checkBox = driver.findElement(By.id("input-agree"));
        Thread.sleep(5000);
        js.executeScript("arguments[0].click();", checkBox);

        checkoutPage.clickOnContinueButtonFromCheckoutPage();
        Thread.sleep(2000);
        confirmOrderPage.clickOnConfirmOrderButton();
        Thread.sleep(4000);
    }

    @Test
    public void checkDescriptionForTheChosenProduct() throws InterruptedException{
        registerProcess();
        homePage.clickOnSearchBar();
        homePage.insertProductNameOnSearchBar("ipod");
        homePage.clickOnSearchButtonFromSearchBar();
        productsPage.clickOnProductTitle();
        js.executeScript("window.scrollBy(0, 350)","");

        Thread.sleep(5000);
        String actualTxt = chosenProductPage.getDescriptionTextFromChosenProduct();
        String expectedTxt = "Revolutionary multi-touch interface.";
        Assert.assertEquals(actualTxt, expectedTxt, "The text description is different from the actual one!");

        js.executeScript("window.scrollBy(0, 0)","");
        Thread.sleep(5000);
        homePage.clickOnMyAccountDropdown();
        createdAccountDashboardPage.setClickLogout();
    }

    @Test
    public void checkTextFromCheckoutPage() throws InterruptedException{
        registerProcess();
        Thread.sleep(2000);
        homePage.clickOnSearchBar();
        homePage.insertProductNameOnSearchBar("ipod");
        homePage.clickOnSearchButtonFromSearchBar();
        productsPage.clickOnProductTitle();
        chosenProductPage.clickOnBuyButton();
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0, 550)","");
        Thread.sleep(5000);
        String actualTxt = checkoutPage.getPreferredPaymentHeaderText();
        String expectedTxt = "Please select the preferred payment method to use on this order.";
        Assert.assertEquals(actualTxt, expectedTxt, "The header text is different from the actual one!");
        homePage.clickOnMyAccountDropdown();
        createdAccountDashboardPage.setClickLogout();
    }

    @Test
    public void completeFullProductOrderWithAssertion() throws InterruptedException{
        Thread.sleep(1000);
        fullOrderMethod();
        Thread.sleep(2000);
        String actualTxt = orderSuccessfullyProcessedPage.getProcessedOrderText();
        String expected = "Your order has been successfully processed!";
        Assert.assertEquals(actualTxt, expected, "The success message doesn't correspond with actual one!");
        homePage.clickOnMyAccountDropdown();
        createdAccountDashboardPage.setClickLogout();
    }

    @Test
    public void checkOrderHistorySection() throws InterruptedException{
        fullOrderMethod();
        orderSuccessfullyProcessedPage.clickOnHistoryLink();

        String actualTxt = orderHistorySectionPage.getTableTitleFromOrderHistoryText();
        String expectedTxt = "Order ID";
        Assert.assertEquals(actualTxt, expectedTxt, "Actual/Expected Table text is invalid!");
        createdAccountDashboardPage.setClickLogout();
    }

    @Test
    public void reachOrderInfoFromViewButton() throws InterruptedException{
        Thread.sleep(1000);
        fullOrderMethod();
        Thread.sleep(2000);
        orderSuccessfullyProcessedPage.clickOnHistoryLink();
        orderHistorySectionPage.clickOnViewOrderInfoButton();

        String actualTxt = productOrderHistoryViewButtonPage.getTablePriceText();
        String expectedTxt = "Price";
        Assert.assertEquals(actualTxt, expectedTxt, "Actual/Expected Table text is invalid!");
        createdAccountDashboardPage.setClickLogout();
    }

    @Test
    public void returnOrderedProduct() throws InterruptedException{
        Thread.sleep(1000);
        fullOrderMethod();
        Thread.sleep(2000);
        orderSuccessfullyProcessedPage.clickOnHistoryLink();
        orderHistorySectionPage.clickOnViewOrderInfoButton();
        productOrderHistoryViewButtonPage.clickOnReturnButton();
        Thread.sleep(8000);
        returnProductFormPage.checkReasonToReturn();
        Thread.sleep(8000);
        returnProductFormPage.selectYesForQuestion();
        Thread.sleep(8000);
        js.executeScript("window.scrollBy(0, 550)","");
        Thread.sleep(8000);
        registerPage.clickOnContinueButton();

        Thread.sleep(8000);
        String actualTxt = successReturnProductPage.getTextFromSuccessReturnMessage();
        String expectedTxt = "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.";
        Thread.sleep(4000);
        Assert.assertEquals(actualTxt, expectedTxt, "Actual text is different from expected!");
        createdAccountDashboardPage.setClickLogout();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
