package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

public class DashboardPage extends commonMethods {

    @FindBy(id="welcome")
    public static WebElement dashboardtxt;

    public DashboardPage(){
        PageFactory.initElements(driver, this);
    }
}
