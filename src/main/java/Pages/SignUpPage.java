package Pages;

import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private final WebDriver driver;
    private final By firstNameField =By.id("firstname");
    private final By latNameField =By.id("lastname");
    private final By emailField =By.id("email_address");
    private final By passwordField =By.cssSelector("[name='password'][id='password']");
    private final By confirmPasswordField =By.cssSelector("[name='password_confirmation']");
    private final By createAccountButton =By.xpath("//button[contains(@class,'action submit primary')]");




    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO:Actions:

    //TODO: Entering Personal Information:

    public SignUpPage enterFirstName() {
        Utility.sendData(driver,firstNameField,DataUtils.getData("SignUpInfo", "PersonalInformation.FirstName") + Utility.getTimeStamp());
        return this;

    }
    public SignUpPage enterLastName() {
        Utility.sendData(driver,latNameField,DataUtils.getData("SignUpInfo", "PersonalInformation.LastName")+ Utility.getTimeStamp());
        return this;

    }
    //TODO: Entering Sign-in Information:

    public SignUpPage enterEmail() {
        Utility.sendData(driver,emailField,DataUtils.getData("SignUpInfo", "SignINInformation.Email")+ Utility.getTimeStamp()+ "@gmail.com");
        return this;

    }
    public SignUpPage enterPassword() {
        Utility.sendData(driver,passwordField,DataUtils.getData("SignUpInfo", "SignINInformation.Password"));
        return this;

    }
    public SignUpPage enterConfirmPassword() {
        Utility.sendData(driver,confirmPasswordField,DataUtils.getData("SignUpInfo", "SignINInformation.Password"));
        return this;

    }
    //TODO: Submit Button:
    public AccountPage clickOnCreateButton() {
       Utility.clickingOnElement(driver,createAccountButton);
        return new AccountPage(driver);

    }





    //TODO:Assertions:
    public Boolean assertSignUpPageTC(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }





}
