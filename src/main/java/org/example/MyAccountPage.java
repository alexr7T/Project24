package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By editAccountInformation = By.xpath("(//div[@class = 'row']//div)[5]");
    private By passwordSection = By.xpath("(//div[@class = 'row']//div)[6]");

    public void clickOnEditAccountInfo() {
        driver.findElement(editAccountInformation).click();
    }
    public void clickOnPasswordSection() {
        driver.findElement(passwordSection).click();
    }

}
