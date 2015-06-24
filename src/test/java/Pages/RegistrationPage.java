package Pages;

import Framework.Locators;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.UUID;

public class RegistrationPage extends BasePage {

    private HashMap<String,String> edtFullName;
    private HashMap<String,String> edtEmail;
    private HashMap<String,String> edtPassword;
    private HashMap<String,String> edtOrganisation;
    private HashMap<String,String> btnSignUpNow;

    public RegistrationPage() {
        super();
    }

    protected void initLocators() {
        edtFullName = Locators.get("edtFullName");
        edtPassword = Locators.get("edtPassword");
        edtEmail = Locators.get("edtEmail");
        edtOrganisation = Locators.get("edtOrganisation");
        btnSignUpNow = Locators.get("btnSignUpNow");
    }

    public void waitPageLoaded() {
        WebElement btnSignUpNow = driver.getElement(this.btnSignUpNow);
        WebElement edtEmail = driver.getElement(this.edtEmail);
        WebElement edtPassword = driver.getElement(this.edtOrganisation);
        WebElement edtOrganisation = driver.getElement(this.btnSignUpNow);

        Assert.assertNotNull("Wait for Registration page failed", btnSignUpNow);
        Assert.assertNotNull("Wait for Registration page failed", edtEmail);
        Assert.assertNotNull("Wait for Registration page failed", edtPassword);
        Assert.assertNotNull("Wait for Registration page failed", edtOrganisation);
    }

    public static String getRandomString() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 7);
    }

    public void fillRegistrationFields() {
        String random = getRandomString();
        WebElement edtFullName = driver.getButton(this.edtFullName);
        edtFullName.sendKeys("Kateryna");
        WebElement edtEmail = driver.getButton(this.edtEmail);
        edtEmail.sendKeys("kateryna" + random + "@testmunk.com");
        WebElement edtPassword = driver.getButton(this.edtPassword);
        edtPassword.sendKeys("Passw0rd");
        WebElement edtOrganisation = driver.getButton(this.edtOrganisation);
        edtOrganisation.sendKeys(random);
    }

    public void clickSignUpNowButton() {
        WebElement btnSignUpNow = driver.getButton(this.btnSignUpNow);
        btnSignUpNow.click();
    }

}