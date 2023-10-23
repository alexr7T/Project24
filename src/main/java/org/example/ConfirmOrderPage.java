package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmOrderPage extends BasePage{

    public ConfirmOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private By confirmOrderButton = By.xpath("//div[@class = 'buttons d-flex justify-content-between']//button[@id = 'button-confirm']");

    public void clickOnConfirmOrderButton() {
        driver.findElement(confirmOrderButton). click();
    }

}
