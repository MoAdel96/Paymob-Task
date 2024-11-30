package Pages;

import Utilities.Utility;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class HomePage {
    private final WebDriver driver;
    private final By CreateAnAccountButton = By.xpath("//div[@class='panel header']//ul[@class='header links']//a[text()='Create an Account']");
    private final By hotSellersBlock = By.xpath("//div[contains(@class,'block widget block-products-list grid')]");
    private final By firstProduct = By.xpath("//ol[@class='product-items widget-product-grid']/li[1]");
    private final By secondProduct = By.xpath("//ol[@class='product-items widget-product-grid']/li[2]");
    private final By addToCompareList1Button = By.xpath("//ol[@class='product-items widget-product-grid']/li[1]/div/div/div[4]/div/div[2]/a[2]");
    private final By addToCompareList2Button = By.xpath("//ol[@class='product-items widget-product-grid']/li[2]/div/div/div[4]/div/div[2]/a[2]");
    private final By addingToCompareListMSG = By.xpath("//div[contains(text(),'You added product')]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO:Actions:
    public SignUpPage clickOnCreateAnAccountButton() {
        Utility.clickingOnElement(driver, CreateAnAccountButton);
        return new SignUpPage(driver);
    }
    public HomePage navigateToHotSellerBlock (){
        Utility.scrolling(driver,hotSellersBlock);
        return this;
    }
    public HomePage clickOnAddFirstProductToCompList(){
        Utility.hoverOverElement(driver,firstProduct);
        Utility.waitForLocator(driver,addToCompareList1Button);
        Utility.clickingOnElement(driver,addToCompareList1Button);
        return new HomePage(driver);
    }
    public HomePage clickOnAddSecondProductToCompList(){
        Utility.hoverOverElement(driver,secondProduct);
        Utility.waitForLocator(driver,addToCompareList2Button);
        Utility.clickingOnElement(driver,addToCompareList2Button);
        return new HomePage(driver);
    }

    //TODO:Assertions:
    public Boolean assertHomePageTC(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }
    public Boolean assertHotSellerBlockIsDisplayed(){
        return driver.findElement(hotSellersBlock).isDisplayed();
    }
    public Boolean assertAddingMsgIsDisplayed(){
        return driver.findElement(addingToCompareListMSG).isDisplayed();
    }



}
