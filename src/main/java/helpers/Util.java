package helpers;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Util {

    private static Faker faker = Faker.instance(new Locale("es", "CO"), new Random());

    public static List<WebElement> obtenerlocalizadorListBusquedaGeneral() {
        String xpath = Constant.LOCALIZADOR_TIPOLIST_ANDROID_RESULTADOS_BUSQUEDA_GENERAL;
        return BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().findElements(By.xpath(xpath));
    }

    public static int obtenerNumeroRandonParaSeleccionarUnResultadoBusqueda() {
        return faker.number().numberBetween(1, obtenerlocalizadorListBusquedaGeneral().size());
    }

    public static String armarLocalizadorRamdonSeleccionarUnResultadoDeBusqueda() {
        int numeroRandomResultado = obtenerNumeroRandonParaSeleccionarUnResultadoBusqueda();
        String xpathRandom = Constant.LOCALIZADOR_TIPOLIST_ANDROID_RESULTADOS_BUSQUEDA_GENERA1+"["+numeroRandomResultado+"]/android.widget.LinearLayout/android.widget.TextView";
        return xpathRandom;
    }
}
