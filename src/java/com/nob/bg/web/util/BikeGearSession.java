package com.nob.bg.web.util;

import com.nob.bg.model.BikeRider;

/**
 * In this object the session information for a user is stored. 
 * 
 * @author jorismelchior
 */
public class BikeGearSession {
    private BikeRider bikeRider;

    public BikeRider getBikeRider() {
        return bikeRider;
    }

    public void setBikeRider(BikeRider bikeRider) {
        this.bikeRider = bikeRider;
    }
}
