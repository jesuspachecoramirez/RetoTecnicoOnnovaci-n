package co.com.onnovacion.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.onnovacion.userinterface.Checkout.BUY_MESSAGE;

public class FinalMessage implements Question<String> {

    public static final String FINAL_MESSAGE= "Thank you for your order!";

    public static String getFinalMessage(){
        return FINAL_MESSAGE;
    }


    @Override
    public String answeredBy(Actor actor) {

        return BUY_MESSAGE.resolveFor(actor).getText();
    }

    public static FinalMessage finalmessage(){
        return new FinalMessage();
    }
}
