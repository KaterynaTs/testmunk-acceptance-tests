package Pages;

import Framework.Driver;

/**
 * Created by katerynat on 09/02/15.
 */
public class BasePage {

    protected Driver driver;

    public BasePage() {
        driver = Driver.getInstance();
        initLocators();
    }

    protected void initLocators() {  }

}