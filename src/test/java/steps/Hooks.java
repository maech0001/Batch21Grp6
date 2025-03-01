package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.commonMethods;

import java.io.IOException;
import java.time.Duration;

public class Hooks extends commonMethods {

    @Before
    public void start() throws IOException {
        openBrowserAndLaunchApplication();

    }

    @After
    public void end(Scenario scenario){
        byte[] pic;
        if(scenario.isFailed()) {
            pic = takeScreenshot("failed/"+scenario.getName());
        }else{
            pic = takeScreenshot("passed/"+scenario.getName());
        }
        closeBrowser();

    }


}
