package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogArticlesPage extends BasePage {

    public BlogArticlesPage(WebDriver driver) {
        this.driver = driver;
    }


    private By firstArticleFromBlogArticlesPage = By.xpath("//a[@href = 'https://ecommerce-playground.lambdatest.io/index.php?route=extension/maza/blog/article&article_id=37']");
    private By moduleTitleFromBlogArticlesPage = By.xpath("//h3[text() = 'Latest Articles']");


    //div[@id = 'entry_210960']//h3[@class = 'module-title']
    public void clickOnTitleFromTheFirstArticle() {
        driver.findElement(firstArticleFromBlogArticlesPage).click();
    }
    public String getTextFromArticlesModuleTitle() {
        return driver.findElement(moduleTitleFromBlogArticlesPage).getText();
    }

}
