/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.beans;

import com.proyecto.dao.MunicipioDAO;
import com.proyecto.model.Municipio;
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
public class MunicipioBean extends BaseBean{

    List estados;
    MunicipioDAO helper;
    private Municipio current;
    private int selectedItemIndex;  

    /**
     * Creates a new instance of UsersController
     */
    public MunicipioBean() {
        helper = new MunicipioDAO();
        recreateModel();
    }
    
    void recreateModel(){
        estados = null;
    }
    
    public String prepareView() throws Exception{
        current = (Municipio) getMunicipios().get(0);
        return "form/user";
    }
    public String prepareList(){
        recreateModel();
        return "form/user";
    }
    
    public String nuevo(){
        current = new Municipio();
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
            error("errorCrearMunicipio","Error al crear el estado");
        }
        return "users";
    }
    
    public String actualizar(){
        try {
            helper.update(current);
        } catch (Exception ex) {
            error("errorActualizarMunicipio","Error al actualizar el estado");
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
            addMessage("Municipio eliminado", "El estado se ha eliminado con éxito.",FacesMessage.SEVERITY_INFO);
        } catch(Exception ex){
            addMessage("¡Error!","Error al eliminar el estado",FacesMessage.SEVERITY_ERROR);
            error("errorEliminarMunicipio","Error al eliminar el estado");
        }
        current = null;
        recreateModel();
        return "users";
    }
    
    public List getMunicipios(){
            try {
                estados = (List) helper.loadAll();
            } catch (Exception ex) {
                addMessage("¡Error!","Error al mostrar los estados", FacesMessage.SEVERITY_ERROR);
                error("errorListarMunicipios","Error al mostrar los estados");
            }
        return estados;
    }
    
    public Municipio getSelected(){
        if(current == null){
            current = new Municipio();
            selectedItemIndex = -1;
        }
        return current;
    }


}
