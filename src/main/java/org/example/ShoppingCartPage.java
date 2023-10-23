package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage (WebDriver driver) {
        this.driver = driver;
    }

    private By shoppingCartEmptyMessage = By.xpath("//div[@id = 'content']//descendant::p");
    private By shoppingCartContinueButton = By.xpath("//div[@class = 'buttons']//descendant::a");

    public String getEmptyMessageTextFromShoppingCartPage() {
        return driver.findElement(shoppingCartEmptyMessage).getText();
    }
    public void clickOnContinueButtonShoppCart() {
        driver.findElement(shoppingCartContinueButton).click();
    }


}
