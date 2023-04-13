package co.com.onnovacion.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.onnovacion.userinterface.HomePage.homepage;

public class OpenHomePage implements Task {

    public static OpenHomePage openhomepage() {
        return new OpenHomePage();
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.wasAbleTo(
                Open.browserOn(homepage())
        );

    }
}
