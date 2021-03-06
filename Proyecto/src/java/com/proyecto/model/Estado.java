package com.proyecto.model;
// Generated 10-mar-2015 17:06:19 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Estado generated by hbm2java
 */
public class Estado  implements java.io.Serializable {


     private Integer idestado;
     private String nombre;
     private Set<Municipio> municipios = new HashSet<Municipio>(0);

    public Estado() {
    }

	
    public Estado(String nombre) {
        this.nombre = nombre;
    }
    public Estado(String nombre, Set<Municipio> municipios) {
       this.nombre = nombre;
       this.municipios = municipios;
    }
   
    public Integer getIdestado() {
        return this.idestado;
    }
    
    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set<Municipio> getMunicipios() {
        return this.municipios;
    }
    
    public void setMunicipios(Set<Municipio> municipios) {
        this.municipios = municipios;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}


