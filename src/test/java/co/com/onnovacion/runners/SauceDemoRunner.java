package co.com.onnovacion.runners;



import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features= {"src/test/resources/features/SauceDemoTest.feature"},
        glue = {"co.com.onnovacion.stepdefinition"}




)


public class SauceDemoRunner {
    public SauceDemoRunner(){

    }
    }
