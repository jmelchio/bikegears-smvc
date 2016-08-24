package com.nob.bg.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class PageNotFoundController implements Controller {
    private String viewName;

    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView(viewName);
        return mav;
    }

    @Required
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

}
