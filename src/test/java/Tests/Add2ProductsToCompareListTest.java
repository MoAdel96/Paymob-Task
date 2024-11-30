package Tests;

import Pages.HomePage;
import Pages.AccountPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;

import java.io.IOException;
import java.time.Duration;

import static DriverBase.DriverBase.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;


@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class})
public class Add2ProductsToCompareListTest {
    @BeforeMethod(alwaysRun = true)

    public void setup() {

        setupDriver(DataUtils.getJsonData("environment", "Browser"));
        LogsUtils.info("Browser was opened");
        getDriver().get(DataUtils.getJsonData("environment", "HOME_URL"));
        LogsUtils.info(" Browser is redirected to the HOME URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test(testName = "add First Product To Compare List", groups = {"Order"})
    @Description("add First Product To Compare List")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("11")
    @Epic("Order")
    @Feature("adding products to compare list")
    @Story("Add to compare list")
    public void addFirstProductToCompareList() {
        new HomePage(getDriver()).navigateToHotSellerBlock().clickOnAddFirstProductToCompList();
        Assert.assertTrue(new HomePage(getDriver()).assertAddingMsgIsDisplayed());
        LogsUtils.info("the product is added to compare list");

    }

    @Test(testName = "add Second Product To Compare List", groups = {"Order"})
    @Description("add Second Product To Compare List")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("12")
    @Epic("Order")
    @Feature("adding products to compare list")
    @Story("Add to compare list")
    public void addSecondProductToCompareList() {
        new HomePage(getDriver()).navigateToHotSellerBlock().clickOnAddSecondProductToCompList();
        Assert.assertTrue(new HomePage(getDriver()).assertAddingMsgIsDisplayed());
        LogsUtils.info("the product is added to compare list");

    }


    @Test(testName = "add two Products To Compare List", groups = {"Order"})
    @Description("add two Products To Compare List")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("13")
    @Epic("Order")
    @Feature("adding products to compare list")
    @Story("Add to compare list")
    public void addTwoProductsToCompareList() {
        //TODO: Creating a new account
        new HomePage(getDriver()).clickOnCreateAnAccountButton().enterFirstName().enterLastName().enterEmail().enterPassword().enterConfirmPassword().clickOnCreateButton();
        //TODO:Verify that the account is created successfully
        Assert.assertTrue(new AccountPage(getDriver()).assertSignUpPageTC(getDriver().getCurrentUrl()));
        LogsUtils.info("Account is created");
        //TODO: Go to home page
        new AccountPage(getDriver()).clickOnLogo();
        //TODO: Adding 2 products to compare list
        new HomePage(getDriver()).navigateToHotSellerBlock().clickOnAddFirstProductToCompList().navigateToHotSellerBlock().clickOnAddSecondProductToCompList();
        //TODO:Verify that the products are added successfully
        Assert.assertTrue(new HomePage(getDriver()).assertAddingMsgIsDisplayed());
        LogsUtils.info("the product is added to compare list");

    }


    @AfterMethod(alwaysRun = true)

    public void quit() throws IOException {
        quitDriver();
    }
}
