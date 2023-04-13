package co.com.onnovacion.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Checkout extends PageObject {

    public static final Target CHECKOUT_BUTTON = Target
            .the("Boton de checkout")
            .located(By.id("checkout"));

    public static final Target FIRTS_NAME= Target
            .the("Primer nombre del comprador")
            .located(By.id("first-name"));

    public static final Target LAST_NAME= Target
            .the("Segundo nombre del comprador")
            .located(By.id("last-name"));

    public static final Target POSTAL_ZONE = Target
            .the("Codigo postal del comprador")
            .located(By.id("postal-code"));

    public static final Target CONTINUE = Target
            .the("Boton continuar")
            .located(By.id("continue"));

    public static final Target PRICE_PRODUCT = Target
            .the("Precio del producto")
            .located(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]"));

    public static final Target PRICE_TAX = Target
            .the("Precio del envio")
            .located(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]"));

    public static final Target TOTAL_PRICE = Target
            .the("Precio total de la compra")
            .located(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]"));

    public static final Target FINISH_BUTTON = Target
            .the("Boton finalizar")
            .located(By.id("finish"));

    public static final Target BUY_MESSAGE = Target
            .the("Mensaje de compra exitosa")
            .located(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));

    public static final Target BACK_HOME = Target
            .the("Boton volver al inicio")
            .located(By.id("back-to-products"));

}
