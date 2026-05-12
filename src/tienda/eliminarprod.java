package tienda;
import java.util.Scanner;
public class eliminarprod extends catalogotienda  {
    
    //* Herencia
    public static void main(String[] args) {
      Scanner E = new Scanner(System.in);
        
         boolean eliminar = false;
         
         do{
         System.out.println("Ingrese el id del producto que desea eliminar: ");
         String id_eliminar = E.nextLine();
         
           if (id_eliminar.matches("[0-9]+")) //* solo se permite numeros
           {
               
           int id = Integer.parseInt(id_eliminar);//* convierte a numero por que inicialmente esta como cadena de texto
           eliminar = false;

         for(productos p: prod){ //* busca en la lista principal de la otra clase la linkedhashset
             if(p.getId()== id){
                 prod.remove(p);
                 eliminar = true;
                 System.out.println(p.getId()+" | "+p.getProducto()+" | "+"Producto eliminado correctamente");
                 break;

             }
         } 
         if(!eliminar){ //*si no existe ese numero
             System.out.println("ERROR. no se encontro el producto");
             System.out.println("Intente nuevamente..."); 
         }
         
         }else{ //*si ingresa letras o algo mas en vez de nuemros
             System.out.println("ERROR. solo se permiten numeros");
             System.out.println("Intente nuevamente..."); 
             eliminar = false;
           }
         
         }while(!eliminar);//* si no lo encuentra sigue el ciclo
               
    }
}



