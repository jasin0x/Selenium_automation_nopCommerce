package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.DriverSetup;

public class TestHomePage extends DriverSetup {
    HomePage homepage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void testHomePage() throws InterruptedException {
        getDriver().get(homepage.homePageUrl);
        //Thread.sleep(100000);
        Assert.assertEquals(getDriver().getTitle(),homepage.homePageTitle);
    }

    @Test
    public void testHomePageUrl(){
        getDriver().get(homepage.homePageUrl);
        Assert.assertEquals(getDriver().getCurrentUrl(),homepage.homePageUrl);
    }

    @Test
    public void testHomePageRegistration(){
        getDriver().get(homepage.homePageUrl);
        homepage.clickOnElement(homepage.registerButton);
        Assert.assertTrue(homepage.isElementVisible(homepage.registerButton));
        Assert.assertEquals(getDriver().getCurrentUrl(),registrationPage.registrationPageUrl);
    }

    @Test
    public void testHomePageLoginButton(){
        getDriver().get(homepage.homePageUrl);
        homepage.clickOnElement(homepage.loginButton);
        Assert.assertTrue(homepage.isElementVisible(homepage.loginButton));
        Assert.assertEquals(getDriver().getCurrentUrl(),loginPage.loginPageUrl);
    }






}
