package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = {"stepDefinitions"},
        monochrome=true,
        plugin= {"pretty", "junit:target/JUnitReports/report.xml"}
)
public class TestRunner {
}
