package co.com.onnovacion.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.onnovacion.userinterface.Checkout.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class CorrectPrice implements Question<Boolean> {


    Question<String>respuesta;

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean x=true;
        float expectprice = Float.parseFloat(PRICE_PRODUCT.resolveFor(actor).getText().substring(13));

        float expectTax= Float.parseFloat(PRICE_TAX.resolveFor(actor).getText().substring(6));

        float expectTotalPrice= expectprice + expectTax;

        String totalPrice = TOTAL_PRICE.resolveFor(actor).getText().substring(8);

        String expectTotalprice= String.valueOf(expectTotalPrice);

        String receivedField = String.valueOf(expectTotalprice.contains(totalPrice));

        respuesta= Question.about("").answeredBy(actor1 -> receivedField);

        theActorInTheSpotlight().should(seeThat(respuesta,equalTo("true")));

        return x;
    }

    public static CorrectPrice correctprice(){
        return new CorrectPrice();
    }
}
