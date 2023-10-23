package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By fieldFirstName = By.xpath("//input[@id = 'input-firstname']");
    private By fieldLastName = By.xpath("//input[@id = 'input-lastname']");
    private By fieldEmail = By.xpath("//input[@id = 'input-email']");
    private By fieldTelephone = By.xpath("//input[@id = 'input-telephone']");
    private By fieldPassword = By.xpath("//input[@id = 'input-password']");
    private By fieldPasswordConfirmation = By.xpath("//input[@id = 'input-confirm']");
    private By checkBoxPrivacyPolicy = By.xpath("//div[@class = 'custom-control custom-checkbox custom-control-inline']//label[@for = 'input-agree']");
    private By registerContinueButton = By.xpath("//input[@type = 'submit']");
    private By missingFirstNameField = By.xpath("//input[@id = 'input-firstname']//following-sibling::div");
    private By missingEmailField = By.xpath("//input[@id = 'input-email']//following-sibling::div");
    private By invalidPassword = By.xpath("//input[@id = 'input-confirm']//following-sibling::div");

    public void insertFirstName(String firstName) {
        driver.findElement(fieldFirstName).sendKeys(firstName);
    }
    public void insertLastName(String lastName) {
        driver.findElement(fieldLastName).sendKeys(lastName);
    }
    public void insertEMail(String eMail) {
        driver.findElement(fieldEmail).sendKeys(eMail);
    }
    public void insertTelephone(String telephone) {
        driver.findElement(fieldTelephone).sendKeys(telephone);
    }
    public void insertPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }
    public void insertPasswordConfirmation(String confirmation) {
        driver.findElement(fieldPasswordConfirmation).sendKeys(confirmation);
    }
    public void clickCheckBoxPrivacyPolicy() {
        driver.findElement(checkBoxPrivacyPolicy).click();
    }
    public void clickOnContinueButton() {
        driver.findElement(registerContinueButton).click();
    }
    public String getFirstNameMissingFieldText() {
        return driver.findElement(missingFirstNameField).getText();
    }
    public String getEmailMissingFieldText() {
        return driver.findElement(missingEmailField).getText();
    }
    public String getInvalidPasswordFieldText() {
        return driver.findElement(invalidPassword).getText();
    }


}
