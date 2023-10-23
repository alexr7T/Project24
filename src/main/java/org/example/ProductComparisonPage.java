package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductComparisonPage extends BasePage{

    public ProductComparisonPage(WebDriver driver) {
        this.driver = driver;
    }

    private By compareProductComparisonText = By.xpath("//p[text() = 'You have not chosen any products to compare.']");

    public String getTextFromComparisonPage() {
        return driver.findElement(compareProductComparisonText).getText();
    }

}
