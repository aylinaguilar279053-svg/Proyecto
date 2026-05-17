package tienda;
import java.util.Iterator;
public class mostrarlistadeservicios extends regisservicio{

    public static void mostrarListadoServicios() {
        try {
            System.out.println("\nLISTADO DE SERVICIOS PROPORCIONADOS\n");
            if (serviciosRegistrados.isEmpty()) {
                System.out.println("No hay servicios registrados.");
                return;
            }

            Iterator<folioedeservicios> iterador = serviciosRegistrados.iterator();
            while (iterador.hasNext()) {
                folioedeservicios servicio = iterador.next();
                System.out.println("Folio: " + servicio.getFolio()
                        + " | Tipo: " + servicio.getTipo()
                        + " | Fecha: " + servicio.getFecha()
                        + " | Producto ID: " + servicio.getProductoid()
                        + " | Detalle: " + servicio.getDetalle());
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al mostrar los servicios: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        mostrarListadoServicios();
    }
}
