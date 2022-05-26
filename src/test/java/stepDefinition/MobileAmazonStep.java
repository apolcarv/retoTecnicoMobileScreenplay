package stepDefinition;

import Task.AmazonMobileTask;
import helpers.Constant;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import question.AmazonShoppingQuestion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MobileAmazonStep {


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    /*
        @Rule
        public TestRule watcher = new TestWatcher() {
            @Override
          protected void failed (Throwable throwable, Description description){
                File screenshotFile = ((TakesScreenshot)BrowseTheWeb.as(theActorInTheSpotlight()).getDriver()).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(screenshotFile,new File("Error_"+description.getMethodName()+Date.obtenerFechaActual()+".png"));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            protected void finished(Description description){
                BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().quit();
            }
        };
    */
    @Dado("que el usuario conecta abre el emulador de dispotivo mobil y abre la apk amazon shopping")
    public void queElUsuarioConectaAbreElEmuladorDeDispotivoMobilYAbreLaApkAmazonShopping() throws Exception {

    }

    @Cuando("busca un producto de preferencia")
    public void buscaUnProductoDePreferencia() {
        theActorCalled(Constant.MR_ROBOT).attemptsTo(AmazonMobileTask.BuscaProducto());

    }

    @Entonces("visualiza la busqueda del producto de forma exitosa")
    public void visualizaLaBusquedaDelProductoDeFormaExitosa() {
        theActorInTheSpotlight().should(seeThat(AmazonShoppingQuestion.validaElPrecioDelProducto()));
    }
}
