/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.beans;

import com.proyecto.dao.EstadoDAO;
import com.proyecto.model.Estado;
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
public class EstadoBean extends BaseBean{

    List estados;
    EstadoDAO helper;
    private Estado current;
    private int selectedItemIndex;  

    /**
     * Creates a new instance of UsersController
     */
    public EstadoBean() {
        helper = new EstadoDAO();
        recreateModel();
    }
    
    void recreateModel(){
        estados = null;
    }
    
    public String prepareView() throws Exception{
        current = (Estado) getStates().get(0);
        return "form/user";
    }
    public String prepareList(){
        recreateModel();
        return "form/user";
    }
    
    public String nuevo(){
        current = new Estado();
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
            error("errorCrearEstado","Error al crear el estado");
        }
        return "users";
    }
    
    public String actualizar(){
        try {
            helper.update(current);
        } catch (Exception ex) {
            error("errorActualizarEstado","Error al actualizar el estado");
        }
        return "users";
    }
    
    public void addMessage(String summary, String detail,Severity severity) {
        FacesMessage message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String borrar(){
        try{
            helper.delete(current);
            addMessage("Estado eliminado", "El estado se ha eliminado con éxito.",FacesMessage.SEVERITY_INFO);
        } catch(Exception ex){
            addMessage("¡Error!","Error al eliminar el estado",FacesMessage.SEVERITY_ERROR);
            error("errorEliminarEstado","Error al eliminar el estado");
        }
        current = null;
        recreateModel();
        return "users";
    }
    
    public List getStates(){
            try {
                estados = (List) helper.loadAll();
            } catch (Exception ex) {
                addMessage("¡Error!","Error al mostrar los estados", FacesMessage.SEVERITY_ERROR);
                error("errorListarEstados","Error al mostrar los estados");
            }
        return estados;
    }
    
    public Estado getSelected(){
        if(current == null){
            current = new Estado();
            selectedItemIndex = -1;
        }
        return current;
    }


}
