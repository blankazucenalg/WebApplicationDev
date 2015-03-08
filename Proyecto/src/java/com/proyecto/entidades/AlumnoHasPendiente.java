package com.proyecto.entidades;
// Generated 8/03/2015 05:04:34 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AlumnoHasPendiente generated by hbm2java
 */
@Entity
@Table(name="alumno_has_pendiente"
    ,catalog="srs"
)
public class AlumnoHasPendiente  implements java.io.Serializable {


     private AlumnoHasPendienteId id;
     private Pendiente pendiente;
     private Usuario usuario;
     private float calificacion;

    public AlumnoHasPendiente() {
    }

    public AlumnoHasPendiente(AlumnoHasPendienteId id, Pendiente pendiente, Usuario usuario, float calificacion) {
       this.id = id;
       this.pendiente = pendiente;
       this.usuario = usuario;
       this.calificacion = calificacion;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="usuarioIdalumno", column=@Column(name="usuario_idalumno", nullable=false) ), 
        @AttributeOverride(name="pendienteIdpendiente", column=@Column(name="pendiente_idpendiente", nullable=false) ) } )
    public AlumnoHasPendienteId getId() {
        return this.id;
    }
    
    public void setId(AlumnoHasPendienteId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pendiente_idpendiente", nullable=false, insertable=false, updatable=false)
    public Pendiente getPendiente() {
        return this.pendiente;
    }
    
    public void setPendiente(Pendiente pendiente) {
        this.pendiente = pendiente;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_idalumno", nullable=false, insertable=false, updatable=false)
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="calificacion", nullable=false, precision=12, scale=0)
    public float getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }




}

