package tienda;
import java.util.Scanner;
public class Tienda {
    public static void main(String[] args) {
       
        Scanner num = new Scanner(System.in);
        int opcion = 0;
        boolean texto = false;
       do{
        do {
            try{
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
         String opcionn = num.nextLine();
           if(opcionn.matches("[0-9]+")){
                texto = false; 
                 opcion = Integer.parseInt(opcionn);
                 
                 if(opcion >8 || opcion <0){
                      System.out.println("No existe esa opcion");
                       System.out.println("intente nuevamente");
                 }
                    }else{
           throw new EntradaInvalidaExcepcion("Solo numeros");
                 }
            }catch(EntradaInvalidaExcepcion e){
                texto = true;
                System.out.println(e.getMessage());
            }
        }while(texto);
        
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
                 regisservicio.main(null);
                 break;
             case 6:
                 eliminarservicio.main(null);
                 break;
             case 7:
                 mostrarlistadeservicios.main(null);
                 break;
             case 8:
                 Materialesdisponibles.main(null);
                 break;
         }
        
    }while(opcion != 0);
}

}