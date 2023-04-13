package co.com.onnovacion.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


import static co.com.onnovacion.userinterface.SignInPage.*;


public class LoginPage implements Task {

    private String user;
    private String password;


    public static LoginPage loginpage(){
        return new LoginPage();
    }

    public LoginPage userLogin(String user){
        this.user=user;
        return this;
    }

    public LoginPage passwordInput(String password){
        this.password=password;
        return this;
    }

    public LoginPage login(){
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on(USER_LOGIN),
                Enter.theValue(user).into(USER_LOGIN),


                Click.on(PASSWORD_INPUT),
                Enter.theValue(password).into(PASSWORD_INPUT),


                Click.on(LOGIN)

        );
    }
}
