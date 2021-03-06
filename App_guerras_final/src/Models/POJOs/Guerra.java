package Models.POJOs;


// Generated 16 may. 2021 19:18:02 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Guerra generated by hbm2java
 */
@Entity
@Table(name="guerra"
    ,catalog="guerras"
)
public class Guerra  implements java.io.Serializable {

    @Id 
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_guerra", unique=true, nullable=false)
     private Integer idGuerra;
    
    @Column(name="anio_inicio", nullable=false, length=10)
     private String anioInicio;
    
    @Column(name="anio_fin", length=10)
     private String anioFin;
    
    @Column(name="nombre", unique=true, nullable=false, length=50)
     private String nombre;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="guerra")
     private Set contendientes = new HashSet(0);

    public Guerra() {
    }
 
    public Guerra(String anioInicio, String nombre) {
        this.anioInicio = anioInicio;
        this.nombre = nombre;
    }
    
    public Guerra(String anioInicio, String anioFin, String nombre, Set contendientes) {
       this.anioInicio = anioInicio;
       this.anioFin = anioFin;
       this.nombre = nombre;
       this.contendientes = contendientes;
    }
    
    
    public Guerra(Integer idGuerra, String anioInicio, String anioFin, String nombre, Set contendientes) {
       this.idGuerra = idGuerra;
       this.anioInicio = anioInicio;
       this.anioFin = anioFin;
       this.nombre = nombre;
       this.contendientes = contendientes;
    }
    
   

    public Integer getIdGuerra() {
        return this.idGuerra;
    }
    
    public void setIdGuerra(Integer idGuerra) {
        this.idGuerra = idGuerra;
    }

    
    public String getAnioInicio() {
        return this.anioInicio;
    }
    
    public void setAnioInicio(String anioInicio) {
        this.anioInicio = anioInicio;
    }

    
    public String getAnioFin() {
        return this.anioFin;
    }
    
    public void setAnioFin(String anioFin) {
        this.anioFin = anioFin;
    }

    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set getContendientes() {
        return this.contendientes;
    }
    
    public void setContendientes(Set contendientes) {
        this.contendientes = contendientes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.idGuerra);
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
        final Guerra other = (Guerra) obj;
        if (!Objects.equals(this.idGuerra, other.idGuerra)) {
            return false;
        }
        return true;
    }




}


