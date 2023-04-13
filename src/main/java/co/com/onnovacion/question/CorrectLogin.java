package co.com.onnovacion.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.onnovacion.userinterface.SignInPage.PRODUCTS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class CorrectLogin implements Question<Boolean> {
public static final String SECCION = "Products";
Question<String>respuesta;


    @Override
    public Boolean answeredBy(Actor actor) {
    Boolean x= true;
    String expectedTitle = PRODUCTS.resolveFor(actor).getText();

    String receivedField = String.valueOf(SECCION.contains(expectedTitle));

    respuesta = Question.about("").answeredBy(actor1 -> receivedField);

    theActorInTheSpotlight().should(seeThat(respuesta,equalTo("true")));

        return x;
    }

    public static CorrectLogin correctlogin(){
    return new CorrectLogin();
    }
}
