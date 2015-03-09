package com.proyecto.model;
// Generated 09-mar-2015 17:07:35 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Curso generated by hbm2java
 */
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
     private Set<Pendiente> pendientes = new HashSet<Pendiente>(0);

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
    public Curso(Asignatura asignatura, Usuario usuario, String nombre, Date fechaInicio, String fechaFin, String ubicacion, String horario, float precio, Set<Pendiente> pendientes) {
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
   
    public Integer getIdcurso() {
        return this.idcurso;
    }
    
    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }
    public Asignatura getAsignatura() {
        return this.asignatura;
    }
    
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getHorario() {
        return this.horario;
    }
    
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public float getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public Set<Pendiente> getPendientes() {
        return this.pendientes;
    }
    
    public void setPendientes(Set<Pendiente> pendientes) {
        this.pendientes = pendientes;
    }




}


