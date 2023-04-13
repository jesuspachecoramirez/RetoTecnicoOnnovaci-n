package co.com.onnovacion.stepdefinition;

import co.com.onnovacion.model.DataRequiredModel;
import com.github.javafaker.Faker;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import org.apache.log4j.Logger;

import static co.com.onnovacion.question.CorrectLogin.correctlogin;
import static co.com.onnovacion.question.CorrectPrice.correctprice;
import static co.com.onnovacion.question.CorrectProduct.correctproduct;
import static co.com.onnovacion.question.FinalMessage.finalmessage;
import static co.com.onnovacion.question.FinalMessage.getFinalMessage;
import static co.com.onnovacion.task.FinalizarCompra.finalizarCompra;
import static co.com.onnovacion.task.AddProduct.addproduct;
import static co.com.onnovacion.task.BuyProduct.buyproduct;
import static co.com.onnovacion.task.OpenHomePage.openhomepage;
import static co.com.onnovacion.task.SimpleLogin.simplelogin;
import static co.com.onnovacion.userinterface.Checkout.BACK_HOME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;


public class SauceDemoStepdefinition extends SetUp{


    private static final Logger LOGGER = Logger.getLogger(SauceDemoStepdefinition.class);
    private static final String ACTOR_NAME = "User";
    private final DataRequiredModel credentials = new DataRequiredModel();
    private final Faker faker = new Faker();




@Dado("se encuentre en la pagina inicial")
    public void seEncuentreEnLaPaginaInicial(){
    actorSetuptheBrowser(ACTOR_NAME);
    try {
        theActorInTheSpotlight()
                .wasAbleTo(
                        openhomepage()
                );

    }catch (Exception exception){
        LOGGER.error("error de ingreso", exception);

    }


}
    @Cuando("^se ingresan las credenciales registradas$")
    public void seIngresanLasCredencialesRegistradas() {
        try {
            theActorInTheSpotlight()
                    .attemptsTo(
                           simplelogin()
                    );



        }catch (Exception exception){
            LOGGER.error("Error rellenando los campos de login", exception);

        }
    }


    @Entonces("puede ver todos los productos disponibles")
    public void puedeVerTodosLosProductosDisponibles() {

    theActorInTheSpotlight().should(seeThat(correctlogin()));


    }


    @Cuando("^se agrega un producto de la pagina al carrito$")
    public void seAgregaUnProductoDeLaPaginaAlCarrito() {

    try {
        theActorInTheSpotlight()
                .attemptsTo(
                        simplelogin(),
                        addproduct());
    }catch (Exception exception){
        LOGGER.error("No se pudo agregar el producto al carrito", exception);
    }

    }


    @Entonces("^se valida que el producto en el carrito corresponde con el agregado$")
    public void seValidaQueElProductoEnElCarritoCorrespondeConElAgregado() {

    theActorInTheSpotlight().should(seeThat(correctproduct()));

    }

    @Cuando("^se realiza el proceso de checkout para la compra del producto$")
    public void seRealizaElProcesoDeCheckoutParaLaCompraDelProducto() {
    credentials.setName(faker.name().firstName());
    credentials.setLastName(faker.name().lastName());
    credentials.setPostalCode(faker.number().digits(5));
    try {
        theActorInTheSpotlight()
                .attemptsTo(
                        simplelogin(),
                        addproduct(),
                        buyproduct()
                                .buyerName(credentials.getName())
                                .buyerLastName(credentials.getLastName())
                                .buyerZip(credentials.getPostalCode())
                );
    }catch (Exception exception){
        LOGGER.error("Error al realizar la compra", exception);
    }
    }


    @Entonces("^se valida el precio final sea el correcto$")
    public void seValidaElPrecioFinalSeaElCorrecto() {
        theActorInTheSpotlight().should(seeThat(correctprice()));
    }


    @Entonces("^se recibe un mensaje de compra exitosa$")
    public void seRecibeUnMensajeDeCompraExitosa() {
      theActorInTheSpotlight().attemptsTo(
              finalizarCompra()
      );
       theActorInTheSpotlight().should(seeThat(
               finalmessage(),
               is(getFinalMessage())
       ));
       theActorInTheSpotlight().attemptsTo(
               Click.on(BACK_HOME)
       );

    }


}
