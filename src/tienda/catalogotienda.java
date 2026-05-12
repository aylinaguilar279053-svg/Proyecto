package tienda;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import static tienda.listadoprod.mostrarinventario;
public class catalogotienda {
    
     //*lista linkedhashset para que los imprima en orden y saber
     //*lo que esta agregado en el inventario
     public static Set<productos> prod = new LinkedHashSet<>();
     static {
      prod.add(new productos(1, "Manzana",10,2));
      prod.add(new productos(2, "Queso",25,1));
      prod.add(new productos(3, "Soda",18,4));
     }

    public static void main(String[] args) {

        //* Scanner para obtener respuestas del usuario
        Scanner P = new Scanner(System.in);
        //*sirve para el switch mini menu
        int opcion = 0;
     
        catalogotienda c = new catalogotienda(); //*poder traer los datos que estan en la lista arriba
  
        //*ciclo do y while para que se repita en caso de que no sea
        //*la respuesta que se espera
        boolean siletra;
    do{
        do{
        System.out.println("opciones");
        System.out.println("1.Agregar producto ");
        System.out.println("2.ver inventario");
        System.out.println("3.volver al menu principal");
        
        System.out.println("Escoja una opcion: ");
        String opcionn = P.nextLine();
        
        
        if(opcionn.matches("[0-9]+")){
          siletra = false;  
         opcion = Integer.parseInt(opcionn);
             if(opcion >3){
             System.out.println("no existe esa opcion, solo 1, 2 o 3");
             System.out.println("intente nuevamente");
         }
         
        }else{
            siletra = true;  
            System.out.println("Solo se permiten numeros");
        }
        }while(siletra);
        
        
        switch(opcion){
          
            case 1:
                int id =0;
                boolean existe; //*verdadero o falso para revisar que el id que
                //*ingrese el usuario no este ya en la lista de inventario
                boolean letra;
                do {//* en caso de que si este con este do y while va a preguntar
                    //* el id una y otra vez hasta que no coincida con uno que ya este
                    //*en la lista
                existe = false;
                letra = false;
                System.out.println("Ingrese ID: ");
                 String idd = P.nextLine();
                 
                 if(idd.matches("[0-9]+")) {
                     id = Integer.parseInt(idd);
                     letra = false;
                 }else{
                      letra = true;
                      System.out.println("Solo se permiten numeros: ");
                 }
                
                for(productos no: c.prod){//*compara lo que esta en la lista
                    if (no.id ==id){   //* si el id es el mismo al de la lista entonces              
                        existe = true;   
                        System.out.println("Ese ID ya existe.");
                        System.out.println("Ingrese otro.");
                    }
                }
                
                } while (existe || letra);//*si no esta en la lista puede continuar
                  System.out.println("\n--- Registra un nuevo producto ---");

                   boolean numero;
                   String producto; //*para que quede guardado fuera lo que se ingrese 
                   //*y poder usarlo mas adelante
                    
                  do {
                      numero = false;//* verificar que el ussuario si escriba texto y no numeros
                      System.out.println("Ingrese el producto: ");
                       producto = P.nextLine();

                     if(producto.matches("[0-9]+")){
                       numero = true;//* si si tiene numeros entonces repetira
                      System.out.println("Solo se permite texto");
                         }
                     
                   }while(numero); //*sigue
                  
                  boolean letrados;
                  double precio = 0;
                  
                  do{
                  System.out.println("Ingrese el precio: ");
                  String precios = P.nextLine();
                  
                  if(precios.matches("[0-9]+")) {
                     precio = Integer.parseInt(precios);
                     letrados = false;
                     
                 }else{
                      letrados = true;
                      System.out.println("Solo se permiten numeros: ");
                 }
                  }while(letrados);
                  
                  boolean letratres;
                  int cantidad = 0;
                  
                  do{
                  System.out.println("Ingrese la cantidad: ");
                  String cantidadd = P.nextLine();
                  
                   if(cantidadd.matches("[0-9]+")) {
                     cantidad = Integer.parseInt(cantidadd);
                     letratres = false;
                     
                 }else{
                      letratres = true;
                      System.out.println("Solo se permiten numeros: ");
                 }
                  }while(letratres);
        
                  productos nuevo =  new productos(id,producto,precio,cantidad);
                  //*ordena los datos
        
                  c.prod.add(nuevo);//* para que se agregue a la lista
                  System.out.println("producto ingresado exitosamente");    
                  break;
     
            case 2:
                //* imprime el inventario de la lista prod
                 mostrarinventario();
                break;
            case 3:
                System.out.println("Volviendo...");
                break;
            default:
                System.out.println("Opcion invalida");              
        }
        
        }while(opcion != 3); //*sale y vuelve al menu principal
    }     
}
