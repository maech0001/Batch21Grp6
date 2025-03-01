package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/",
        glue = "steps",
        dryRun = false,
        plugin = {"pretty"},
        tags = "@common and @Grp1"
)
public class testRunners {
}
