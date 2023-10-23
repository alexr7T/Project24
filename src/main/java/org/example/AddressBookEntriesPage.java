package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressBookEntriesPage extends BasePage{

    public AddressBookEntriesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By newAddressButton = By.xpath("//div[@class = 'float-right']");
    private By editAddress = By.xpath("//td[@class = 'text-right p-3']//a[1]");
    private By deleteButtonAddress = By.xpath("//td[@class = 'text-right p-3']//a[2]");
    private By warningMessageAfterClickingOnDelete = By.xpath("//div[@class = 'alert alert-warning']");

    public void clickOnNewAddressButton() {
        driver.findElement(newAddressButton).click();
    }
    public void clickOnEditButtonFromTheCreatedAddress() {
        driver.findElement(editAddress).click();
    }
    public void clickOnDeleteButtonFromTheCreatedAddress() {
        driver.findElement(deleteButtonAddress).click();
    }
    public String getTextFromWarningMessageDelete() {
        return driver.findElement(warningMessageAfterClickingOnDelete).getText();
    }

}
