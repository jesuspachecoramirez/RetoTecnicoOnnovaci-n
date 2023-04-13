package co.com.onnovacion.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignInPage extends PageObject {

    public static final Target USER_LOGIN = Target
            .the("Campo ingreso usuario")
            .located(By.id("user-name"));

    public static final Target PASSWORD_INPUT = Target
            .the("Campo ingreso contraseña")
            .located(By.id("password"));

    public static final Target LOGIN = Target
            .the("Ingresar a la pagina")
            .located(By.id("login-button"));

   public static final Target PRODUCTS = Target
           .the("Productos disponibles")
           .located(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));

}
