/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicecentermanagementfx.entities;

import servicecentermanagementfx.old_gui.MD5;

/**
 *
 * @author Vitalie
 */
public class User {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String username;

    public User() {
    }

    public User(String name, String surname, String email, String password, String username) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPasswordMD5() {
        String passwordMD5;
        passwordMD5 = MD5.getMD5(this.password);
        return passwordMD5;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
