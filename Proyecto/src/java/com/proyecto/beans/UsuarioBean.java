/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.beans;

import com.proyecto.dao.UsuarioDAO;
import com.proyecto.model.Usuario;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author azu
 */
@ManagedBean
@SessionScoped
public class UsuarioBean extends BaseBean{

    DataModel usuarios;
    UsuarioDAO helper;
    private Usuario current;
    private int selectedItemIndex;  
    String roles[] = {"", "Administrador", "Coordinador", "Instructor", "Asistente", "Alumno"};

    /**
     * Creates a new instance of UsersController
     */
    public UsuarioBean() {
        helper = new UsuarioDAO();
        recreateModel();
    }
    
    public String[] getRoles() throws Exception{
        return roles;
    }
    
    void recreateModel(){
        usuarios = null;
    }
    
    public String prepareView() throws Exception{
        current = (Usuario) getUsers().getRowData();
        return "form/user";
    }
    public String prepareList(){
        recreateModel();
        return "users";
    }
    
    public String nuevo(){
        current = new Usuario();
        setAction(CREATE);
        return("/form/user");
    }
    
    public String editar(){
        setAction(UPDATE);
        return("/form/user");
    }
    
    public String crear(){
        try {
            helper.create(current);
        } catch (Exception ex) {
            error("errorCrearUsuario","Error al crear el usuario");
        }
        return "users";
    }
    
    public String actualizar(){
        try {
            helper.update(current);
        } catch (Exception ex) {
            error("errorActualizarUsuario","Error al actualizar el usuario");
        }
        return "users";
    }
    
    public void addMessage(String summary, String detail,Severity severity) {
        FacesMessage message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String borrar(){
        current = (Usuario) getUsers().getRowData();
        try{
            helper.delete(current);
            addMessage("Usuario eliminado", "El usuario se ha eliminado con éxito.",FacesMessage.SEVERITY_INFO);
        } catch(Exception ex){
            addMessage("¡Error!","Error al eliminar el usuario",FacesMessage.SEVERITY_ERROR);
            error("errorEliminarUsuario","Error al eliminar el usuario");
        }
        current = null;
        recreateModel();
        return "users";
    }
    
    public DataModel getUsers(){
            try {
                usuarios = new ListDataModel((List) helper.loadAll());
            } catch (Exception ex) {
                addMessage("¡Error!","Error al mostrar los usuarios", FacesMessage.SEVERITY_ERROR);
                error("errorListarUsuarios","Error al mostrar los usuarios");
            }
        return usuarios;
    }
    
    public Usuario getSelected(){
        if(current == null){
            current = new Usuario();
            selectedItemIndex = -1;
        }
        return current;
    }


}
