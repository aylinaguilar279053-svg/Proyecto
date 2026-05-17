package tienda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class regisservicio {

    public static final List<folioedeservicios> serviciosRegistrados = new ArrayList<>();

    static {
        restablecerServiciosBase();
    }

    public static void restablecerServiciosBase() {
        serviciosRegistrados.clear();
        serviciosRegistrados.add(new folioedeservicios(1001, "LIMPIEZA", "15/05/2026", 1, "Limpieza de area de frutas"));
        serviciosRegistrados.add(new folioedeservicios(1002, "REABASTECIMIENTO", "15/05/2026", 2, "Reabastecimiento de lacteos"));
    }

    public static Map<String, Map<String, Object>> servicios_dict = new HashMap<>();
    public static int folio_actual = 0;
    public static productos buscarProductoEnCatalogo(String idBuscado) {
        for (productos p : catalogotienda.prod) {
            if (String.valueOf(p.getId()).equals(idBuscado)) {
                return p; 
            }
        }
        return null; 
    }

    public static String generarFolio() {
        folio_actual++;
        return String.format("%06d", folio_actual);
    }
    public static void main(String[] args) {
      Scanner leer = new Scanner(System.in);
      
        int opcion = 0;
        boolean letra = false;
      do{
        System.out.println("\n--- LISTA DE SERVICIOS DISPONIBLES ---");
        System.out.println("1. Reabastecimiento de productos");
        System.out.println("2. Registro de caducidad y merma");
        System.out.println("3. Limpieza y mantenimiento del area de alimentos");
        System.out.println("4. Registro de recepcion de mercancia");
        System.out.println("5. Control de promociones o cambios de precio");
        System.out.println("0. Salir");

        System.out.print("\nElige el numero del servicio que quieres: ");
        String opcionn = leer.nextLine();
        leer.nextLine(); // Limpiar el buffer
        
        //*Para q  no truene al intentar poner letras
        
        if(opcionn.matches("[0-9]+")){    
            letra = false;
          opcion = Integer.parseInt(opcionn);
          
        }else{
            letra = true;
            System.out.println("Solo se permiten numeros");
            System.out.println("Intente nuevamente");
        }
      }while(letra);
      
            switch (opcion) {
            case 1: rab(); break;
            case 2: merma(); break;
            case 3: limpieza(); break;
            case 4: recepcion(); break;
            case 5: cambio_precio(); break;
            default: System.out.println("Esa opcion no participa");
        }
    }

    // --- 1. REABASTECIMIENTO ---
    public static void rab() {
    Scanner leer = new Scanner(System.in);
    System.out.println("\n--- REABASTECIMIENTO DE PRODUCTOS ---");
    System.out.print("Ingrese el id del producto: ");
    String prod_id = leer.nextLine();
    productos p = buscarProductoEnCatalogo(prod_id);
    
    if (p == null) {
        System.out.println("no existe el producto");
        return;
    }
    System.out.print("Tipo de reabastecimiento (parcial/total): ");
    String tipo = leer.nextLine().toLowerCase();
    System.out.print("Fecha (DD/MM/AAAA): ");
    String fecha = leer.nextLine();
    int nueva_cantidad = 0;
    
    if (tipo.equals("parcial")) {
        System.out.print("Cantidad a agregar: ");
        int extra = leer.nextInt();
        nueva_cantidad = p.getCantidad() + extra;
        p.setCantidad(nueva_cantidad);
    } else if (tipo.equals("total")) {
        System.out.print("Nueva cantidad total: ");
        nueva_cantidad = leer.nextInt();
        p.setCantidad(nueva_cantidad);

    } else {
        System.out.println("vas con nada, tipo de restablecimiento no valido");
        return;
    }
    String folio = generarFolio();
    Map<String, Object> detalle = new HashMap<>();
    detalle.put("modo", tipo);
    detalle.put("cantidad_final", nueva_cantidad);
    Map<String, Object> datosServicio = new HashMap<>();
    datosServicio.put("tipo", "reabastecimiento");
    datosServicio.put("fecha", fecha);
    datosServicio.put("producto", prod_id);
    datosServicio.put("detalle", detalle);
    servicios_dict.put(folio, datosServicio);
    System.out.println("\nReabastecimiento registrado.");
    imprimir_producto(prod_id);
    imprimir_folio(folio);
}
    // --- 2. MERMA ---
    public static void merma() {
    Scanner leer = new Scanner(System.in);
    System.out.println("\n--- REGISTRO DE MERMA / CADUCIDAD ---");
    System.out.print("Id del producto afectado: ");
    String prod_id = leer.nextLine();
    productos p = buscarProductoEnCatalogo(prod_id);
    if (p == null) {
        System.out.println("El producto no existe");
        return;
    }
    System.out.print("Motivo (caducidad/daño/otro): ");
    String motivo = leer.nextLine().toLowerCase();
    System.out.print("Fecha del registro: ");
    String fecha = leer.nextLine();
    System.out.print("Cantidad retirada: ");
    int cantidad_retirada = leer.nextInt();
    leer.nextLine(); 
    int cantidadActual = p.getCantidad();
    int nueva_cantidad = Math.max(0, cantidadActual - cantidad_retirada);
    
    p.setCantidad(nueva_cantidad);

    String folio = generarFolio();
    
    Map<String, Object> detalle = new HashMap<>();
    detalle.put("motivo", motivo);
    detalle.put("cantidad_retirada", cantidad_retirada);

    Map<String, Object> datosServicio = new HashMap<>();
    datosServicio.put("tipo", "merma");
    datosServicio.put("fecha", fecha);
    datosServicio.put("producto", prod_id);
    datosServicio.put("detalle", detalle);

    servicios_dict.put(folio, datosServicio);

    System.out.println("\nMerma registrada"); //
    imprimir_producto(prod_id);
    imprimir_folio(folio);
}

    // --- 3. LIMPIEZA ---
   public static void limpieza() {
    Scanner leer = new Scanner(System.in);
    System.out.println("\n--- REGISTRO DE LIMPIEZA ---");

    System.out.print("Area limpiada: ");
    String area = leer.nextLine();
    
    System.out.print("Fecha: ");
    String fecha = leer.nextLine();
    
    System.out.print("Persona o empresa que realizo la limpieza: ");
    String encargado = leer.nextLine();
    
    System.out.print("Materiales usados (separados por coma): ");
    String materialesInput = leer.nextLine();

    List<String> listaMateriales = Arrays.asList(materialesInput.split(","));

    String folio = generarFolio();
   
    Map<String, Object> detalle = new HashMap<>();
    detalle.put("area", area);
    detalle.put("encargado", encargado);
    detalle.put("materiales", listaMateriales);
    
    Map<String, Object> datosServicio = new HashMap<>();
    datosServicio.put("tipo", "limpieza");
    datosServicio.put("fecha", fecha);
    datosServicio.put("producto", null); 
    datosServicio.put("detalle", detalle);
    servicios_dict.put(folio, datosServicio);

    System.out.println("\nLimpieza registrada.");
    imprimir_folio(folio); 
}
    // --- 4. RECEPCIÓN ---
    public static void recepcion() {
    Scanner leer = new Scanner(System.in);
    System.out.println("\n--- RECEPCION DE MERCANCiA ---");

    System.out.print("Proveedor: ");
    String proveedor = leer.nextLine();
    System.out.print("Fecha: ");
    String fecha = leer.nextLine();

    List<Map<String, Object>> recibidos = new ArrayList<>();

    System.out.println("\nIngrese los productos recibidos (ID y cantidad). Deje ID vacio para terminar");

    while (true) {
        System.out.print("ID del producto: ");
        String pid = leer.nextLine();
        if (pid.isEmpty()) {
            break;
        }
        productos p = buscarProductoEnCatalogo(pid);

        if (p == null) {
            System.out.println("Producto inexistente en catalogo");
            continue;
        }

        System.out.print("Cantidad recibida: ");
        int cantidad = leer.nextInt();
        leer.nextLine();
        p.setCantidad(p.getCantidad() + cantidad);

        Map<String, Object> itemRecibido = new HashMap<>();
        itemRecibido.put("id", pid);
        itemRecibido.put("cantidad", cantidad);
        recibidos.add(itemRecibido);
    }
    String folio = generarFolio();

    Map<String, Object> detalle = new HashMap<>();
    detalle.put("proveedor", proveedor);
    detalle.put("productos", recibidos);

    Map<String, Object> datosServicio = new HashMap<>();
    datosServicio.put("tipo", "recepcion");
    datosServicio.put("fecha", fecha);
    datosServicio.put("producto", null);
    datosServicio.put("detalle", detalle);

    servicios_dict.put(folio, datosServicio);

    System.out.println("\nRecepcion registrada con exito");
    imprimir_folio(folio);
}
    // --- 5. CAMBIO DE PRECIO ---
    public static void cambio_precio() {
    Scanner leer = new Scanner(System.in);
    System.out.println("\n--- CAMBIO DE PRECIO ---");
    
    System.out.print("ID del producto: ");
    String prod_id = leer.nextLine();
    productos p = buscarProductoEnCatalogo(prod_id);

    if (p == null) {
        System.out.println("Producto no encontrado");
        return;
    }

    System.out.print("Fecha del cambio: ");
    String fecha = leer.nextLine();
    
    System.out.print("Tipo de cambio (promoción/aumento/descuento): ");
    String tipo = leer.nextLine().toLowerCase();

    double precio_anterior = p.getPrecio();
    
    System.out.print("Nuevo precio: ");
    double precio_nuevo = leer.nextDouble();
    leer.nextLine();
    p.setPrecio(precio_nuevo);

    String folio = generarFolio();
    
    Map<String, Object> detalle = new HashMap<>();
    detalle.put("tipo_cambio", tipo);
    detalle.put("precio_anterior", precio_anterior);
    detalle.put("precio_nuevo", precio_nuevo);

    Map<String, Object> datosServicio = new HashMap<>();
    datosServicio.put("tipo", "cambio_precio");
    datosServicio.put("fecha", fecha);
    datosServicio.put("producto", prod_id);
    datosServicio.put("detalle", detalle);

    servicios_dict.put(folio, datosServicio);

    System.out.println("\nCambio de precio registrado");
    
     imprimir_producto(prod_id);
     imprimir_folio(folio);
}
    public static void imprimir_producto(String prod_id) {
    productos p = buscarProductoEnCatalogo(prod_id);

    if (p == null) {
        System.out.println("este producto no existe");
        return;
    }

    System.out.println("\n------------- DATOS DEL PRODUCTO ----------------");
    System.out.printf("%-10s%-20s%-10s%-10s%n", "ID", "Nombre", "Precio", "Cantidad");
    System.out.println("--------------------------------------------------");
    System.out.printf("%-10s%-20s$%-9.2f%-10d%n", 
            p.getId(), 
            p.getProducto(), 
            p.getPrecio(), 
            p.getCantidad());
    System.out.println("--------------------------------------------------");
}
    
    private static void imprimir_folio(String folio) {
        Map<String, Object> d = servicios_dict.get(folio);
        
        if (d == null) {
            System.out.println("Error: Folio no encontrado en el sistema");
            return;
        }

        System.out.println("\n--------------------------------------------------");
        System.out.println("             RESUMEN DE OPERACION");
        System.out.println("--------------------------------------------------");
        System.out.println("FOLIO:    " + folio);
        System.out.println("TIPO:     " + d.get("tipo"));
        System.out.println("FECHA:    " + d.get("fecha"));
        System.out.println("DETALLES: " + d.get("detalle"));
        System.out.println("--------------------------------------------------\n");
    }
    
    }
