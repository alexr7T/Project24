package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductOrderHistoryViewButtonPage extends BasePage{

    public ProductOrderHistoryViewButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    private By tableTextAssert = By.xpath("(//div[@id = 'content']//td[@class = 'text-right'])[2]");
    private By returnButton = By.xpath("(//div[@id = 'content']//td[@class = 'text-right']//a)[2]");

    public String getTablePriceText() {
        return driver.findElement(tableTextAssert).getText();
    }
    public void clickOnReturnButton() {
        driver.findElement(returnButton).click();
    }

}
