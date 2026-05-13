package tienda;
import java.util.Scanner;
import static tienda.catalogotienda.prod;
public class actualizarprod extends catalogotienda{
    public static void main(String[] args) {
        
         //* este codigo para abajo esta totalmente bien.      
        Scanner act = new Scanner(System.in);
        
        boolean encontrar = false;
        boolean letra = false;
        int id = 0;
        productos encontradoProd = null;
        
        System.out.println("ACTUALIZAR PRODUCTO");
        
        //*do y while repite hasta que el usuario ingrese solo numeros
  
        do{
            try{
        System.out.println("ingrese el id del producto que desea actualizar: ");
        String idd = act.nextLine();
        
        if(idd.matches("[0-9]+")){
            letra = false;
            id = Integer.parseInt(idd); 
            
            encontrar = false;
            
           }else{
            throw new EntradaInvalidaExcepcion("Solo numeros");
              }
        
            }catch(EntradaInvalidaExcepcion e){
                System.out.println(e.getMessage());
            }
            
         for(productos c: prod){
            
          if(c.getId()==id){
              encontradoProd =c;
              System.out.println("producto encontrado");  
              encontrar = true;
              break; 
          }
         }
       
          if(!encontrar){
              encontrar = false;
              System.out.println("producto no encontrado");  
              System.out.println("intente nuevamente...");
          }    
        
         //* es de la comprobacion para ver si es o no un numero lo que
         //* ingresado el usuario
        
        }while(letra || !encontrar);      
        
        //* este codigo para abajo esta totalmente bien.      
        int opcion =0;
        boolean num =  false;
        
        do{
            try{
         System.out.println("¿Que desea actualizar?");
         System.out.println("1. ID");
         System.out.println("2. Producto (Nombre)");
         System.out.println("3. precio");
         System.out.println("4. cantidad");
         System.out.println("5. categoria");
         System.out.println("6. regresar al menu principal");
         
         String opcionn = act.nextLine();
         
         if(opcionn.matches("[0-9]+")){
             num = false;
             opcion = Integer.parseInt(opcionn);
             
             if(opcion >6 || opcion <1 ){
                 System.out.println("no existe esa opcion, solo 1, 2, 3, 4, 5");
                 System.out.println("intente nuevamente...");
             }
         }else{
             throw new EntradaInvalidaExcepcion("Solo numeros");
         }
         
            }catch(EntradaInvalidaExcepcion e){
                System.out.println(e.getMessage());
            }
         
         //*SI FUNCIONA EL SWITCH
         
         switch(opcion){
             //*SI EJECUTA CASE 1
             case 1:
                 //*ver datos del producto
                 System.out.println("ID ACTUAL: "+encontradoProd.getId()+" PRODUCTO: "+encontradoProd.getProducto()+" PRECIO:  "+encontradoProd.getPrecio()+" CANTIDAD: "+encontradoProd.getCantidad() +" CATEGORIA: "+encontradoProd.getCategoria());
                 
                 //*AQUI EMPIEZA EL CAMBIO DE ID
                 System.out.println("ACTUALIZAR ID");
                 
                 //*HASTA AQUI FUNCIONA BIEN
                 boolean texto = false;
                 int nuevoid = 0;
                 boolean igual = false;
                              
                 do{
                     try{
                    System.out.println("ingrese el nuevo id: ");
                    String nuevoidd = act.nextLine();
                    
                    //*cuidar que sollo ingrese numeros
                    if(nuevoidd.matches("[0-9]+")){
                        texto = false;
                        nuevoid =  Integer.parseInt(nuevoidd);
                        
                        
                         //*recorrer la lista para ver que no se repita el id
                        for(productos p: prod){
                            if(p.getId() == nuevoid){
                                igual = true;
                                break;
                            }
                        }
                        
                        if (igual){
                         System.out.println("No puedes utilizar el mismo id");   
                        }else{
                             encontradoProd.setId(nuevoid);
                             System.out.println("ID actualizado correctamente");   
                        }
                       
                   //*cuidar que sollo ingrese numeros, este else es parte de ese if
                    }else{
                       throw new EntradaInvalidaExcepcion("Solo numeros");
                    }
                     }catch(EntradaInvalidaExcepcion e){
                         System.out.println(e.getMessage());
                     }
  
                 }while(texto || igual);     
                 break;
                  //*HASTA AQUI FUNCIONA BIEN SI ACTUALIZA EL ID          
                 
          
             case 2:
                 
                 break;
             case 3:
                 break;
             case 4:
                 break;
             case 5:
                 break;
                 
            //*SI FUNCIONA EL CASE 6
             case 6:
                 System.out.println("Saliendo....");
                 break;
         }
    }while(num);
        //*hasta aqui FUNCIONA. NO MOVER ARRIBA
        
    }
}
               
          

