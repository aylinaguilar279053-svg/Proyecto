package tienda;
import java.util.Scanner;
public class eliminarprod extends catalogotienda  {
    
    //* Herencia
    public static void main(String[] args) {
      Scanner E = new Scanner(System.in);
        
         boolean eliminar = false;
         int id = 0;
       do{
         try{
         System.out.println("Ingrese el id del producto que desea eliminar: ");
         String id_eliminar = E.nextLine();
         
           if (!id_eliminar.matches("[0-9]+")) //* solo se permite numeros
              {
               throw new EntradaInvalidaExcepcion("Solo numeros");
      
               }
      
              id = Integer.parseInt(id_eliminar);//* convierte a numero por que inicialmente esta como cadena de texto
              eliminar = false;
             
              }catch(EntradaInvalidaExcepcion e){
              System.out.println(e.getMessage());
              }
           
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
         
         
         
         
         
         
               
    }while(!eliminar);//* si no lo encuentra sigue el ciclo
}
}



