/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejer1;

/**
 *
 * @author azu
 */
public class User {
    private int idUser;
    private String name;
    private String lastname;
    private String surname;
    private String email;
    private String username;
    private String password;
    private int userType;

    public User() {
    }

    public User(int idUser, String name, String lastname, String surname, String email, String username, String password, int userType) {
        this.idUser = idUser;
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
    
    public String toString(){
        return lastname+" "+surname+" "+name;
    }
}
