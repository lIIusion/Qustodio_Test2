package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature",
        glue={"StepDefinitions"},
        monochrome = true,

        plugin = { "pretty", "junit:target/reports/XML/report.xml",
                "json:target/reports/JSON/report.json",
                "html:target/reports/HTML/report.html"},
        tags="@Functionality"
)

public class TestRunner {
}
