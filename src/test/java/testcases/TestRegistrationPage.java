package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utilities.DriverSetup;

public class TestRegistrationPage extends DriverSetup {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void testUserRegistrationProcess(){
//        getDriver().get(registrationPage.registrationPageUrl);
//        registrationPage.clickOnElement(registrationPage.genderMale);
//        registrationPage.writeOnElement(registrationPage.firstName, "MD");
//        registrationPage.writeOnElement(registrationPage.lastName, "Karim");
//        registrationPage.selectWithVisibleText(registrationPage.dobDay, "5");
//        registrationPage.selectWithVisibleText(registrationPage.dobMonth, "July");
//        registrationPage.selectWithVisibleText(registrationPage.dobYear, "2000");
//        registrationPage.writeOnElement(registrationPage.email, "murgii@email.com");
//        registrationPage.writeOnElement(registrationPage.companyName, "XYZ");
//        registrationPage.writeOnElement(registrationPage.password, "12345A");
//        registrationPage.writeOnElement(registrationPage.confirmPassword, "12345A");
//        registrationPage.clickOnElement(registrationPage.registerBtn);

        registrationPage.registerUser();
        Assert.assertTrue(registrationPage.isElementVisible(registrationPage.registrationConfirmation));
        Assert.assertEquals(registrationPage.getElementText(registrationPage.registrationConfirmation),registrationPage.registrationConfirmationTxt);
    }


//    @Test
//    public void testRegistrationPage() throws InterruptedException {
//        getDriver().get(regPage.registrationPageUrl);
//        Select select = new Select(regPage.dayDropdown);
//        select.selectByIndex(3);
//        Thread.sleep(3000);
//    }



//    @Test
//    public void testRegistrationPage_2() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
//        WebElement drop = driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"));
//        Select select = new Select(drop);
//        select.selectByIndex(3);
//        Thread.sleep(3000);
//    }



}
