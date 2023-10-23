package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChosenProductPage extends BasePage{
    public ChosenProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private By descriptionTitleProduct = By.xpath("(//div[@id = 'mz-design-tab-216814-0']//p//strong)[1]");
    private By buyButton = By.xpath("//div[@id = 'entry_216843']//button[@type = 'button']");

    public String getDescriptionTextFromChosenProduct() {
        return driver.findElement(descriptionTitleProduct).getText();
    }
    public void clickOnBuyButton() {
        driver.findElement(buyButton).click();
    }

}
