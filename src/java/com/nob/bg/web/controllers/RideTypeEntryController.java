/*
 * RideTypeEntryController.java
 *
 * Created on March 3, 2007, 9:33 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.nob.bg.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nob.bg.model.BikeRideType;
import com.nob.bg.service.BikeGearsService;

/**
 *
 * @author jorismelchior
 */
public class RideTypeEntryController extends SimpleFormController {

    private BikeGearsService service;

    /** Creates a new instance of RideTypeEntryController */
    public RideTypeEntryController() {
    }

    @Required
    public void setService(BikeGearsService service) {
        this.service = service;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        BikeRideType rideType = (BikeRideType) command;
        if (rideType.getId() == null) {
            service.createBikeRideType(rideType);
        } else {
            service.changeBikeRideType(rideType);
        }
        return new ModelAndView(this.getSuccessView());
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws 
            Exception {
        if (request.getParameter("id") != null && request.getParameter("id").
                trim().length() > 0 && !request.getParameter("id").equals("0")) {
            Long bikeTypeId = Long.parseLong(request.getParameter("id"));
            BikeRideType rideType = service.getBikeRideTypeById(bikeTypeId);
            return rideType;
        } else {
            return new BikeRideType();
        }
    }
}
