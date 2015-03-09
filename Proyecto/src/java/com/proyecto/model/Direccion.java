package com.proyecto.model;
// Generated 09-mar-2015 16:13:19 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Direccion generated by hbm2java
 */
@Entity
@Table(name="direccion"
    ,catalog="srs"
)
public class Direccion  implements java.io.Serializable {


     private Integer iddireccion;
     private Municipio municipio;
     private Usuario usuario;
     private String calle;
     private String noExterior;
     private String noInterior;
     private String colonia;
     private String cp;

    public Direccion() {
    }

	
    public Direccion(Municipio municipio, Usuario usuario, String calle, String colonia, String cp) {
        this.municipio = municipio;
        this.usuario = usuario;
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
    }
    public Direccion(Municipio municipio, Usuario usuario, String calle, String noExterior, String noInterior, String colonia, String cp) {
       this.municipio = municipio;
       this.usuario = usuario;
       this.calle = calle;
       this.noExterior = noExterior;
       this.noInterior = noInterior;
       this.colonia = colonia;
       this.cp = cp;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="iddireccion", unique=true, nullable=false)
    public Integer getIddireccion() {
        return this.iddireccion;
    }
    
    public void setIddireccion(Integer iddireccion) {
        this.iddireccion = iddireccion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idmunicipio", nullable=false)
    public Municipio getMunicipio() {
        return this.municipio;
    }
    
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idusuario", nullable=false)
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="calle", nullable=false, length=45)
    public String getCalle() {
        return this.calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }

    
    @Column(name="no_exterior", length=45)
    public String getNoExterior() {
        return this.noExterior;
    }
    
    public void setNoExterior(String noExterior) {
        this.noExterior = noExterior;
    }

    
    @Column(name="no_interior", length=45)
    public String getNoInterior() {
        return this.noInterior;
    }
    
    public void setNoInterior(String noInterior) {
        this.noInterior = noInterior;
    }

    
    @Column(name="colonia", nullable=false, length=45)
    public String getColonia() {
        return this.colonia;
    }
    
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    
    @Column(name="cp", nullable=false, length=45)
    public String getCp() {
        return this.cp;
    }
    
    public void setCp(String cp) {
        this.cp = cp;
    }




}


