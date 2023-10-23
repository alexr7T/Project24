import org.example.HomePage;
import org.example.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartTests {

    private WebDriver driver;
    private HomePage homePage;
    private ShoppingCartPage shoppingCartPage;



    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void BeforeMethod() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        homePage = new HomePage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Test
    public void editCartFromCartButton() throws InterruptedException{
        Thread.sleep(500);
        homePage.clickOnCartButtonFromHomePage();
        Thread.sleep(500);
        homePage.clickOnEditCartButtonFromSidePanel();
        Thread.sleep(500);
        String actualTextC = shoppingCartPage.getEmptyMessageTextFromShoppingCartPage();
        String expectedTextC = "Your shopping cart is empty!";
        Assert.assertEquals(actualTextC, expectedTextC, "The text is incorrect!");
    }

    @Test
    public void reachHomePageAfterClickingOnContinueButtonCheckout() throws InterruptedException{
        homePage.clickOnCartButtonFromHomePage();
        Thread.sleep(200);
        homePage.clickOnCheckoutButtonFromSidePanel();
        shoppingCartPage.clickOnContinueButtonShoppCart();

        String currentURL = driver.getCurrentUrl();
        String expectedTextInURL = "home";
        assert currentURL.contains(expectedTextInURL) : "The URL does not contain 'home' word";
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
