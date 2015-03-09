package com.proyecto.model;
// Generated 09-mar-2015 17:07:35 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * AlumnoTienePendiente generated by hbm2java
 */
public class AlumnoTienePendiente  implements java.io.Serializable {


     private AlumnoTienePendienteId id;
     private Pendiente pendiente;
     private Usuario usuario;
     private float calificacion;
     private Set<Archivo> archivos = new HashSet<Archivo>(0);

    public AlumnoTienePendiente() {
    }

	
    public AlumnoTienePendiente(AlumnoTienePendienteId id, Pendiente pendiente, Usuario usuario, float calificacion) {
        this.id = id;
        this.pendiente = pendiente;
        this.usuario = usuario;
        this.calificacion = calificacion;
    }
    public AlumnoTienePendiente(AlumnoTienePendienteId id, Pendiente pendiente, Usuario usuario, float calificacion, Set<Archivo> archivos) {
       this.id = id;
       this.pendiente = pendiente;
       this.usuario = usuario;
       this.calificacion = calificacion;
       this.archivos = archivos;
    }
   
    public AlumnoTienePendienteId getId() {
        return this.id;
    }
    
    public void setId(AlumnoTienePendienteId id) {
        this.id = id;
    }
    public Pendiente getPendiente() {
        return this.pendiente;
    }
    
    public void setPendiente(Pendiente pendiente) {
        this.pendiente = pendiente;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public float getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
    public Set<Archivo> getArchivos() {
        return this.archivos;
    }
    
    public void setArchivos(Set<Archivo> archivos) {
        this.archivos = archivos;
    }




}

