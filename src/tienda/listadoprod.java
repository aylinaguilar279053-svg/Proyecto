package tienda;
import static tienda.catalogotienda.prod;
public class listadoprod extends catalogotienda{
        public static void mostrarinventario(){
        System.out.println("\nINVENTARIO\n");
                System.out.println(" ID       PRODUCTO      PRECIO      CANTIDAD        CATEGORIA");
                for(productos valor: prod){
                   
                   System.out.println("|-------------------------------------------------------------|");
                   System.out.println("   "+valor.getId()+"  |    "+valor.getProducto()+"   "+"  | "+valor.getPrecio()+"     "+"  |  "+valor.getCantidad()+"   "+"  | " + valor.getCategoria()+"     |");
                  
                }
                 System.out.println("|---------------------------------------------------------------|");
        }
        public static void main(String[] args) {
        mostrarinventario();
    }
    }
   //*

