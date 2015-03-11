/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author azu
 */
public class BaseBean {

    protected static final String CREATE = "CREAR";
    protected static final String UPDATE = "ACTUALIZAR";

    protected String action;

    public BaseBean() {
    }

    protected void error(String idMensaje, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(
                idMensaje,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje,
                        idMensaje));
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public boolean isCreateMode() {
        if (action != null) {
            return action.equals(CREATE);
        } else {
            return false;
        }
    }

    public boolean isUpdateMode() {
        if (action != null) {
            return action.equals(UPDATE);
        } else {
            return false;
        }

    }
}
