package pages;

import org.openqa.selenium.By;

public class DemoLoginPage extends BasePage{

    public String loginUrl = "https://www.saucedemo.com/";
    public By userName = By.cssSelector("#user-name");
    public By password = By.cssSelector("#password");
    public By loginButton = By.cssSelector("#login-button");
    public By error = By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]");
    public void doLogin(String username_text, String password_text){
        writeOnElement(userName,username_text);
        writeOnElement(password,password_text);
        clickOnElement(loginButton);
    }

}
