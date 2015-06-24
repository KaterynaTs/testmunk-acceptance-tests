package Pages;

import Framework.Locators;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class DashboardPage extends BasePage {

    private HashMap<String,String> mdlGettingStarted;
    private HashMap<String,String> btnClose;
    private HashMap<String,String> lblBreadcrumbTitle;

    public DashboardPage() {
        super();
    }

    protected void initLocators() {
        mdlGettingStarted = Locators.get("mdlGettingStarted");
        btnClose = Locators.get("btnClose");
        lblBreadcrumbTitle = Locators.get("lblBreadcrumbTitle");
    }

    public void closeGettingStartedWindow() {
        WebElement mdlGettingStarted = driver.getElement(this.mdlGettingStarted);
        Assert.assertNotNull("Wait for GettingStarted modal on Dashboard page failed", mdlGettingStarted);

        WebElement btnClose = driver.getElement(this.btnClose);
        btnClose.click();
    }

    public void waitForDashboardTitle() {
        WebElement lblBreadcrumbTitle = driver.getElement(this.lblBreadcrumbTitle);
        String actualValue = lblBreadcrumbTitle.getText();
        Assert.assertEquals("Wait for Dashboard title failed", "Dashboard", actualValue);
    }

}