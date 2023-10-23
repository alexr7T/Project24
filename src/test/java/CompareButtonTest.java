import org.example.HomePage;
import org.example.ProductComparisonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompareButtonTest {

    private WebDriver driver;
    private HomePage homePage;
    private ProductComparisonPage comparisonPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void BeforeMethod() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        homePage = new HomePage(driver);
        comparisonPage = new ProductComparisonPage(driver);
    }

    @Test
    public void clickOnCompareButton() throws InterruptedException{
        Thread.sleep(600);
        homePage.clickOnCompareButtonFromHomePage();
        Thread.sleep(800);
        String actualText = comparisonPage.getTextFromComparisonPage();
        String expectedText = "You have not chosen any products to compare.";
        Assert.assertEquals(actualText, expectedText, "Incorrect displayed text!");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
