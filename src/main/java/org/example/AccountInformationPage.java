package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountInformationPage extends BasePage{

    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By backButtonFromEditAccount = By.xpath("//div[@class = 'float-left']");
    private By headerText = By.xpath("//h1[@class = 'page-title h3 mb-3']");

    public void clickOnBackButtonEditAccount() {
        driver.findElement(backButtonFromEditAccount).click();
    }
    public String getHeaderText() {
        return driver.findElement(headerText).getText();
    }

}
