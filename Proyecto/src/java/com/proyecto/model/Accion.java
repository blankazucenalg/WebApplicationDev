package com.proyecto.model;
// Generated 10-mar-2015 15:08:19 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Accion generated by hbm2java
 */
public class Accion  implements java.io.Serializable {


     private Integer idaccion;
     private String nombre;
     private Set<Historico> historicos = new HashSet<Historico>(0);

    public Accion() {
    }

	
    public Accion(String nombre) {
        this.nombre = nombre;
    }
    public Accion(String nombre, Set<Historico> historicos) {
       this.nombre = nombre;
       this.historicos = historicos;
    }
   
    public Integer getIdaccion() {
        return this.idaccion;
    }
    
    public void setIdaccion(Integer idaccion) {
        this.idaccion = idaccion;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set<Historico> getHistoricos() {
        return this.historicos;
    }
    
    public void setHistoricos(Set<Historico> historicos) {
        this.historicos = historicos;
    }




}


