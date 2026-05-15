package tienda;
import java.util.Map;
import java.util.Scanner;
public class eliminarservicio extends regisservicio {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n--- ELIMINAR UN SERVICIO REGISTRADO ---");

        if (servicios_dict.isEmpty()) {
            System.out.println("No hay servicios registrados.");
            return;
        }

        System.out.print("Ingrese el folio del servicio a eliminar: ");
        String folio = leer.nextLine();

        if (!servicios_dict.containsKey(folio)) {
            System.out.println("No existe lo que intentas borrar");
            return;
        }

        // Obtenemos los datos del folio
        Map<String, Object> datos = servicios_dict.get(folio);
        Map<String, Object> detalle = (Map<String, Object>) datos.get("detalle");
        String tipo = (String) datos.get("tipo");

        System.out.println("\n--- DETALLES DEL SERVICIO ---");
        System.out.println("Folio: " + folio);
        System.out.println("Tipo : " + tipo);
        System.out.println("Fecha: " + datos.get("fecha"));
        System.out.println("Producto asociado: " + (datos.get("producto") != null ? datos.get("producto") : "N/A"));

        System.out.println("\n--- Datos especificos ---");
        switch (tipo) {
            case "reabastecimiento":
                System.out.println("Modo: " + detalle.get("modo"));
                System.out.println("Cantidad final: " + detalle.get("cantidad_final"));
                break;
            case "merma":
                System.out.println("Motivo: " + detalle.get("motivo"));
                System.out.println("Cantidad retirada: " + detalle.get("cantidad_retirada"));
                break;
            case "limpieza":
                System.out.println("Area limpiada: " + detalle.get("area"));
                System.out.println("Encargado: " + detalle.get("encargado"));
                System.out.println("Materiales: " + detalle.get("materiales"));
                break;
            case "recepcion":
                System.out.println("Proveedor: " + detalle.get("proveedor"));
                System.out.println("Productos recibidos: " + detalle.get("productos"));
                break;
            case "cambio_precio":
                System.out.println("Tipo de cambio: " + detalle.get("tipo_cambio"));
                System.out.printf("Precio anterior: $%.2f%n", detalle.get("precio_anterior"));
                System.out.printf("Precio nuevo: $%.2f%n", detalle.get("precio_nuevo"));
                break;
        }

        System.out.print("\n¿Desea eliminar este servicio? (s/n): ");
        String confirmar = leer.nextLine().toLowerCase();

        if (confirmar.equals("s")) {
            servicios_dict.remove(folio);
            System.out.println("\nServicio eliminado correctamente\n");
        } else {
            System.out.println("\nEliminacion cancelada\n");
        }
    
    }
}
