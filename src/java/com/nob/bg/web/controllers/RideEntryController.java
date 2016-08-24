/*
 * RideEntryController.java
 *
 * Created on January 8, 2007, 9:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.web.controllers;

import java.beans.PropertyEditor;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nob.bg.model.Bike;
import com.nob.bg.model.BikeRide;
import com.nob.bg.model.BikeRideType;
import com.nob.bg.model.BikeRider;
import com.nob.bg.service.BikeGearsService;
import com.nob.bg.web.util.BikeGearSession;
import org.springframework.beans.factory.annotation.Required;

/**
 *
 * @author jorismelchior
 */
public class RideEntryController extends SimpleFormController {
    private BikeGearsService service;
    private PropertyEditor dateEditor;
    
    /** Creates a new instance of RideEntryController */
    public RideEntryController() {
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        BikeRide ride = (BikeRide) command;
        if(ride.getId() == null) {
            BikeGearSession bgSession = (BikeGearSession) request.getSession().getAttribute("bgSession");
            ride.setBikeRider(bgSession.getBikeRider());
            service.createBikeRide(ride);
        } else {
            service.changeBikeRide(ride);
        }
        return new ModelAndView(this.getSuccessView());
    }

    @Override
    protected Map<Object, Object> referenceData(HttpServletRequest request) throws Exception {
        Map<Object, Object> refData = new HashMap<Object, Object>();
        Collection<BikeRideType> rideTypeList = service.getBikeRideTypes();
        BikeGearSession bgSession = (BikeGearSession) request.getSession().getAttribute("bgSession");
        Collection<Bike> bikeList = service.getBikesForRider(bgSession.getBikeRider());
        refData.put("rideTypeList", rideTypeList);
        refData.put("bikeList", bikeList);
        return refData;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        BikeGearSession bgSession = (BikeGearSession) request.getSession().getAttribute("bgSession");
        BikeRider rider = bgSession.getBikeRider();
        if(request.getParameter("id") != null 
                && request.getParameter("id").trim().length() > 0 
                && !request.getParameter("id").equals("0")) {
            Long rideId = Long.parseLong(request.getParameter("id"));
            BikeRide ride = service.getBikeRideById(rideId); //TODO: change fetch to join
            ride.setBikeRider(rider);
            return ride;
        } else {
            BikeRide ride=  new BikeRide();
            ride.setBike(new Bike());
            ride.setBikeRideType(new BikeRideType());
            ride.setBikeRider(rider);
            return ride;
        }
    }

    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        super.initBinder(request, binder);
        binder.registerCustomEditor(Date.class, dateEditor);
    }

    @Required
    public void setService(BikeGearsService service) {
        this.service = service;
    }

    @Required
    public void setDateEditor(PropertyEditor dateEditor) {
        this.dateEditor = dateEditor;
    }
}
/* That's All Folks !! */
