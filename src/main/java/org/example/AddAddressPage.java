package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddAddressPage extends BasePage{

    public AddAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addAddressOne = By.xpath("//input[@id = 'input-address-1']");
    private By addCity = By.xpath("//input[@id = 'input-city']");
    private By addPostCode = By.xpath("//input[@id = 'input-postcode']");
    private By addRegionState = By.xpath("//select[@id = 'input-zone']//option[11]");

    public void insertAddressOne(String AddressOne) {
        driver.findElement(addAddressOne).sendKeys(AddressOne);
    }
    public void insertCity(String cityName) {
        driver.findElement(addCity).sendKeys(cityName);
    }
    public void insertPostCode(String postCodeNumber) {
        driver.findElement(addPostCode).sendKeys(postCodeNumber);
    }
    public void selectRegionOrState() {
        driver.findElement(addRegionState).click();
    }


}
