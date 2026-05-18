package tienda;
import java.util.Iterator;
import static tienda.catalogotienda.prod;
public class Materialesdisponibles extends regisservicio{

    public static void mostrarMaterialesDisponibles() {
        try {
            System.out.println("\nMATERIALES DISPONIBLES\n");
            if (prod.isEmpty()) {
                System.out.println("No hay materiales disponibles en el inventario.");
                return;
            }

            Iterator<productos> iterador = prod.iterator();
            while (iterador.hasNext()) {
                
                productos material = iterador.next();
                System.out.println("Nombre: " + material.getProducto()
                        + " | Cantidad: " + material.getCantidad()
                        + " | Precio: " + material.getPrecio());
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al mostrar los materiales: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
       mostrarMaterialesDisponibles();
    }
}
