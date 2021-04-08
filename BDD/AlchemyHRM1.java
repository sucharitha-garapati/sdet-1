package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features",
    glue = {"TestDefination"},
    tags="@HRMScenario1",
    monochrome = true
)
public class AlchemyHRM1 {

}