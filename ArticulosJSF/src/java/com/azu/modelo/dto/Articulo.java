/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azu.modelo.dto;

import java.io.Serializable;

/**
 *
 * @author azu
 */
public class Articulo implements Serializable{
    private String claveArticulo;
    private String descripcion;
    private double precio;
    private int existencias;

    public Articulo() {
    }

    public String getClaveArticulo() {
        return claveArticulo;
    }

    public void setClaveArticulo(String claveArticulo) {
        this.claveArticulo = claveArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    @Override
    public String toString() {
        return "Articulo{" + "claveArticulo=" + claveArticulo + ", descripcion=" + descripcion + ", precio=" + precio + ", existencias=" + existencias + '}';
    }
    
}
