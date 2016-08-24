/*
 * RiderEntryController.java
 *
 * Created on March 3, 2007, 9:32 AM
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

import com.nob.bg.model.BikeRider;
import com.nob.bg.service.BikeGearsService;

/**
 *
 * @author jorismelchior
 */
public class RiderEntryController extends SimpleFormController {

    private BikeGearsService service;

    /** Creates a new instance of RiderEntryController */
    public RiderEntryController() {
    }

    @Required
    public void setService(BikeGearsService service) {
        this.service = service;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        BikeRider rider = (BikeRider) command;
        if (rider.getId() == null) {
            service.createBikeRider(rider);
        } else {
            service.changeBikeRider(rider);
        }
        //TODO: need to check if we need to update the bikerider in the session as well
        return new ModelAndView(this.getSuccessView());
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws 
            Exception {
        if (request.getParameter("id") != null && request.getParameter("id").
                trim().length() > 0 && !request.getParameter("id").equals("0")) {
            Long bikeRiderId = Long.parseLong(request.getParameter("id"));
            BikeRider bikeRider = service.getBikeRiderById(bikeRiderId);
            return bikeRider;
        } else {
            return new BikeRider();
        }
    }
}
