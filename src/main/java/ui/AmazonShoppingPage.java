package ui;

import helpers.Util;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AmazonShoppingPage extends PageObject {

    public static final Target BUTTON_AMAZON = Target.the("ingresar amazon shopping sin loguearse")
            .located(By.id("skip_sign_in_button"));

    public static final Target INPUT_CLICK_SEARCH = Target.the("le da clic en la barra de busqueda")
            .located(By.id("chrome_search_hint_view"));

    public static final Target INPUT_SEARCH = Target.the("inserta el valor del producto de preferencia")
            .located(By.id("rs_search_src_text"));

    public static final Target VALID_RESULT = Target.the("Valida que este en la pagina de resultados de busqueda")
           .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[4]"));


}
