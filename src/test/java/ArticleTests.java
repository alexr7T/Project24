import org.example.ArticleId37Page;
import org.example.BasePage;
import org.example.BlogArticlesPage;
import org.example.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestUtil;

public class ArticleTests {

    private WebDriver driver;
    private HomePage homePage;
    private BlogArticlesPage blogArticlesPage;
    private ArticleId37Page articleId37Page;
    private String commentForm = "The article was amazing! Very informative and contains outstanding information about products!";
    public TestUtil testUtil;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void BeforeMethod() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        homePage = new HomePage(driver);
        blogArticlesPage = new BlogArticlesPage(driver);
        articleId37Page = new ArticleId37Page(driver);
        testUtil = new TestUtil();
    }

    @Test
    public void postCommentForArticleWithValidationMessage() {
        homePage.clickOnBlogSectionNavBar();
        blogArticlesPage.clickOnTitleFromTheFirstArticle();
        articleId37Page.setFormName("Alexander");
        articleId37Page.setFormEmail("alexander@gmail.com");
        articleId37Page.setFormComment(commentForm);
        articleId37Page.clickOnPostCommentButton();

        testUtil.errorMessageTimerForArticlePage();

        String actualTextArticle = articleId37Page.getTextFormSuccessMessage();
        String expectedTextArticle = "Thank you for your comment. It has been submitted to the webmaster for approval.";
        Assert.assertEquals(actualTextArticle.trim(), expectedTextArticle.trim(), "The text message doesn't correspond with the original!");
    }

    @Test
    public void checkPresenceOfNameWarningMessage() {
        homePage.clickOnBlogSectionNavBar();
        blogArticlesPage.clickOnTitleFromTheFirstArticle();
        articleId37Page.setFormName("Alexanderrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        articleId37Page.setFormEmail("alexander@gmail.com");
        articleId37Page.setFormComment(commentForm);
        articleId37Page.clickOnPostCommentButton();

        testUtil.errorMessageTimerForArticlePage();

        String actualTextErrorArticle = articleId37Page.getTextFromNameErrorForm();
        String expectedTextErrorArticle = "Warning: Comment Name must be between 3 and 25 characters!";
        Assert.assertEquals(actualTextErrorArticle, expectedTextErrorArticle, "Name warning is missing!");
    }

    @Test
    public void checkModuleTitle() {
        homePage.clickOnBlogSectionNavBar();

        String actualTextMTitle = blogArticlesPage.getTextFromArticlesModuleTitle();
        System.out.println("Actual title: " + blogArticlesPage.getTextFromArticlesModuleTitle()); //check whether the title is uppercase or lowercase
        String expectedTextMTitleKeyword = "ARTICLES";
        Assert.assertTrue(actualTextMTitle.contains(expectedTextMTitleKeyword), "Module title does not contain the expected keyword!");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
