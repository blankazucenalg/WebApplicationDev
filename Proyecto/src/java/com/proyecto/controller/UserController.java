/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.controller;

import com.proyecto.dao.UsuarioDAO;
import com.proyecto.model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author azu
 */
@ManagedBean
@SessionScoped
public class UserController {

    int startId;
    int endId;
    DataModel users;
    UsuarioDAO helper;
    private int recordCount = 1000;
    private int pageSize = 10;
    private Usuario current;
    private int selectedItemIndex;
    String roles[] = {"", "Administrador", "Coordinador", "Instructor", "Asistente", "Alumno"};

    /**
     * Creates a new instance of UsersController
     */
    public UserController() {
        helper = new UsuarioDAO();
        startId = 1;
        endId = 10;
    }

    public UserController(int startId, int endId) {
        helper = new UsuarioDAO();
        this.startId = startId;
        this.endId = endId;
    }
    
    public Usuario getSelected(){
        if(current == null){
            current = new Usuario();
            selectedItemIndex = -1;
        }
        return current;
    }
    
    public DataModel getUsers() throws Exception{
        if(users == null){
            users = new ListDataModel((List) helper.loadAll(startId, endId));
        }
        return users;
    }
    
    public String[] getRoles() throws Exception{
        return roles;
    }
    
    void recreateModel(){
        users = null;
    }
    
    public boolean isHasNextPage(){
        if(endId + pageSize <= recordCount){
            return true;
        }
        return false;
    }
    
    public boolean isHasPreviousPage(){
        if(startId - pageSize > 0){
            return true;
        }
        return false;
    }
    
    public String next() {
        startId = endId+1;
        endId = endId + pageSize;
        recreateModel();
        return "users";
    }

    public String previous() {
        startId = startId - pageSize;
        endId = endId - pageSize;
        recreateModel();
        return "users";
    }

    public int getPageSize() {
        return pageSize;
    }

    public String prepareView() throws Exception{
        current = (Usuario) getUsers().getRowData();
        return "form/user";
    }
    public String prepareList(){
        recreateModel();
        return "users";
    }

}
