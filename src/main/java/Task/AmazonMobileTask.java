package Task;

import helpers.Time;
import helpers.Util;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;


import static ui.AmazonShoppingPage.*;

public class AmazonMobileTask implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(Click.on(BUTTON_AMAZON));
        actor.attemptsTo(Click.on(INPUT_CLICK_SEARCH));
        actor.attemptsTo(Enter.theValue("Blouson").into(INPUT_SEARCH));
        actor.attemptsTo(Click.on(Util.armarLocalizadorRamdonSeleccionarUnResultadoDeBusqueda()));
        Time.getTimeTen();
        actor.attemptsTo(Click.on(INPUT_CLICK_SEARCH));
        actor.attemptsTo(Enter.theValue("Blouson").into(INPUT_SEARCH));
        actor.attemptsTo(Click.on(Util.armarLocalizadorRamdonSeleccionarUnResultadoDeBusqueda()));

    }

    public static Performable BuscaProducto() {
        return Tasks.instrumented(AmazonMobileTask.class);
    }
}
