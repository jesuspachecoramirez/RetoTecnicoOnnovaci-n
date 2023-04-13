package co.com.onnovacion.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.onnovacion.task.LoginPage.loginpage;
import static co.com.onnovacion.util.Constant.PASSWORD;
import static co.com.onnovacion.util.Constant.USERNAME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SimpleLogin implements Task {


    public static SimpleLogin simplelogin(){
        return new SimpleLogin();
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        theActorInTheSpotlight()
                .attemptsTo(
                        loginpage()
                                .userLogin(USERNAME)
                                .passwordInput(PASSWORD)
                                .login()
                );


    }
}
