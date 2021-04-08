package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features",
    glue = {"TestDefination"},
    tags="@CRMScenario1",
    monochrome = true
)
public class AlchemyCRM1 {

}