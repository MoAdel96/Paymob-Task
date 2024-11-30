package Tests;

import Pages.HomePage;
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
public class OpenHomeTest {


    @BeforeMethod(alwaysRun = true)


    public void setup() {

        setupDriver(DataUtils.getJsonData("environment", "Browser"));
        LogsUtils.info("Browser was opened");
        getDriver().get(DataUtils.getJsonData("environment", "HOME_URL"));
        LogsUtils.info(" Browser is redirected to the HOME URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test(testName = "Open Home Page", groups = {"Home"})
    @Description("Opening home page on Edge")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("1")
    @Epic("HomePage")
    @Feature("Opening home page")
    @Story("Home Page")
    public void openHomePage() {
        new HomePage(getDriver());
        Assert.assertTrue(new HomePage(getDriver()).assertHomePageTC(getDriver().getCurrentUrl()));
        LogsUtils.info("Home page is opened successfully");
    }

    @AfterMethod(alwaysRun = true)

    public void quit() throws IOException {
        quitDriver();
    }
}
