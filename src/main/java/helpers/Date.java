package helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Date {
    public static String obtenerFechaActual(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }
}
