package question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static ui.AmazonShoppingPage.VALID_RESULT;


public class AmazonShoppingQuestion implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return VALID_RESULT.resolveFor(actor).isVisible();
    }
    public static AmazonShoppingQuestion validaElPrecioDelProducto(){
        return new AmazonShoppingQuestion();
    }
}
