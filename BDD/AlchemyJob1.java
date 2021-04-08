package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features",
    glue = {"TestDefination"},
    tags="@Scenario1",
    plugin = {"pretty"},
    monochrome = true
)
public class AlchemyJob1 {

}