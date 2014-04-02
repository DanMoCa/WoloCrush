
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
@Table(name = "Direcciones", catalog = "gamecrush", schema = "")
@NamedQueries({
    @NamedQuery(name = "Direcciones.findAll",
            query = "SELECT e FROM Direcciones e"),
    @NamedQuery(name = "Direcciones.findById",
            query = "SELECT e FROM Direcciones e WHERE e.idDireccion = :idDireccion"),
    @NamedQuery(name = "Direcciones.findByCodigoPostal",
            query = "SELECT e FROM Direcciones e WHERE e.codigo_postal = :codigo_postal"),
    @NamedQuery(name = "Direcciones.findByCalle",
            query = "SELECT e FROM Direcciones e WHERE e.calle = :calle"),
    @NamedQuery(name = "Direcciones.findByColonia",
            query = "SELECT e FROM Direcciones e WHERE e.colonia = :colonia"),
    @NamedQuery(name = "Direcciones.findByPais",
            query = "SELECT e FROM Direcciones e WHERE e.pais = :pais"),
    @NamedQuery(name = "Direcciones.findByEstado",
            query = "SELECT e FROM Direcciones e WHERE e.estado = :estado"),
    @NamedQuery(name = "Direcciones.findByCiudad",
            query = "SELECT e FROM Direcciones e WHERE e.ciudad = :ciudad"),
})
public class Direcciones implements Serializable{
  @Transient
  private PropertyChangeSupport changeSupport;
  private static final long SerialVersionUID = 1;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  
  //Atributos Empleados
  @Basic(optional = false)
  @Column(name = "idDireccion")
  private Integer idDireccion;
  @Basic(optional = false)
  @Lob
  @Column(name = "codigo_postal")
  private Integer codigo_postal;
  @Basic(optional = false)
  @Column(name = "idClientes")
  private Integer idClientes;
  @Basic(optional = false)
  @Column(name = "calle")
  private String calle;
  @Basic(optional = false)
  @Column(name = "colonia")
  private String colonia;
  @Basic(optional = false)
  @Column(name = "num_interior")
  private String num_interior;
  @Basic(optional = false)
  @Column(name = "num_exterior")
  private String num_exterior;
  @Basic(optional = false)
  @Column(name = "estado")
  private String estado;
  @Basic(optional = false)
  @Column(name = "pais")
  private String pais;
  @Basic(optional = false)
  @Column(name = "ciudad")
  private String ciudad;

    //Metodos Constructores
    public Direcciones() {
    }

    public Direcciones(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Direcciones(Integer idDireccion, Integer codigo_postal, Integer idClientes, String calle, String colonia, String num_interior, String num_exterior, String estado, String pais) {
        this.idDireccion = idDireccion;
        this.codigo_postal = codigo_postal;
        this.idClientes = idClientes;
        this.calle = calle;
        this.colonia = colonia;
        this.num_interior = num_interior;
        this.num_exterior = num_exterior;
        this.estado = estado;
        this.pais = pais;
    }
    
    //Metodos Get & Set
    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        Integer oldIdDireccion = this.idDireccion;
        this.idDireccion = idDireccion;
        changeSupport.firePropertyChange("idDireccion", oldIdDireccion, idDireccion);
    }

    public Integer getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(Integer codigo_postal) {
        Integer oldCodigoPostal = this.codigo_postal;
        this.codigo_postal = codigo_postal;
        changeSupport.firePropertyChange("codigo_postal", oldCodigoPostal, codigo_postal);
    }

    public Integer getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Integer idClientes) {
        Integer oldIdClientes = this.idClientes;
        this.idClientes = idClientes;
        changeSupport.firePropertyChange("idClientes", oldIdClientes, idClientes);
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        String oldCalle = this.calle;
        this.calle = calle;
        changeSupport.firePropertyChange("calle", oldCalle, calle);
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        String oldColonia = this.colonia;
        this.colonia = colonia;
        changeSupport.firePropertyChange("colonia", oldColonia, colonia);
    }

    public String getNum_interior() {
        return num_interior;
    }

    public void setNum_interior(String num_interior) {
        String oldNumInt = this.num_interior;
        this.num_interior = num_interior;
        changeSupport.firePropertyChange("num_interior", oldNumInt, num_interior);
    }

    public String getNum_exterior() {
        return num_exterior;
    }

    public void setNum_exterior(String num_exterior) {
        String oldNumExt = this.num_exterior;
        this.num_exterior = num_exterior;
        changeSupport.firePropertyChange("num_ext", oldNumExt, num_exterior);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String oldEstado = this.estado;
        this.estado = estado;
        changeSupport.firePropertyChange("estado", oldEstado, estado);
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        String oldPais = this.pais;
        this.pais = pais;
        changeSupport.firePropertyChange("pais",oldPais,pais);
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        String oldCiudad = this.ciudad;
        this.ciudad = ciudad;
        changeSupport.firePropertyChange("ciudad", oldCiudad, ciudad);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.idDireccion);
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
        final Direcciones other = (Direcciones) obj;
        if (!Objects.equals(this.idDireccion, other.idDireccion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Direcciones{" + "idDireccion=" + idDireccion + '}';
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener){
        changeSupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener){
        changeSupport.removePropertyChangeListener(listener);
    }
  
}
