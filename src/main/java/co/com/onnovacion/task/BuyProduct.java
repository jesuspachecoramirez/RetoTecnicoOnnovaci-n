package co.com.onnovacion.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;


import static co.com.onnovacion.userinterface.Checkout.*;

public class BuyProduct implements Task {

    private String name;
    private String lastName;
    private String postalCode;

public BuyProduct buyerName(String name){
    this.name= name;
    return this;

}

public BuyProduct buyerLastName(String lastName){
    this.lastName =lastName;
    return this;
}

public BuyProduct buyerZip(String postalCode){
    this.postalCode = postalCode;
    return this;
}
    @Override
    public <T extends Actor> void performAs(T actor) {
      actor.attemptsTo(
              Click.on(CHECKOUT_BUTTON),

              Click.on(FIRTS_NAME),
              Enter.theValue(name).into(FIRTS_NAME),

              Click.on(LAST_NAME),
              Enter.theValue(lastName).into(LAST_NAME),

              Click.on(POSTAL_ZONE),
              Enter.theValue(postalCode).into(POSTAL_ZONE),

              Scroll.to(CONTINUE),
              Click.on(CONTINUE)
      );
    }

    public static BuyProduct buyproduct(){
        return new BuyProduct();
    }
}
