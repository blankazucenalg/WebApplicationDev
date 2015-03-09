/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;
import com.proyecto.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Toño Castro
 */
public interface UsuarioDao {
    public List <Usuario> mostrarPersonas();
    public void insertarUsuario (Usuario usuario);
    public void modifcarUsuario (Usuario usuario);
    public void EliminarUsuario (Usuario usuario);
 
    


}
