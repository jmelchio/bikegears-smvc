package com.nob.bg.web.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class BGHandlerExceptionResolver implements HandlerExceptionResolver {
    private String databaseProblemView;
    private String unknownProblemView;

    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mav = null;
        if (isOrExtends(DataAccessException.class, ex.getClass())) {
            mav = new ModelAndView(databaseProblemView);
        } else {
            mav = new ModelAndView(unknownProblemView);
        }
        mav.addObject("exception", ex.getClass().getName());
        mav.addObject("handler", handler.getClass().getName());
        return mav;
    }
    
    private boolean isOrExtends(Class<?> sample, Class<?> clazz) {
        Class<?> aClass = clazz;
        while(!aClass.equals(Object.class)) {
            if(aClass.equals(sample)) {
                return true;
            } else {
                aClass = (Class<?>) aClass.getGenericSuperclass();
            }
        }
        return false;
    }

    public void setDatabaseProblemView(String databaseProblemView) {
        this.databaseProblemView = databaseProblemView;
    }

    public void setUnknownProblemView(String unknownProblemView) {
        this.unknownProblemView = unknownProblemView;
    }

}
