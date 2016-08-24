/*
 * LoginCommand.java
 *
 * Created on January 4, 2007, 11:21 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.web.command;

/**
 *
 * @author jorismelchior
 */
public class LoginCommand {
    private String username;
    private String password;
    
    /** Creates a new instance of LoginCommand */
    public LoginCommand() {
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
    
}
