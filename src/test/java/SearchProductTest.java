import org.example.HomePage;
import org.example.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTest {

    private WebDriver driver;
    private HomePage homePage;
    private ProductsPage productsPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void BeforeMethod() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void searchProduct() throws InterruptedException{
        homePage.clickOnSearchBar();
        homePage.insertProductNameOnSearchBar("mac");
        homePage.clickOnSearchButtonFromSearchBar();
        Thread.sleep(500);
        String actualTextSearch = productsPage.getTextFromProductSearchHeader();
        String expectedText = "Search - mac";
        Assert.assertEquals(actualTextSearch, expectedText, "Text doesn't match with the original one!");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
