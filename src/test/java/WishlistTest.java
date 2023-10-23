import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishlistTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void BeforeMethod() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void reachLoginPageFromWishlistButton() {
        homePage.clickOnWishlistButtonFromHomePage();

        String actualTextL = loginPage.getTextFromEmailAddressField();
        String expectedTextL = "E-Mail Address";
        Assert.assertEquals(actualTextL, expectedTextL, "The text doesn't match with the actual one!");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
