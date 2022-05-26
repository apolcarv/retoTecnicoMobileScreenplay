package helpers;


public class Time {


    private static final String LOG_CLASE = "Error al ejecutar el metodo de tiempo -> ";


    public static void getTimeTen() {
        final String METODO = " -> getTimeFour";
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            ManagerLog.imprimirFallo(LOG_CLASE + " " + METODO + " " + e);
            Thread.currentThread().interrupt();
        }
    }

    public static void getTimeFive() {
        final String METODO = " -> getTimeFive";
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            ManagerLog.imprimirFallo(LOG_CLASE + " " + METODO + " " + e);
            Thread.currentThread().interrupt();
        }
    }
}
