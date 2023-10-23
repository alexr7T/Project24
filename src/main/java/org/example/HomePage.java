package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    private By compareButton = By.id("entry_217823");
    private By wishListButton = By.id("entry_217824");
    private By cartButton = By.id("entry_217825");
    private By editCartButtonFromSidePanel = By.id("entry_217850");
    private By checkoutEditCartButtonFromSidePanel = By.xpath("//div[@id= 'entry_217851']//descendant::a");

    private By searchForProductsBar = By.xpath("//input[@autocomplete = 'off' and contains(@placeholder, 'Search For Products')]");
    private By searchButtonFromHomePage = By.xpath("//button[@class = 'type-text']");

    private By blogSectionNavBar = By.xpath("(//ul[@class = 'navbar-nav horizontal']//li)[3]");
    private By myAccountDropdown = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a");



    public void clickOnCompareButtonFromHomePage() {
        driver.findElement(compareButton).click();
    }
    public void clickOnWishlistButtonFromHomePage() {
        driver.findElement(wishListButton).click();
    }
    public void clickOnCartButtonFromHomePage() {
        driver.findElement(cartButton).click();
    }
    public void clickOnEditCartButtonFromSidePanel() {
        driver.findElement(editCartButtonFromSidePanel).click();
    }
    public void clickOnCheckoutButtonFromSidePanel() {
        driver.findElement(checkoutEditCartButtonFromSidePanel).click();
    }

    public void clickOnSearchBar() {
        driver.findElement(searchForProductsBar).click();
    }

    public void insertProductNameOnSearchBar(String productName) {
        driver.findElement(searchForProductsBar).sendKeys(productName);
    }

    public void clickOnSearchButtonFromSearchBar() {
        driver.findElement(searchButtonFromHomePage).click();
    }

    public void clickOnBlogSectionNavBar() {
        driver.findElement(blogSectionNavBar).click();
    }

    public void clickOnMyAccountDropdown() {
        driver.findElement(myAccountDropdown).click();
    }


}
