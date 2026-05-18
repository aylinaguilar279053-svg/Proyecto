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
    public String materiales;

    public folioedeservicios(int folio, String tipo, String fecha, int productoid, String detalle) {
        this.folio = folio;
        this.tipo = tipo;
        this.fecha = fecha;
        this.productoid = productoid;
        this.detalle = detalle;
        this.materiales = materiales;
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

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.folio;
        hash = 61 * hash + Objects.hashCode(this.tipo);
        hash = 61 * hash + Objects.hashCode(this.fecha);
        hash = 61 * hash + this.productoid;
        hash = 61 * hash + Objects.hashCode(this.detalle);
        hash = 61 * hash + Objects.hashCode(this.materiales);
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
        if (!Objects.equals(this.detalle, other.detalle)) {
            return false;
        }
        return Objects.equals(this.materiales, other.materiales);
    }

    @Override
    public String toString() {
        return "folioedeservicios" + "folio " + folio + "tipo " + tipo + "fecha " + fecha + "producto " + productoid + "detalle " + detalle + "materiales " + materiales;
    }

}