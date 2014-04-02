/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamecrush;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Dan 14z
 */

@Entity
@Table(name = "Productos", catalog = "gamecrush", schema = "")
@NamedQueries({
    @NamedQuery(name = "Productos.finByIdProducto",
            query = "SELECT e FROM Productos e WHERE e.idProductos = :idProductos"),
    @NamedQuery(name = "Productos.findByNombreProducto",
            query = "SELECT e FROM Productos e WHERE e.nombre_producto = :nombre_producto"),
    @NamedQuery(name = "Productos.findByTipo",
            query = "SELECT e FROM Productos e WHERE e.tipo = :tipo"),
    @NamedQuery(name = "Productos.findByProveedor",
            query = "SELECT e FROM Productos e WHERE e.proveedor = :proveedor")
})

public class Productos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //Atributos Productos
    @Basic(optional = false)
    @Column(name = "idProductos")
    private Integer idProductos;
    @Basic(optional = false)
    @Lob
    @Column(name = "nombre_producto")
    private String nombre_producto;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "precio")
    private Double precio;
    @Basic(optional = false)
    @Column(name = "proveedor")
    private String proveedor;

    
    //Metodos Constructores
    public Productos() {
    }

    public Productos(Integer idProductos) {
        this.idProductos = idProductos;
    }

    public Productos(Integer idProductos, String nombre_producto, String tipo, Double precio, String proveedor) {
        this.idProductos = idProductos;
        this.nombre_producto = nombre_producto;
        this.tipo = tipo;
        this.precio = precio;
        this.proveedor = proveedor;
    }

    
    //Metodos Get & Set
    public Integer getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Integer idProductos) {
        Integer oldIdProductos = this.idProductos;
        this.idProductos = idProductos;
        changeSupport.firePropertyChange("idProductos", oldIdProductos, idProductos);
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        String oldNombre_Producto = this.nombre_producto;
        this.nombre_producto = nombre_producto;
        changeSupport.firePropertyChange("nombre_producto", oldNombre_Producto, nombre_producto);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        Double oldPrecio = this.precio;
        this.precio = precio;
        changeSupport.firePropertyChange("precio", oldPrecio, precio);
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        String oldProveedor = this.proveedor;
        this.proveedor = proveedor;
        changeSupport.firePropertyChange("proveedor", oldProveedor, proveedor);
    }

    @Override
    public String toString() {
        return "gamecrush.Productos{" + "idProductos=" + idProductos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idProductos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Productos other = (Productos) obj;
        if (!Objects.equals(this.idProductos, other.idProductos)) {
            return false;
        }
        return true;
    }
    
     public void addPropertyChangeListener(PropertyChangeListener listener){
        changeSupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener){
        changeSupport.removePropertyChangeListener(listener);
    }
    
    
}
