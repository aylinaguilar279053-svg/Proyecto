//*5
package tienda;
import java.util.ArrayList;
import java.util.List;
public class regisservicio {

    public static final List<folioedeservicios> serviciosRegistrados = new ArrayList<>();

    static {
        restablecerServiciosBase();
    }

    public static void restablecerServiciosBase() {
        serviciosRegistrados.clear();
        serviciosRegistrados.add(new folioedeservicios(1001, "LIMPIEZA", "15/05/2026", 1, "Limpieza de area de frutas"));
        serviciosRegistrados.add(new folioedeservicios(1002, "REABASTECIMIENTO", "15/05/2026", 2, "Reabastecimiento de lacteos"));
    }

    public static void main(String[] args) {

    }
 
}
//*
