package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features",
    glue = {"TestDefination"},
    tags="@Scenario4",
    plugin = {"html: test-reports"},
    monochrome = true
)
public class AlchemyJob4 {

}