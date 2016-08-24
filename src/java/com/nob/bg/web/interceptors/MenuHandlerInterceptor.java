/*
 * MenuHandlerInterceptor.java
 *
 * Created on January 11, 2007, 10:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.nob.bg.web.interceptors;

import com.nob.bg.web.util.MenuItem;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author jorismelchior
 */
public class MenuHandlerInterceptor extends HandlerInterceptorAdapter {

    private List<MenuItem> menu;

    /** Creates a new instance of MenuHandlerInterceptor */
    public MenuHandlerInterceptor() {
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        String page = request.getRequestURI();
        for(MenuItem mItem: menu) {
            mItem.setActive(page.endsWith(mItem.getAction())? true: false);
        }
        modelAndView.addObject("menu", menu);
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }
}
