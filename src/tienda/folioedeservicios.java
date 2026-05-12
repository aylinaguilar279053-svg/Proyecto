//* PARA REGSERVICIOS
package tienda;
import java.util.Objects;
public class folioedeservicios{
 public enum reabastecimiento{
     PARCIAL, TOTAL
 }
 public enum tipo {
     MERMA, REABASTECIMIENTO, LIMPIEZA, RECEPCION, CAMBIOPRECIO,IMPRIMIR, FOLIO,
 }
 
  private int folio;
    private String tipo;
    private String fecha;
    private int productoid;
    private String detalle;

    public folioedeservicios(int folio, String tipo, String fecha, int productoid, String detalle) {
        this.folio = folio;
        this.tipo = tipo;
        this.fecha = fecha;
        this.productoid = productoid;
        this.detalle = detalle;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getProductoid() {
        return productoid;
    }

    public void setProductoid(int productoid) {
        this.productoid = productoid;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.folio;
        hash = 37 * hash + Objects.hashCode(this.tipo);
        hash = 37 * hash + Objects.hashCode(this.fecha);
        hash = 37 * hash + this.productoid;
        hash = 37 * hash + Objects.hashCode(this.detalle);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final folioedeservicios other = (folioedeservicios) obj;
        if (this.folio != other.folio) {
            return false;
        }
        if (this.productoid != other.productoid) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return Objects.equals(this.detalle, other.detalle);
    }

    @Override
    public String toString() {
        return "folio " + folio + " tipo " + tipo + " fecha " + fecha + " productoid " + productoid + " detalle " + detalle;
    }

}
