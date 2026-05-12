package tienda;
import java.util.Scanner;
public class actualizarprod extends catalogotienda{
    public static void main(String[] args) {
        Scanner act = new Scanner(System.in);

                int id = 0;
                boolean actualizar;
                boolean letrados;
                int num = 0;
             
               do{
                   System.out.println("ACTUALIZAR PRODUCTO");
                   System.out.println("Ingrese el id del producto que desea actualizar");
                   String id_act = act.nextLine();
         
                   if (id_act.matches("[0-9]+")){ //* solo se permite numeros
                   id = Integer.parseInt(id_act);//* convierte a numero por que inicialmente esta como cadena de texto
                   actualizar = true;
                   
                   for(productos c: prod){ //* busca si el id esta en la lista
                       if(c.getId() == id){
                       System.out.println("producto encontrado");
                       actualizar = false;
                       }
                   }
                    
                       if(actualizar){   
                        System.out.println("el producto no fue encontrado");
                        System.out.println("intente nuevamente...");
                        System.out.println("  ");
                       }
                   } else {
                       actualizar = true;
                       System.out.println("solo se permiten numeros");
                       System.out.println("  ");
                   }  
                   
                }while(actualizar);
           
             do{   
                do{
                System.out.println("que desea actualizar?");
                System.out.println("1.id");
                System.out.println("2.nombre del producto");
                System.out.println("3.precio");
                System.out.println("4.cantidad");
                System.out.println("5.volver al menu principal");
                
                 String opcionn = act.nextLine();
         
                   if(opcionn.matches("[0-9]+")){
                      num = Integer.parseInt(opcionn);
                      letrados = false; 
                      
                         if(num < 1 || num >5){
                             letrados = true;
                             System.out.println("no existe esa opcion, solo 1, 2, 3, 4 o 5");    
                           }
                   }else{
                      letrados = true;
                      System.out.println("solo se permiten numeros"); 
                      System.out.println("intente nuevamente..."); 
                           }
                }while(letrados);
                     
                        switch (num){
                            case 1: //* cambiar ID

                                boolean encontrar;
                                boolean repetido =  false;
                             
                                encontrar = false;
                                int nuevoid = 0;
                                  
                                for(productos p: prod){ //* recorre la lista
                                    
                                    if(p.getId()==id){
                                       System.out.println("producto encontrado"); 
                                       System.out.println("ingrese el nuevo id: "); 
                                       String nuevoidd =  act.nextLine();
                                        nuevoid = Integer.parseInt(nuevoidd);
                                       
                                       if(!nuevoidd.matches("[0-9]+")){
                                           System.out.println("Solo se permiten numeros: ");}
                                           break;
                                       }
                                       

                                       if(nuevoid == id){
                                          System.out.println("No puedes usar el mismo id");
                                          break;
                                               }

                                         repetido = false;

                                       for(productos c : prod){
                                       if(c.getId() == nuevoid){
                                          repetido = true;
                                          break;
                                             }
                                         }

                                      if(repetido){
                                         System.out.println("Ese id ya esta en uso");
                                      }else{
                                      p.setId(nuevoid);
                                         System.out.println("id actualizado correctamente");
                                          }

                                         break;
                                             }
                                        
                                      if(!encontrar){
                                        System.out.println("No se encontro el producto");
                                      }
             
                        
                                case 2:
                                    //* cambiar el  nombre del producto
                           
                                    boolean encontrarnom;                         
                                    boolean texto;
                                    encontrarnom = false;
                                   
                                for(productos p: prod){ //* recorre la lista
                                    if(p.getId()==id){
                                       System.out.println("producto encontrado"); 
                                       System.out.println("ingrese el nuevo nombre: "); 
                                       String nuevonombre =  act.nextLine();
                                       
                                        if(nuevonombre.matches("[0-9]+")){
                                           texto = true;
                                           System.out.println("Solo se permiten texto: ");
                                        }
                                         else{
                                         texto = false;
                                        }
                                         if(p.getProducto()== nuevonombre){       
                                            System.out.println("ese producto ya esta en la lista");  
                                         }else{
                                            p.setProducto(nuevonombre);             
                                            encontrarnom = true;                                      
                                            System.out.println("nombre actualizado correctamente"); 
                                       
                                   }
                                }
                                
                              }
                                 
                                break;
                                
                                case 3: //* cambiar precio

                                     boolean encontrarprecio;
                                      double nuevoprecio = 0;
                               
                                encontrarprecio = false; //* para asegurarse que encuentre el id en la lista
                                
                                for(productos p: prod){ //* recorre la lista
                                    if(p.getId()==id){
                                       System.out.println("producto encontrado"); 
                                       System.out.println("ingrese el nuevo precio: "); 
                                       String nuevopreciop =  act.nextLine();
                                       
                                         if(nuevopreciop.matches("[0-9]+(\\.[0-9]+)?")){ //* para que lea en doubles
                                           texto = false;
                                           nuevoprecio = Double.parseDouble(nuevopreciop);
                                           
                                            p.setPrecio(nuevoprecio);
                                       
                                            encontrarprecio = true;
                                       
                                            System.out.println("Precio actualizado correctamente"); 
                                       }
                                       else{
                                         texto = true;
                                         System.out.println("Solo se permiten numeros: ");
                                                  }     
                                    }
                                  }
                              
                                     break;
                                    
                                case 4: //* cambiar cantidad
                             
                                  boolean encontrarcan;
                               
                                    encontrarcan = false; //* para asegurarse que encuentre el id en la lista
                                
                                for(productos p: prod){ //* recorre la lista
                                    if(p.getId()==id){
                                       System.out.println("producto encontrado"); 
                                       System.out.println("ingrese la nueva cantidad de producto: "); 
                                       String nuevacann =  act.nextLine();
                                       
                                       if(nuevacann.matches("[0-9]+")){ //* para que lea en doubles
                                           texto = false;
                                          int nuevacan = Integer.parseInt(nuevacann);
                                       
                                             p.setCantidad(nuevacan);
                                       
                                             encontrarcan = true;
                                       
                                             System.out.println("cantidad actualizada correctamente"); 
                                          
                                       }else{
                                          texto = true;
                                         System.out.println("Solo se permiten numeros: ");}       
                                    }
                                 }
                                
                                     break;  
                                
                                case 5:
                                    System.out.println("saliendo...");
                                    break;
                          
                  }
    }while(num !=5);
}
}
     
                      
               
          

