package tienda;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import static tienda.catalogotienda.prod;
import static tienda.regisservicio.servicios_dict;
public class Materialesdisponibles extends regisservicio{

    public static void mostrarMaterialesDisponibles() {
        try {
            System.out.println("\nMATERIALES DISPONIBLES\n");
            if (prod.isEmpty()) {
                System.out.println("No hay materiales disponibles en el inventario.");
                return;
            }

      Iterator<Map.Entry<String, Map<String, Object>>> it = servicios_dict.entrySet().iterator();
    while (it.hasNext()) {

        Map.Entry<String, Map<String, Object>> entry = it.next();

        String folio = entry.getKey();
        Map<String, Object> datos = entry.getValue();

        if ("limpieza".equals(datos.get("tipo"))) {

            Map<String, Object> detalle =
                    (Map<String, Object>) datos.get("detalle");

            List<String> materiales =
                    (List<String>) detalle.get("materiales");

            System.out.println("Folio: " + folio);
            System.out.println("Materiales: " + String.join(", ", materiales));
            System.out.println("----------------------");
        }
    }         
        } catch (Exception e) {
            System.out.println("Ocurrio un error al mostrar los materiales: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
       mostrarMaterialesDisponibles();
    }
}
