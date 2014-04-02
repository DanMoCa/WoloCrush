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
@Table(name = "clientes", catalog = "gamecrush", schema = "")
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll",
            query = "SELECT e FROM Clientes e"),
    @NamedQuery(name = "Clientes.findById",
            query = "SELECT e FROM Clientes e WHERE e.idClientes = :idClientes"),
    @NamedQuery(name = "Clientes.findByNombre",
            query = "SELECT e FROM Clientes e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Clientes.findByApellidoP",
            query = "SELECT e FROM Clientes e WHERE e.apellido_p = :apellido_p"),
    @NamedQuery(name = "Clientes.findByApellidoM",
            query = "SELECT e FROM Clientes e WHERE e.apellido_m = :apellido_m"),
    @NamedQuery(name = "Clientes.findByTelefono",
            query = "SELECT e FROM Clientes e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Clientes.findByEmail",
            query = "SELECT e FROM Clientes e WHERE e.email = :email"),
})
public class Clientes implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    
    //Atributos Clientes
    @Basic(optional = false)
    @Column(name = "idClientes")
    private Integer idClientes;
    @Basic(optional = false)
    @Lob
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellido_p")
    private String apellido_p;
    @Basic(optional = false)
    @Column(name = "apellido_m")
    private String apellido_m;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    //Metodos Constructores
    public Clientes() {
    }

    public Clientes(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public Clientes(Integer idClientes, String nombres, String apellido_p, String apellido_m, String telefono, String email) {
        this.idClientes = idClientes;
        this.nombres = nombres;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.telefono = telefono;
        this.email = email;
    }
        
    //Metodos Get & Set
    public Integer getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Clientes{" + "idClientes=" + idClientes + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idClientes);
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
        final Clientes other = (Clientes) obj;
        if (!Objects.equals(this.idClientes, other.idClientes)) {
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