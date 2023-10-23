package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessReturnProductPage extends BasePage{

    public SuccessReturnProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private By successMessageRet = By.xpath("//*[@id=\"content\"]/p[2]");

    public String getTextFromSuccessReturnMessage() {
        return driver.findElement(successMessageRet).getText();
    }

}
