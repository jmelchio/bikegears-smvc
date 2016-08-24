/*
 * BikeRideTypePropertyEditor.java
 *
 * Created on January 8, 2007, 10:59 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.web.controllers.propeditors;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author jorismelchior
 */
public class DatePropertyEditor extends PropertyEditorSupport {
    private Date date;
    
    /** Creates a new instance of DatePropertyEditor */
    public DatePropertyEditor() {
        super();
    }
    
    @Override
    public void setValue(Object value) {
        date = (Date) value;
    }
    
    @Override
    public Object getValue() {
        return date;
    }
    
    @Override
    public boolean isPaintable() {
        return false;
    }
    
    @Override
    public String getAsText() {
    DateFormat dateFormat = DateFormat.getDateInstance();
        if(date == null) {
            return dateFormat.format(new Date());
        } else {
            return dateFormat.format(date);
        }
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        DateFormat dateFormat = DateFormat.getDateInstance();
        try {
            date = dateFormat.parse(text);
        } catch (ParseException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    public boolean supportsCustomEditor() {
        return false;
    }
}
