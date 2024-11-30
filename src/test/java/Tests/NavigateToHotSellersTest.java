package Tests;

import Pages.HomePage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;


import static DriverBase.DriverBase.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class})
public class NavigateToHotSellersTest {


    @BeforeMethod(alwaysRun = true)
    public void setup() {

        setupDriver(DataUtils.getJsonData("environment", "Browser"));
        LogsUtils.info("Browser was opened");
        getDriver().get(DataUtils.getJsonData("environment", "HOME_URL"));
        LogsUtils.info(" Browser is redirected to the HOME URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test(testName = "Navigate to Hot sellers in Home page", groups = {"Order"})
    @Description("Navigate to Hot sellers in Home page")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("10")
    @Epic("Order")
    @Feature("Navigating")
    @Story("Add to compare list")
    public void navigateToHotSellers() {

        new HomePage(getDriver()).navigateToHotSellerBlock();

        Assert.assertTrue(new HomePage(getDriver()).assertHotSellerBlockIsDisplayed());
        LogsUtils.info("hot sellers are displayed successfully");


    }

    @AfterMethod(alwaysRun = true)

    public void quit() throws IOException {
        quitDriver();
    }
}
