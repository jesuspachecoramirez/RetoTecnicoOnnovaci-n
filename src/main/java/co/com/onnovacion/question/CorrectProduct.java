package co.com.onnovacion.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.onnovacion.userinterface.ShoppingCart.PURCHASE_MADE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class CorrectProduct implements Question<Boolean> {
    public static final String CHOSEN_PRODUCT = "Sauce Labs Bolt T-Shirt";
    Question<String>respuesta;


    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean x = true;
        String expectProduct = PURCHASE_MADE.resolveFor(actor).getText();

        String receivedField = String.valueOf(CHOSEN_PRODUCT.contains(expectProduct));

        respuesta = Question.about("").answeredBy(actor1 ->receivedField );

        theActorInTheSpotlight().should(seeThat(respuesta,equalTo("true")));

        return x;
    }

    public static CorrectProduct correctproduct(){
        return new CorrectProduct();
    }
}
