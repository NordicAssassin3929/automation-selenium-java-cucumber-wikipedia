package runner;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(
        features = "features",
        glue = {"testcases"})
public class testRunner {
}
