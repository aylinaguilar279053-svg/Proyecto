package tienda;
public class EntradaInvalidaExcepcion extends Exception {
    //* mensaje de error para el try catch
    //*excepcion propia
  public EntradaInvalidaExcepcion(String message){
      super("Solo se permiten numeros");
  } 
    
}
