/*
 * LogoutController.java
 *
 * Created on March 3, 2007, 9:59 AM
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
public class LogoutController implements Controller {
    private String viewName;
    
    /** Creates a new instance of LogoutController */
    public LogoutController() {
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().invalidate();
        ModelAndView mav = new ModelAndView(viewName);
        return mav;
    }

    @Required
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
    
}
