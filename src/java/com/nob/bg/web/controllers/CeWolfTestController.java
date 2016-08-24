/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nob.bg.web.controllers;

import com.nob.bg.web.chart.cewolf.PieChartPostProcessor;
import com.nob.bg.web.chart.cewolf.TestDatasetProducer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author jorismelchior
 */
public class CeWolfTestController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        TestDatasetProducer pieChartProducer = new TestDatasetProducer();
        PieChartPostProcessor pieChartPostProcessor = new PieChartPostProcessor();
        ModelAndView mav = new ModelAndView("testcewolf");
        mav.addObject("pieChartProducer", pieChartProducer);
        mav.addObject("pieChartPostProcessor", pieChartPostProcessor);
        return mav;
    }

}
