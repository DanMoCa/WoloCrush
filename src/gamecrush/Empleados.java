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
@Table(name = "Empleados", catalog = "gamecrush", schema = "")
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", 
            query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByIdEmpleado", 
            query = "SELECT e FROM Empleados e WHERE e.idEmpleados = :idempleado"),
    @NamedQuery(name = "Empleados.findByNombre", 
            query = "SELECT e FROM Empleados e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleados.findByTelefono", 
            query = "SELECT e FROM Empleados e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Empleados.findByApellidoP", 
            query = "SELECT e FROM Empleados e WHERE e.apellido_p = :apellido_p"),
    @NamedQuery(name = "Empleados.findByApellidoM", 
            query = "SELECT e FROM Empleados e WHERE e.apellido_m = :apellido_m"),
    @NamedQuery(name = "Empleados.findByPuesto", 
            query = "SELECT e FROM Empleados e WHERE e.idPuesto = :idPuesto"),
    
    
    
})
public class Empleados implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //Atributos Empleados
    @Basic(optional = false)
    @Column(name = "idEmpleado")
    private Integer idEmpleados;
    @Basic(optional = false)
    @Lob
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "apellido_p")
    private String apellido_p;
    @Basic(optional = false)
    @Lob
    @Column(name = "apellido_m")
    private String apellido_m;
    @Basic(optional = false)
    @Lob
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Lob
    @Column(name = "idPuesto")
    private Integer idPuesto;
    
    
    public Empleados(){
        this.changeSupport = new PropertyChangeSupport(this);
        
    }
    
    public Empleados(Integer idEmpleados){
        this.changeSupport = new PropertyChangeSupport(this);
        this.idEmpleados = idEmpleados;
    }

    public Empleados(Integer idEmpleados, String nombre, String apellido_p, String apellido_m, String telefono, Integer idPuesto) {
        this.changeSupport = new PropertyChangeSupport(this);
        this.idEmpleados = idEmpleados;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.telefono = telefono;
        this.idPuesto = idPuesto;
    }

    public Integer getIdEmpleados() {
        return idEmpleados;
    }

    public void setIdEmpleados(Integer idEmpleados) {
        Integer oldIdEmpleado = this.idEmpleados;
        this.idEmpleados = idEmpleados;
        changeSupport.firePropertyChange("idEmpleado", oldIdEmpleado, idEmpleados);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
        
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        String oldApellido_P = this.apellido_p;                
        this.apellido_p = apellido_p;
        changeSupport.firePropertyChange("apellido_p", oldApellido_P, apellido_p);
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        String oldApellido_M = this.apellido_m;
        this.apellido_m = apellido_m;
        changeSupport.firePropertyChange("apellido_m", oldApellido_M, apellido_m);
    }

    public String getTelefono() {
        
        return telefono;
        
    }

    public void setTelefono(String telefono) {
        String oldTelefono = this.telefono;
        this.telefono = telefono;
        changeSupport.firePropertyChange("telefono", oldTelefono, telefono);
    }

    public Integer getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Integer idPuesto) {
        Integer oldIdPuesto = this.idPuesto;
        this.idPuesto = idPuesto;
        changeSupport.firePropertyChange("idPuesto", oldIdPuesto, idPuesto);
    }

    @Override
    public String toString() {
        return "gamecrush.Empleados{" + "idEmpleados=" + idEmpleados + '}';
    }
   
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idEmpleados);
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
        final Empleados other = (Empleados) obj;
        if (!Objects.equals(this.idEmpleados, other.idEmpleados)) {
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
