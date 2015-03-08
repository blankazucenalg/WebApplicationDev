package entiendades;
// Generated 8/03/2015 02:43:24 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pendiente generated by hbm2java
 */
@Entity
@Table(name="pendiente"
    ,catalog="srs"
)
public class Pendiente  implements java.io.Serializable {


     private Integer idpendiente;
     private Curso curso;
     private String nombre;
     private Date fechaEntrega;
     private Set alumnoHasPendientes = new HashSet(0);

    public Pendiente() {
    }

	
    public Pendiente(Curso curso, String nombre, Date fechaEntrega) {
        this.curso = curso;
        this.nombre = nombre;
        this.fechaEntrega = fechaEntrega;
    }
    public Pendiente(Curso curso, String nombre, Date fechaEntrega, Set alumnoHasPendientes) {
       this.curso = curso;
       this.nombre = nombre;
       this.fechaEntrega = fechaEntrega;
       this.alumnoHasPendientes = alumnoHasPendientes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idpendiente", unique=true, nullable=false)
    public Integer getIdpendiente() {
        return this.idpendiente;
    }
    
    public void setIdpendiente(Integer idpendiente) {
        this.idpendiente = idpendiente;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="curso", nullable=false)
    public Curso getCurso() {
        return this.curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    
    @Column(name="nombre", nullable=false, length=50)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_entrega", nullable=false, length=0)
    public Date getFechaEntrega() {
        return this.fechaEntrega;
    }
    
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="pendiente")
    public Set getAlumnoHasPendientes() {
        return this.alumnoHasPendientes;
    }
    
    public void setAlumnoHasPendientes(Set alumnoHasPendientes) {
        this.alumnoHasPendientes = alumnoHasPendientes;
    }




}


