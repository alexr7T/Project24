package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage{

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logoutMessage = By.xpath("//div[@id = 'content']//following-sibling::p[2]");

    public String getTextFromLogoutMessage() {
        return driver.findElement(logoutMessage).getText();
    }

}
