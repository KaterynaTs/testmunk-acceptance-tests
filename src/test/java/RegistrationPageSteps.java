import Pages.DashboardPage;
import Pages.RegistrationPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by katerynat on 26/05/15.
 */
public class RegistrationPageSteps {
    @Then("^I fill registration fields$")
    public void I_fill_registration_fields() throws Throwable {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.fillRegistrationFields();
    }

    @And("^Tap on Sign Up button$")
    public void Tap_on_Sign_Up_button() throws Throwable {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickSignUpNowButton();
    }

    @When("^I am on Dashboard Page$")
    public void I_am_on_Dashboard_Page() throws Throwable {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitForDashboardTitle();
    }

    @Then("^I close Getting Started modal window$")
    public void I_close_Getting_Started_modal_window() throws Throwable {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.closeGettingStartedWindow();
    }
}
