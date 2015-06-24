/**
 * Created by katerynat on 26/02/15.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(  monochrome = true,
        features = {"src/test/resources/sign_up.feature"},
        //tags = {"@Now"},
        plugin = { "pretty","html: cucumber-html-reports",
                "json: cucumber-html-reports/cucumber.json" })
public class RunTest {

}