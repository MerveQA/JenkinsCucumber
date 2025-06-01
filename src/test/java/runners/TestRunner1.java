package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report/TestRunner1-report.html",
                "json:target/cucumber-report/TestRunner1-report.json"},
        features = "src/test/resources/features",
        glue = "stepdefinations",
        monochrome = true,
        dryRun = false,
        tags = "@c"
)
public class TestRunner1 {
}
