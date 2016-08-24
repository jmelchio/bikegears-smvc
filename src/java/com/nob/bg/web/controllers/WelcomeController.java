/*
 * WelcomeController.java
 *
 * Created on December 15, 2006, 4:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author jorismelchior
 */
public class WelcomeController implements Controller {
    private String viewName;
    
    /** Creates a new instance of WelcomeController */
    public WelcomeController() {
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("nut");
        return mav;
    }

    @Required
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
    
}
