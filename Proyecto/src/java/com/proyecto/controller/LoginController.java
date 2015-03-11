/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.controller;

import com.proyecto.dao.UsuarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author azu
 */
@ManagedBean
@SessionScoped
public class LoginController {
    
    private String user;
    private String password;
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
        UsuarioDAO userDao = new UsuarioDAO();
        
        
    }
    
    
    
}
