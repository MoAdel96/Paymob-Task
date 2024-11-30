package Tests;

import Pages.HomePage;
import Pages.SignUpPage;
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
public class CreateAccountTest {


    @BeforeMethod(alwaysRun = true)

    public void setup() {

        setupDriver(DataUtils.getJsonData("environment", "Browser"));
        LogsUtils.info("Browser was opened");
        getDriver().get(DataUtils.getJsonData("environment", "HOME_URL"));
        LogsUtils.info(" Browser is redirected to the HOME URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test(testName = "OpenSignUpPage", groups = {"Signup"})
    @Description("Opening SignUp Page")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("2")
    @Epic("Signup")
    @Feature("signup")
    @Story("Auth")
    public void openSignUpPage() {
        //TODO:Go to Signup page
        new HomePage(getDriver()).clickOnCreateAnAccountButton();
        //TODO:Verify that Signup page is opened successfully
        Assert.assertTrue(new SignUpPage(getDriver()).assertSignUpPageTC(getDriver().getCurrentUrl()));
        LogsUtils.info("Signup page is opened successfully");

    }

    @Test(testName = "filling First Name Field", groups = {"Signup"})
    @Description("filling First Name Field")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("3")
    @Epic("Signup")
    @Feature("signup")
    @Story("Auth")
    public void fillingFirstNameField() {
        new SignUpPage(getDriver()).enterFirstName();
        LogsUtils.info("First Name is entered successfully");

    }

    @Test(testName = "filling Last Name Field", groups = {"Signup"})
    @Description("filling Last Name Field")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("4")
    @Epic("Signup")
    @Feature("signup")
    @Story("Auth")
    public void fillingLastNameField() {
        new SignUpPage(getDriver()).enterLastName();
        LogsUtils.info("Last Name is entered successfully");

    }

    @Test(testName = "filling Email Field", groups = {"Signup"})
    @Description("filling Email Field")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("5")
    @Epic("Signup")
    @Feature("signup")
    @Story("Auth")
    public void fillingEmailField() {
        new SignUpPage(getDriver()).enterEmail();
        LogsUtils.info("Email is entered successfully");

    }

    @Test(testName = "filling password Field", groups = {"Signup"})
    @Description("filling Password Field")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("6")
    @Epic("Signup")
    @Feature("signup")
    @Story("Auth")
    public void fillingPasswordField() {
        new SignUpPage(getDriver()).enterPassword();
        LogsUtils.info("Password is entered successfully");

    }

    @Test(testName = "filling  confirm password Field", groups = {"Signup"})
    @Description("filling confirm Password Field")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("7")
    @Epic("Signup")
    @Feature("signup")
    @Story("Auth")
    public void fillingConfirmPasswordField() {
        new SignUpPage(getDriver()).enterConfirmPassword();
        LogsUtils.info("Confirm Password is entered successfully");

    }

    @Test(testName = "click On Create An Account Button", groups = {"Signup"})
    @Description("click On Create An Account Button")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("8")
    @Epic("Signup")
    @Feature("signup")
    @Story("Auth")
    public void clickOnCreateAnAccountButton() {
        new SignUpPage(getDriver()).clickOnCreateButton();
        Assert.assertTrue(new AccountPage(getDriver()).assertSignUpPageTC(getDriver().getCurrentUrl()));

    }

    @Test(testName = "Create An Account", groups = {"Signup"})
    @Description("click On Create An Account Button")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("9")
    @Epic("Signup")
    @Feature("signup")
    @Story("Auth")
    public void createAnAccount() {

        new HomePage(getDriver()).clickOnCreateAnAccountButton().enterFirstName().enterLastName().enterEmail().enterPassword().enterConfirmPassword().clickOnCreateButton();

        Assert.assertTrue(new AccountPage(getDriver()).assertSignUpPageTC(getDriver().getCurrentUrl()));
        LogsUtils.info("Account is created");

    }


    @AfterMethod(alwaysRun = true)

    public void quit() throws IOException {
        quitDriver();
    }
}
