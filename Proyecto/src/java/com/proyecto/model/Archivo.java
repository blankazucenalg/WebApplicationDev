package com.proyecto.model;
// Generated 09-mar-2015 17:07:35 by Hibernate Tools 4.3.1



/**
 * Archivo generated by hbm2java
 */
public class Archivo  implements java.io.Serializable {


     private Integer idarchivo;
     private AlumnoTienePendiente alumnoTienePendiente;
     private String nombre;
     private String ubicacion;

    public Archivo() {
    }

    public Archivo(AlumnoTienePendiente alumnoTienePendiente, String nombre, String ubicacion) {
       this.alumnoTienePendiente = alumnoTienePendiente;
       this.nombre = nombre;
       this.ubicacion = ubicacion;
    }
   
    public Integer getIdarchivo() {
        return this.idarchivo;
    }
    
    public void setIdarchivo(Integer idarchivo) {
        this.idarchivo = idarchivo;
    }
    public AlumnoTienePendiente getAlumnoTienePendiente() {
        return this.alumnoTienePendiente;
    }
    
    public void setAlumnoTienePendiente(AlumnoTienePendiente alumnoTienePendiente) {
        this.alumnoTienePendiente = alumnoTienePendiente;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }




}


