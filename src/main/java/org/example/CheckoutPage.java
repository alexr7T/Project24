package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By preferredPaymentMethodText = By.xpath("//div[@id = 'payment-method']//h4");
    private By checkoutTermsAndConditions = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/div/div[2]/div/div[5]");
    private By checkoutContinueButton = By.xpath("//button[@id = 'button-save']");


    //Checkout Form
    private By paymentFirstName = By.xpath("//input[@id = 'input-payment-firstname']");
    private By paymentLastName = By.xpath("//input[@id = 'input-payment-lastname']");
    private By paymentAddressOne = By.xpath("//input[@id = 'input-payment-address-1']");
    private By paymentAddCity = By.xpath("//input[@id = 'input-payment-city']");
    private By paymentPostCode = By.xpath("//input[@id = 'input-payment-postcode']");
    private By paymentAddRegionState = By.xpath("//select[@id = 'input-payment-zone']//option[11]");




    public String getPreferredPaymentHeaderText() {
        return driver.findElement(preferredPaymentMethodText).getText();
    }
    public void checkTermsAndConditionsBox() {
        driver.findElement(checkoutTermsAndConditions).click();
    }

    public void insertPaymentFirstName(String payFirstName) {
        driver.findElement(paymentFirstName).sendKeys(payFirstName);
    }
    public void insertPaymentLastName(String payLastName) {
        driver.findElement(paymentLastName).sendKeys(payLastName);
    }
    public void insertPaymentAddressOne(String payAddressOne) {
        driver.findElement(paymentAddressOne).sendKeys(payAddressOne);
    }
    public void insertPaymentCity(String payCityName) {
        driver.findElement(paymentAddCity).sendKeys(payCityName);
    }
    public void insertPaymentPostCode(String payPostCodeNumber) {
        driver.findElement(paymentPostCode).sendKeys(payPostCodeNumber);
    }
    public void selectPayRegionOrState() {
        driver.findElement(paymentAddRegionState).click();
    }


    public void clickOnContinueButtonFromCheckoutPage() {
        driver.findElement(checkoutContinueButton).click();
    }

}
