package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

import static utils.commonMethods.driver;

public class LoginPage extends commonMethods {

    @FindBy(id="txtUsername")
    public WebElement username;

    @FindBy(id="txtPassword")
    public WebElement password;

    @FindBy(xpath = "//input[@id='btnLogin']")
    public WebElement login;

    @FindBy(xpath = "//span[@id='spanMessage']")
    public WebElement error;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
}
