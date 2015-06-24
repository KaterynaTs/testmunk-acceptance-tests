import Framework.Driver;
import Framework.Locators;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class PreconditionsSteps {

    @Before
    public static void setUp() {
        Locators.loadLocators();
    }

    @After
    public static void tearDown() {
        Driver.stopDriver();
    }
}