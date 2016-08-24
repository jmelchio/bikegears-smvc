/*
 * RiderOverviewController.java
 *
 * Created on January 16, 2007, 8:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.web.controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.nob.bg.model.BikeRide;
import com.nob.bg.service.BikeGearsService;
import com.nob.bg.web.util.BikeGearSession;

/**
 * 
 * @author jorismelchior
 */
public class RiderOverviewController implements Controller {
    private BikeGearsService service;

    /** Creates a new instance of RiderOverviewController */
    public RiderOverviewController() {
    }

    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("rideroverview");
        BikeGearSession bgSession = (BikeGearSession) request.getSession()
                .getAttribute("bgSession");
        Collection<BikeRide> rides = service.getBikeRidesForRider(bgSession
                .getBikeRider(), 10);
        mav.addObject("rides", rides);
        try {
            bgSession.getBikeRider().getPerson().getFirstName();
        } catch (LazyInitializationException lie) {
            bgSession.getBikeRider().setPerson(
                    service.getPersonForBikeRider(bgSession.getBikeRider()));
        }
        return mav;
    }

    @Required
    public void setService(BikeGearsService service) {
        this.service = service;
    }

}
