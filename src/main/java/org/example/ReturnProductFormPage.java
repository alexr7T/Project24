package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReturnProductFormPage extends BasePage{

    public ReturnProductFormPage(WebDriver driver) {
        this.driver = driver;
    }

    private By reasonToReturn = By.xpath("//div[@class= 'form-check']//input[@value = '1']");
    private By productIsOpened = By.xpath("(//div[@class = 'form-group row required']//div[@class= 'form-check form-check-inline'])[1]");

    public void checkReasonToReturn() {
        driver.findElement(reasonToReturn).click();
    }
    public void selectYesForQuestion() {
        driver.findElement(productIsOpened).click();
    }

}
