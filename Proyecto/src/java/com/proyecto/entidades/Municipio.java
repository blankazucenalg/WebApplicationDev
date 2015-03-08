package com.proyecto.entidades;
// Generated 8/03/2015 05:04:34 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Municipio generated by hbm2java
 */
@Entity
@Table(name="municipio"
    ,catalog="srs"
)
public class Municipio  implements java.io.Serializable {


     private MunicipioId id;
     private Estado estado;
     private String nombre;
     private Set direccions = new HashSet(0);

    public Municipio() {
    }

	
    public Municipio(MunicipioId id, Estado estado, String nombre) {
        this.id = id;
        this.estado = estado;
        this.nombre = nombre;
    }
    public Municipio(MunicipioId id, Estado estado, String nombre, Set direccions) {
       this.id = id;
       this.estado = estado;
       this.nombre = nombre;
       this.direccions = direccions;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idmunicipio", column=@Column(name="idmunicipio", nullable=false) ), 
        @AttributeOverride(name="estadoIdestado", column=@Column(name="estado_idestado", nullable=false) ) } )
    public MunicipioId getId() {
        return this.id;
    }
    
    public void setId(MunicipioId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="estado_idestado", nullable=false, insertable=false, updatable=false)
    public Estado getEstado() {
        return this.estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    
    @Column(name="nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="municipio")
    public Set getDireccions() {
        return this.direccions;
    }
    
    public void setDireccions(Set direccions) {
        this.direccions = direccions;
    }




}


