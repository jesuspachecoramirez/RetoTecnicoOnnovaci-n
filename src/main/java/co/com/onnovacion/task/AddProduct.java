package co.com.onnovacion.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;


import static co.com.onnovacion.userinterface.ShoppingCart.*;

public class AddProduct implements Task {


    public static AddProduct addproduct(){
        return new AddProduct();
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PRODUCT),

                Scroll.to(SHOPPING_CART),

                Click.on(SHOPPING_CART)
        );

    }
}
