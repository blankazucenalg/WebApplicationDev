package com.proyecto.model;
// Generated 09-mar-2015 17:07:35 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Pendiente generated by hbm2java
 */
public class Pendiente  implements java.io.Serializable {


     private Integer idpendiente;
     private Curso curso;
     private String nombre;
     private Date fechaEntrega;
     private Set<AlumnoTienePendiente> alumnoTienePendientes = new HashSet<AlumnoTienePendiente>(0);

    public Pendiente() {
    }

	
    public Pendiente(Curso curso, String nombre, Date fechaEntrega) {
        this.curso = curso;
        this.nombre = nombre;
        this.fechaEntrega = fechaEntrega;
    }
    public Pendiente(Curso curso, String nombre, Date fechaEntrega, Set<AlumnoTienePendiente> alumnoTienePendientes) {
       this.curso = curso;
       this.nombre = nombre;
       this.fechaEntrega = fechaEntrega;
       this.alumnoTienePendientes = alumnoTienePendientes;
    }
   
    public Integer getIdpendiente() {
        return this.idpendiente;
    }
    
    public void setIdpendiente(Integer idpendiente) {
        this.idpendiente = idpendiente;
    }
    public Curso getCurso() {
        return this.curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFechaEntrega() {
        return this.fechaEntrega;
    }
    
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    public Set<AlumnoTienePendiente> getAlumnoTienePendientes() {
        return this.alumnoTienePendientes;
    }
    
    public void setAlumnoTienePendientes(Set<AlumnoTienePendiente> alumnoTienePendientes) {
        this.alumnoTienePendientes = alumnoTienePendientes;
    }




}

