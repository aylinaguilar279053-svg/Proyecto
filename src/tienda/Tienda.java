package tienda;
import java.util.Scanner;
public class Tienda {
    public static void main(String[] args) {
       
        Scanner num = new Scanner(System.in);
        int opcion;
        do {
        System.out.println("\nINVENTARIO TIENDA");
        System.out.println("1.Agregar un nuevo producto");
        System.out.println("2.Eliminar un producto no deseado");
        System.out.println("3.Actualizar los productos");
        System.out.println("4.Mostrar listado");
        System.out.println("5.Registrar un servicio Proporcionado");
        System.out.println("6.ELimina servicio");
        System.out.println("7.Mostrar listado de servicios proporcionados");
        System.out.println("8.Mostrar los materiales disponibles");
        System.out.println("0.Salir");
        
         System.out.println("Elija una opcion: ");
         opcion = num.nextInt();
         
         switch(opcion){
             case 1:
                 catalogotienda.main(null);
                 break;
             case 2:
                 eliminarprod.main(null);
                 break;
             case 3:
                 actualizarprod.main(null);               
                 break;
             case 4:
                 listadoprod.main(null);
                 break;
             case 5:
                 break;
             case 6:
                 break;
             case 7:
                 break;
             case 8:
                 break;
         }
        
    }while(opcion != 0);
    
}
}
