package runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/feature/mobileAmazon.feature"}
        , glue = {"stepDefinition"}
        , tags = "@Mobile_exitoso"
        , snippets =  CucumberOptions.SnippetType.CAMELCASE)
public class TestRunnerMobileAmazon {
}
