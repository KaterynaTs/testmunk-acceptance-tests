import Pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class HomePageSteps {

    @Given("^I am on Home page$")
    public void I_am_on_Home_page() throws Throwable {
        HomePage homePage = new HomePage();
        homePage.waitPageLoaded();
    }

    @When("^I click Sign Up button$")
    public void I_click_Sign_Up_button() throws Throwable {
        HomePage homePage = new HomePage();
        homePage.clickSignUpButton();
    }
}
