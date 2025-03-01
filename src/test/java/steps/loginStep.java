package steps;

import Pages.DashboardPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;
import utils.commonMethods;

import java.time.Duration;

public class loginStep extends commonMethods {


    @Given("user ability to access the HRMS application")
    public void user_ability_to_access_the_hrms_application() {


    }
    @When("user enters a valid username and password")
    public void user_enters_a_valid_username_and_password() {
       /* WebElement username= driver.findElement(By.id("txtUsername"));
        WebElement password= driver.findElement(By.id("txtPassword"));
        username.sendKeys("Admin");
        password.sendKeys("Hum@nhrm123");
        */

        sendText(ConfigReader.read("username"), loginPage.username);
        sendText(ConfigReader.read("password"), loginPage.password);


    }
    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        /*WebElement login = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        login.click();
        */
        click(loginPage.login);
    }
    @Then("user should be able to access the application")
    public void user_should_be_able_to_access_the_application() {
      /* WebElement dashboard=driver.findElement(By.xpath("//a[@id='welcome']"));
       String dashB =dashboard.getText();
        Assert.assertEquals("Welcome Admin", dashB);*/
        String dashboardVal=dashboardPage.dashboardtxt.getText();
        Assert.assertEquals("Welcome Admin", dashboardVal);
        System.out.println("Dashboard validation is successful");
    }

    @When("user enters an invalid username and password")
    public void user_enters_an_invalid_username_and_password() {
        /*WebElement username= driver.findElement(By.id("txtUsername"));
        WebElement password= driver.findElement(By.id("txtPassword"));
        username.sendKeys("Addmin");
        password.sendKeys("Hum@nhrm123");*/
        sendText("Addmin", loginPage.username);
        sendText(ConfigReader.read("password"), loginPage.password);
    }

    @Then("user gets an error message {string}")
    public void user_gets_an_error_message(String string) {
        /*WebElement error= driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errorMsg= error.getText();
        Assert.assertEquals("Invalid credentials", errorMsg);*/
       String errorMsg= loginPage.error.getText();
       Assert.assertEquals("Invalid credentials",errorMsg);
        System.out.println("Error message shown");
    }
}
