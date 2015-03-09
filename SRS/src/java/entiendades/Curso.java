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
 * Curso generated by hbm2java
 */
@Entity
@Table(name="curso"
    ,catalog="srs"
)
public class Curso  implements java.io.Serializable {


     private Integer idcurso;
     private Asignatura asignatura;
     private Usuario usuario;
     private String nombre;
     private Date fechaInicio;
     private String fechaFin;
     private String ubicacion;
     private String horario;
     private float precio;
     private Set pendientes = new HashSet(0);

    public Curso() {
    }

	
    public Curso(Asignatura asignatura, Usuario usuario, String nombre, Date fechaInicio, String ubicacion, String horario, float precio) {
        this.asignatura = asignatura;
        this.usuario = usuario;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.precio = precio;
    }
    public Curso(Asignatura asignatura, Usuario usuario, String nombre, Date fechaInicio, String fechaFin, String ubicacion, String horario, float precio, Set pendientes) {
       this.asignatura = asignatura;
       this.usuario = usuario;
       this.nombre = nombre;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.ubicacion = ubicacion;
       this.horario = horario;
       this.precio = precio;
       this.pendientes = pendientes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idcurso", unique=true, nullable=false)
    public Integer getIdcurso() {
        return this.idcurso;
    }
    
    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="asignatura_idasignatura", nullable=false)
    public Asignatura getAsignatura() {
        return this.asignatura;
    }
    
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_idinstructor", nullable=false)
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_inicio", nullable=false, length=0)
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    
    @Column(name="fecha_fin", length=45)
    public String getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    
    @Column(name="ubicacion", nullable=false, length=50)
    public String getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    
    @Column(name="horario", nullable=false, length=45)
    public String getHorario() {
        return this.horario;
    }
    
    public void setHorario(String horario) {
        this.horario = horario;
    }

    
    @Column(name="precio", nullable=false, precision=12, scale=0)
    public float getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="curso")
    public Set getPendientes() {
        return this.pendientes;
    }
    
    public void setPendientes(Set pendientes) {
        this.pendientes = pendientes;
    }




}


