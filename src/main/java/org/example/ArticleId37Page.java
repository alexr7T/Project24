package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticleId37Page extends BasePage{

    public ArticleId37Page(WebDriver driver) {
        this.driver = driver;
    }

    private By formName = By.id("input-name");
    private By formEmail = By.id("input-email");
    private By formComment = By.id("input-comment");
    private By formPostComment = By.id("button-comment");
    private By formSuccessMessage = By.xpath("/html/body/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/div[9]/form/div[1]");
    private By invalidNameErrorCharacters = By.xpath("//div[@class = 'form-group required']//div[text() = 'Warning: Comment Name must be between 3 and 25 characters!']");


    public void setFormName(String nameField) {
        driver.findElement(formName).sendKeys(nameField);
    }
    public void setFormEmail(String emailField) {
        driver.findElement(formEmail).sendKeys(emailField);
    }
    public void setFormComment(String commentField) {
        driver.findElement(formComment).sendKeys(commentField);
    }
    public void clickOnPostCommentButton() {
        driver.findElement(formPostComment).click();
    }
    public String getTextFormSuccessMessage() {
        return driver.findElement(formSuccessMessage).getText();
    }
    public String getTextFromNameErrorForm() {
        return driver.findElement(invalidNameErrorCharacters).getText();
    }


}
