package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchHeaderFromProductPage = By.id("entry_212456");
    private By clickOnProductTitleAfterSearch = By.xpath("(//h4[@class = 'title']//a[@class = 'text-ellipsis-2'])[1]");

    public String getTextFromProductSearchHeader() {
        return driver.findElement(searchHeaderFromProductPage).getText();
    }
    public void clickOnProductTitle() {
        driver.findElement(clickOnProductTitleAfterSearch).click();
    }



}
