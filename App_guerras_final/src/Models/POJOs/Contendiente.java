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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Contendiente generated by hbm2java
 */
@Entity
@Table(name="contendiente"
    ,catalog="guerras"
)
public class Contendiente  implements java.io.Serializable {

     @Id 
     @GeneratedValue(strategy=IDENTITY)
     @Column(name="id_contendiente", unique=true, nullable=false)
     private Integer idContendiente;
    
     @ManyToOne(fetch=FetchType.LAZY)
     @JoinColumn(name="id_guerra", nullable=false)
     private Guerra guerra;
     
     @Column(name="ganador", nullable=false)
     private int ganador;
     
     @Column(name="nombre", unique=true, nullable=false, length=50)
     private String nombre;
     
     @OneToMany(fetch=FetchType.LAZY, mappedBy="contendiente")
     private Set unionBandoses = new HashSet(0);

     
    public Contendiente() {
    }

	
    public Contendiente(Guerra guerra, int ganador, String nombre) {
        this.guerra = guerra;
        this.ganador = ganador;
        this.nombre = nombre;
    }
    public Contendiente(Guerra guerra, int ganador, String nombre, Set unionBandoses) {
       this.guerra = guerra;
       this.ganador = ganador;
       this.nombre = nombre;
       this.unionBandoses = unionBandoses;
    }
   

    public Integer getIdContendiente() {
        return this.idContendiente;
    }
    
    public void setIdContendiente(Integer idContendiente) {
        this.idContendiente = idContendiente;
    }

    public Guerra getGuerra() {
        return this.guerra;
    }
    
    public void setGuerra(Guerra guerra) {
        this.guerra = guerra;
    }

    
    public int getGanador() {
        return this.ganador;
    }
    
    public void setGanador(int ganador) {
        this.ganador = ganador;
    }

    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set getUnionBandoses() {
        return this.unionBandoses;
    }
    
    public void setUnionBandoses(Set unionBandoses) {
        this.unionBandoses = unionBandoses;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idContendiente);
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
        final Contendiente other = (Contendiente) obj;
        if (!Objects.equals(this.idContendiente, other.idContendiente)) {
            return false;
        }
        return true;
    }




}


