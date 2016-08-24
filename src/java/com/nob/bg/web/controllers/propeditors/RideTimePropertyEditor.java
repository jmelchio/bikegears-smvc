package com.nob.bg.web.controllers.propeditors;

import com.nob.bg.model.RideTime;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author jorismelchior
 */
public class RideTimePropertyEditor extends PropertyEditorSupport {
    private RideTime rideTime;

    public RideTimePropertyEditor() {
        super();
    }

    @Override
    public String getAsText() {
        return rideTime.toString();
    }

    @Override
    public Object getValue() {
        return rideTime;
    }

    @Override
    public void setAsText(String textValue) throws IllegalArgumentException {
        super.setAsText(textValue);
    }

    @Override
    public void setValue(Object value) {
        this.rideTime = (RideTime) value;
    }

    @Override
    public boolean isPaintable() {
        return false;
    }

    @Override
    public boolean supportsCustomEditor() {
        return false;
    }

}
