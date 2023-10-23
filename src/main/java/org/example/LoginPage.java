package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailAddressTextField = By.xpath("//label[@for = 'input-email']");
    private By registerSectionFromLoginPage = By.xpath("(//div[@class = 'list-group mb-3']//a)[2]");
    private By loginEmailAddress = By.xpath("//div[@class = 'form-group']//input[@id = 'input-email']");
    private By loginPassword = By.xpath("//div[@class = 'form-group']//input[@id = 'input-password']");
    private By submitButtonLoginPage = By.xpath("//input[@type = 'submit']");
    private By alertTextLogin = By.xpath("//div[@class = 'alert alert-danger alert-dismissible']");
    private By forgottenPasswordButton = By.xpath("//div[@class = 'form-group']//following-sibling::a");
    private By alertSuccessLogin = By.xpath("//div[@class = 'alert alert-success alert-dismissible']");

    public String getTextFromEmailAddressField() {
        return driver.findElement(emailAddressTextField).getText();
    }
    public void clickOnRegisterSectionFromLoginPage() {
        driver.findElement(registerSectionFromLoginPage).click();
    }

    public void insertEmailAddressOnLoginPage(String emailAddressLoginPage) {
        driver.findElement(loginEmailAddress).sendKeys(emailAddressLoginPage);
    }
    public void insertPasswordOnLoginPage(String passwordLoginPage) {
        driver.findElement(loginPassword).sendKeys(passwordLoginPage);
    }
    public void clickOnSubmitButtonFromLogPage() {
        driver.findElement(submitButtonLoginPage).click();
    }
    public String getTextWarningLogin() {
        return driver.findElement(alertTextLogin).getText();
    }
    public void clickOnForgottenPassword() {
        driver.findElement(forgottenPasswordButton).click();
    }
    public String getSuccessMessage() {
        return driver.findElement(alertSuccessLogin).getText();
    }

}
