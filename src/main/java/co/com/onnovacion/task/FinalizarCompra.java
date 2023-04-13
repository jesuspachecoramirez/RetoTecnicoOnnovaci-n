package co.com.onnovacion.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.onnovacion.userinterface.Checkout.*;

public class FinalizarCompra implements Task {


    public static FinalizarCompra finalizarCompra(){
        return new FinalizarCompra();
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FINISH_BUTTON)
        );


    }
}
