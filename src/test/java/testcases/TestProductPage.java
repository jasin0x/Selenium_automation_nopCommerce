package testcases;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoLoginPage;
import pages.DemoProductPage;
import utilities.DriverSetup;

public class TestProductPage extends DriverSetup {

    DemoLoginPage demoLoginPage = new DemoLoginPage();
    DemoProductPage demoProductPage = new DemoProductPage();

    @BeforeMethod
    public void navigateToProductPage(){
        getDriver().get(demoLoginPage.loginUrl);
        demoLoginPage.doLogin("standard_user","secret_sauce");
    }

    @Test(description = "Test product page Add to cart button")
    @Description("Allure Description Test product page Add to cart button")
    public void testAddTCartButton(){
        demoProductPage.clickOnElement(demoProductPage.addToCaryButton);
        demoProductPage.addScreenShot("Add product to cart");
        Assert.assertEquals(demoProductPage.getCurrentItemCount(),"1");
    }


    @Test
    public void testRemoveTCartItemButton(){
        //demoProductPage.clickOnElement(demoProductPage.addToCaryButton);
        demoProductPage.clickOnElement(demoProductPage.removeCartItemButton);
        demoProductPage.addScreenShot("Remove product from cart");
        Assert.assertTrue(demoProductPage.isElementVisible(demoProductPage.addToCaryButton));
        Assert.assertFalse(demoProductPage.isElementVisible(demoProductPage.removeCartItemButton));
    }

}
