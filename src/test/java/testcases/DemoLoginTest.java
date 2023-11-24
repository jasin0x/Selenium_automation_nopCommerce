package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DemoLoginPage;
import pages.LoginPage;
import utilities.DataSet;
import utilities.DriverSetup;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class DemoLoginTest extends DriverSetup {

    @BeforeMethod
    public void navigateToLoginPage(){
        getDriver().get(demoLoginPage.loginUrl);
    }

    @AfterMethod
    public void addScreenShotToReport(){
        
    }
    DemoLoginPage demoLoginPage = new DemoLoginPage();
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void testLoginWithValidCredentials(){

        demoLoginPage.writeOnElement(demoLoginPage.userName,"standard_user");
        demoLoginPage.writeOnElement(demoLoginPage.password,"secret_sauce");
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        demoLoginPage.addScreenShot("After Clicking on the login button");
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }


    @Test
    public void testLoginWithoutPassword(){

        demoLoginPage.writeOnElement(demoLoginPage.userName,"standard_user");
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        demoLoginPage.addScreenShot("After Clicking on the login button");
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.error),"Epic sadface: Password is required");
    }


    @Test
    public void testLoginWithoutCred(){

        demoLoginPage.writeOnElement(demoLoginPage.userName,"");
        demoLoginPage.writeOnElement(demoLoginPage.password,"");
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        demoLoginPage.addScreenShot("After Clicking on the login button");
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.error),"Epic sadface: Username is required");
    }


    @Test
    public void testLoginWithoutUsername(){

        demoLoginPage.writeOnElement(demoLoginPage.userName,"");
        demoLoginPage.writeOnElement(demoLoginPage.password,"secret_sauce");
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        demoLoginPage.addScreenShot("After Clicking on the login button");
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.error),"Epic sadface: Username is required");
    }

    @Test(dataProvider = "invalidCredentials",dataProviderClass = DataSet.class)
    public void testLoginWithoutInvalidCredentials(String username, String password, String error_msg){

        demoLoginPage.writeOnElement(demoLoginPage.userName,username);
        demoLoginPage.writeOnElement(demoLoginPage.password,password);
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
        demoLoginPage.addScreenShot("After Clicking on the login button");
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.error),error_msg);
    }


}
