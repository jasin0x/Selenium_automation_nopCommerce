package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    public String loginPageUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
    public String loginPageTitle = "nopCommerce demo store.Login ";
    public By email = By.id("Email");
    public By password = By.id("Password");
    public By rememberCheckbox = By.id("RememberMe");
    public By loginButton = By.xpath("//button[normalize-space()='Log in']");
    public By forgetPass = By.xpath("//a[normalize-space()='Forgot password?']");


}
