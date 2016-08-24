/*
 * BikeEntryController.java
 *
 * Created on March 3, 2007, 9:25 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.web.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nob.bg.model.Bike;
import com.nob.bg.model.BikeType;
import com.nob.bg.service.BikeGearsService;
import com.nob.bg.web.util.BikeGearSession;

/**
 *
 * @author jorismelchior
 */
public class BikeEntryController extends SimpleFormController {
    private BikeGearsService service;
    
    /** Creates a new instance of BikeEntryController */
    public BikeEntryController() {
    }

    @Required
    public void setService(BikeGearsService service) {
        this.service = service;
    }

    @Override
    protected Map<Object, Object> referenceData(HttpServletRequest request) throws Exception {
        Map<Object, Object> retValue = new HashMap<Object, Object>();
        
        Collection<BikeType> bikeTypeList = service.getBikeTypes();
        retValue.put("bikeTypeList", bikeTypeList);
        return retValue;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        BikeGearSession bgSession = (BikeGearSession) request.getSession().getAttribute("bgSession");
        if(request.getParameter("id") != null 
                && request.getParameter("id").trim().length() > 0 
                && !request.getParameter("id").equals("0")) {
            Long bikeId = Long.parseLong(request.getParameter("id"));
            Bike bike = service.getBikeById(bikeId); //TODO: call should assemble the whole object ...
            bike.setBikeRider(bgSession.getBikeRider());
            return bike;
        } else {
            Bike bike = new Bike();
            bike.setBikeRider(bgSession.getBikeRider());
            bike.setBikeType(new BikeType());
            return bike;
        }
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        Bike bike = (Bike) command;
        if(bike.getId() == null) {
            BikeGearSession bgSession = (BikeGearSession) request.getSession().getAttribute("bgSession");
            bike.setBikeRider(bgSession.getBikeRider());
            service.createBike(bike);
        } else {
            service.changeBike(bike);
        }
        return new ModelAndView(this.getSuccessView());
    }
    
}
