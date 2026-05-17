package tienda;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ListadosOpciones78Test {

    public static void main(String[] args) {
        probarListadoServiciosBase();
        probarListadoServiciosVacio();
        probarListadoServiciosConDatos();
        probarMaterialesDisponibles();
        System.out.println("OK");
    }

    private static void probarListadoServiciosBase() {
        regisservicio.restablecerServiciosBase();

        String salida = capturarSalida(mostrarlistadeservicios::mostrarListadoServicios);

        verificarContiene(salida, "Folio:");
        verificarContiene(salida, "Tipo:");
    }

    private static void probarListadoServiciosVacio() {
        regisservicio.serviciosRegistrados.clear();

        String salida = capturarSalida(mostrarlistadeservicios::mostrarListadoServicios);

        verificarContiene(salida, "No hay servicios registrados");
    }

    private static void probarListadoServiciosConDatos() {
        regisservicio.serviciosRegistrados.clear();
        regisservicio.serviciosRegistrados.add(
                new folioedeservicios(101, "LIMPIEZA", "2026-05-15", 1, "Limpieza general")
        );

        String salida = capturarSalida(mostrarlistadeservicios::mostrarListadoServicios);

        verificarContiene(salida, "101");
        verificarContiene(salida, "LIMPIEZA");
        verificarContiene(salida, "Limpieza general");
    }

    private static void probarMaterialesDisponibles() {
        String salida = capturarSalida(Materialesdisponibles::mostrarMaterialesDisponibles);

        verificarContiene(salida, "Manzana");
        verificarContiene(salida, "Cantidad");
        verificarContiene(salida, "Precio");
    }

    private static String capturarSalida(Runnable accion) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream temporal;
        try {
            temporal = new PrintStream(buffer, true, "UTF-8");
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo preparar la captura de salida", ex);
        }
        System.setOut(temporal);
        try {
            accion.run();
        } finally {
            System.setOut(original);
        }
        try {
            return buffer.toString("UTF-8");
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo leer la salida capturada", ex);
        }
    }

    private static void verificarContiene(String salida, String esperado) {
        if (!salida.contains(esperado)) {
            throw new AssertionError("No se encontro '" + esperado + "' en la salida:\n" + salida);
        }
    }
}
