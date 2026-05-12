package tienda;
import java.util.Objects;
public class productos {  
public int id;
private String producto;
private double precio;
private int cantidad;

    public productos(int id, String producto, double precio, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.producto);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 41 * hash + this.cantidad;
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
        final productos other = (productos) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        return Objects.equals(this.producto, other.producto);
    }

    @Override
    public String toString() {
        return "productos:" + "id: " + id + " producto: " + producto + " precio: " + precio + " cantidad: " + cantidad;
    }

}
     

