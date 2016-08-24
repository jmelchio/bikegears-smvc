/*
 * AuthenticationCheckHandlerInterceptor.java
 *
 * Created on January 13, 2007, 11:51 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.web.interceptors;


import com.nob.bg.web.util.BikeGearSession;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author jorismelchior
 */
public class AuthenticationCheckHandlerInterceptor extends HandlerInterceptorAdapter {
    private List<Object> excludedHandlers;
    
    /** Creates a new instance of AuthenticationCheckHandlerInterceptor */
    public AuthenticationCheckHandlerInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler != null
                && excludedHandlers.indexOf(handler) > -1) {
            return true;
        } else {
            BikeGearSession bgSession = (BikeGearSession) request.getSession().getAttribute("bgSession");
            if(bgSession != null) {
                return true;
            } else {
                response.sendRedirect("login.html");
                return false;
            }
        }
    }

    public void setExcludedHandlers(List<Object> excludedHandlers) {
        this.excludedHandlers = excludedHandlers;
    }
    
}
