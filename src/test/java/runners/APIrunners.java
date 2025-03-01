package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = "APISteps",
        dryRun = true,
        plugin = {"pretty"},
        tags = "@validAPI or @invalid"
)

public class APIrunners {

}
