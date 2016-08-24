/*
 * MenuItem.java
 *
 * Created on January 11, 2007, 10:06 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.web.util;

/**
 *
 * @author jorismelchior
 */
public class MenuItem {
    private String action;
    private String linkText;
    private Boolean active;
    
    /** Creates a new instance of MenuItem */
    public MenuItem() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format("[MenuItem: action:%s, linkText:%s, active:%s]", action, linkText, active);
    }
    
    
}
