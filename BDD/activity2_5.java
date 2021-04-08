package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/java/FeatureFiles",
    glue = {"TestDefination"},
    tags = "@activity2_5"
)
public class activity2_5 {

}