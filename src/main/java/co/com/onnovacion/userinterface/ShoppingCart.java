package co.com.onnovacion.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShoppingCart extends PageObject {


    public static final Target PRODUCT = Target
            .the("Productos disponibles")
            .located(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));


    public static final Target SHOPPING_CART = Target
            .the("Carrito de compras")
            .located(By.id("shopping_cart_container"));

    public static final Target PURCHASE_MADE = Target
            .the("Producto agregado")
            .located(By.id("item_1_title_link"));
}
