package co.com.onnovacion.stepdefinition;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import java.util.concurrent.TimeUnit;

import static co.com.onnovacion.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static co.com.onnovacion.util.Log4jValues.USER_DIR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class SetUp {

@Managed()
protected WebDriver webDriver;
protected static String SO = System.getProperty("os.name").toLowerCase();

    public void setupBrowser() {

        if (SO.contains("nux")) {
            WebDriverManager.chromedriver().linux().setup();
        } else {
            WebDriverManager.chromedriver().win().setup();
        }
        webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com");
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();


    }

   private void setupUser(String name, WebDriver webDriver){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(name).can(BrowseTheWeb.with(webDriver));
    }
    public void actorSetuptheBrowser(String actorName){
        setUpLog4j2();
        setupBrowser();
        setupUser(actorName, webDriver);


}
    private void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.getValue() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

}
