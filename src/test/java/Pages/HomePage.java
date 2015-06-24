package Pages;

import Framework.Locators;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class HomePage extends BasePage {

    private HashMap<String,String> btnSignUp;

    public HomePage () {
        super();
    }

    protected void initLocators() {
        btnSignUp = Locators.get("btnSignUp");
    }

    public void waitPageLoaded() {
        WebElement btnSignUp = driver.getElement(this.btnSignUp);
        Assert.assertNotNull("Wait for btnSignUp on Home page failed", btnSignUp);
    }

    public void clickSignUpButton() {
        WebElement btnSignUp = driver.getButton(this.btnSignUp);
        btnSignUp.click();
    }

}