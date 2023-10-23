package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreatedAccountDashboardPage extends BasePage{

    public CreatedAccountDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By successMessageAfterCreatingAccount = By.xpath("//div[@id = 'content']//h1[@class = 'page-title my-3']");
    private By clickLogout = By.xpath("(//div[@class = 'list-group mb-3']//a)[14]");
    private By addressBook = By.xpath("(//div[@class = 'list-group mb-3']//a)[4]");


    public String getSuccessMessageTextHeader() {
        return driver.findElement(successMessageAfterCreatingAccount).getText();
    }
    public void setClickLogout() {
        driver.findElement(clickLogout).click();
    }
    public void clickOnAddressBookSection() {
        driver.findElement(addressBook).click();
    }

}
