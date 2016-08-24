/*
 * BikeOverviewController.java
 *
 * Created on March 3, 2007, 9:27 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.web.controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.nob.bg.model.Bike;
import com.nob.bg.model.BikeType;
import com.nob.bg.service.BikeGearsService;
import com.nob.bg.web.util.BikeGearSession;

/**
 *
 * @author jorismelchior
 */
public class BikeOverviewController implements Controller {
    private BikeGearsService service;
    private String viewName;
    
    /** Creates a new instance of BikeOverviewController */
    public BikeOverviewController() {
    }

    @Required
    public void setService(BikeGearsService service) {
        this.service = service;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView(viewName);
        BikeGearSession bgSession = (BikeGearSession) request.getSession().getAttribute("bgSession");
        Collection<Bike> bikes = service.getBikesForRider(bgSession.getBikeRider());
        mav.addObject("bikes", bikes);
        Collection<BikeType> biketypes = service.getBikeTypes();
        mav.addObject("biketypes", biketypes);
        return mav;
    }

    @Required
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
    
}
