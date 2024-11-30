package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private final WebDriver driver;
    private final By logoButton =By.cssSelector("[class='logo']");

    public AccountPage(WebDriver driver) {
        this.driver=driver;
    }

    public Boolean assertSignUpPageTC(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }
    public void clickOnLogo (){
        Utility.clickingOnElement(driver,logoButton);
        new HomePage(driver);
    }
}
