package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistorySectionPage extends BasePage{

    public OrderHistorySectionPage(WebDriver driver) {
        this.driver = driver;
    }

    private By tableTile = By.xpath("//div[@id = 'content']//tr//td[1]");
    private By viewOrderInfo = By.xpath("//td[@class = 'text-right']//a");

    public String getTableTitleFromOrderHistoryText() {
        return driver.findElement(tableTile).getText();
    }
    public void clickOnViewOrderInfoButton() {
        driver.findElement(viewOrderInfo).click();
    }

}
