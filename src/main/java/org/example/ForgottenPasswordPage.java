package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgottenPasswordPage extends BasePage{

    public ForgottenPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailAddressFieldForgottenPass = By.xpath("//input[@id = 'input-email']");
    private By continueButtonForgottenPass = By.xpath("//div[@class = 'float-right']//button[@type = 'submit']");

    public void insertTextOnEmailAddressField(String emailAddressTextForgottenPassword) {
        driver.findElement(emailAddressFieldForgottenPass).sendKeys(emailAddressTextForgottenPassword);
    }
    public void clickOnContinueButtonFromForgottenPasswordPage() {
        driver.findElement(continueButtonForgottenPass).click();
    }

}
