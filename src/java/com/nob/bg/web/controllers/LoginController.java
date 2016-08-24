/*
 * LoginController.java
 *
 * Created on January 6, 2007, 11:26 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.nob.bg.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nob.bg.model.BikeRider;
import com.nob.bg.model.dto.LoginDTO;
import com.nob.bg.service.BikeGearsService;
import com.nob.bg.web.util.BikeGearSession;
import org.springframework.beans.factory.annotation.Required;

/**
 *
 * @author jorismelchior
 */
public class LoginController extends SimpleFormController {

    private BikeGearsService service;

    /** Creates a new instance of LoginController */
    public LoginController() {
    }

    @Required
    public void setService(BikeGearsService service) {
        this.service = service;
    }
    
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        return new ModelAndView(this.getSuccessView());
    }

    @Override
    protected void onBindAndValidate(HttpServletRequest request, Object command,
            BindException errors) throws Exception {
        LoginDTO lc = (LoginDTO) command;
        BikeRider zeOne = service.login(lc);
        if (zeOne == null) {
            errors.rejectValue("userName", "login.error.nosuchuser");
        } else {
            BikeGearSession bgSession = new BikeGearSession();
            bgSession.setBikeRider(zeOne);
            request.getSession(true).setAttribute("bgSession", bgSession);
        }
    }
}
