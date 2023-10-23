package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSuccessfullyProcessedPage extends BasePage{

    public OrderSuccessfullyProcessedPage(WebDriver driver) {
        this.driver = driver;
    }

    private By processedOrderMessage = By.xpath("//div[@id = 'content']//p[2]");
    private By historyOrderLink = By.xpath("//div[@id = 'content']//p[3]//a[2]");

    public String getProcessedOrderText() {
        return driver.findElement(processedOrderMessage).getText();
    }
    public void clickOnHistoryLink() {
        driver.findElement(historyOrderLink).click();
    }

}
