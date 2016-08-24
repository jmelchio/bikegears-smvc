/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nob.bg.web.controllers;

import java.beans.PropertyEditor;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nob.bg.model.BikeRide;
import com.nob.bg.service.BikeGearsService;

/**
 *
 * @author jorismelchior
 */
public class RideDeleteController extends SimpleFormController {
    private BikeGearsService service;
    private PropertyEditor dateEditor;
    
    public RideDeleteController() {
        
    }

    @Required
    public void setService(BikeGearsService service) {
        this.service = service;
    }
    
    @Required
    public void setDateEditor(PropertyEditor dateEditor) {
        this.dateEditor = dateEditor;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        if(request.getParameter("id") != null 
                && request.getParameter("id").trim().length() > 0 
                && !request.getParameter("id").equals("0")) {
            Long rideId = Long.parseLong(request.getParameter("id"));
            BikeRide ride = service.getBikeRideById(rideId);
            return ride;
        } else {
            return new BikeRide();
        }
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        BikeRide ride = (BikeRide) command;
        service.deleteBikeRide(ride);
        
        return new ModelAndView(this.getSuccessView());
    }
    
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        super.initBinder(request, binder);
        binder.registerCustomEditor(Date.class, dateEditor);
    }
}
/* That's All Folks !! */