/*
 * BikeTypeEntryController.java
 *
 * Created on March 3, 2007, 9:30 AM
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

import com.nob.bg.model.BikeType;
import com.nob.bg.service.BikeGearsService;

/**
 *
 * @author jorismelchior
 */
public class BikeTypeEntryController extends SimpleFormController {

    private BikeGearsService service;

    /** Creates a new instance of BikeTypeEntryController */
    public BikeTypeEntryController() {
    }

    @Required
    public void setService(BikeGearsService service) {
        this.service = service;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        BikeType bikeType = (BikeType) command;
        if (bikeType.getId() == null) {
            service.createBikeType(bikeType);
        } else {
            service.changeBikeType(bikeType);
        }
        return new ModelAndView(this.getSuccessView());
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws 
            Exception {
        if (request.getParameter("id") != null && request.getParameter("id").
                trim().length() > 0 && !request.getParameter("id").equals("0")) {
            Long bikeTypeId = Long.parseLong(request.getParameter("id"));
            BikeType bikeType = service.getBikeTypeById(bikeTypeId);
            return bikeType;
        } else {
            return new BikeType();
        }
    }
}
