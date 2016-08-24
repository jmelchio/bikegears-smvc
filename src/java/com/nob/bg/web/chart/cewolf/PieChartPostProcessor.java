/**
 * 
 */
package com.nob.bg.web.chart.cewolf;

import java.awt.Color;
import java.util.Map;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;

import de.laures.cewolf.ChartPostProcessor;

/**
 * @author jorismelchior
 *
 */
public class PieChartPostProcessor implements ChartPostProcessor {

    /* (non-Javadoc)
     * @see de.laures.cewolf.ChartPostProcessor#processChart(java.lang.Object, java.util.Map)
     */
    public void processChart(Object chart, @SuppressWarnings("rawtypes") Map params) {
        JFreeChart pieChart = (JFreeChart) chart;
        
        TextTitle title = null;
        pieChart.setTitle(title);
//        float[] rgb = {1.0f, 1.0f, 1.0f};
//        Color color = new Color(ColorSpace.getInstance(ColorSpace.CS_sRGB), rgb, 0.0f);
        pieChart.setBackgroundPaint(Color.white);
        pieChart.setBorderVisible(false);
        
        PiePlot plot = (PiePlot) pieChart.getPlot();
        //plot.setLabelGenerator(null);
        plot.setBackgroundPaint(null);
        plot.setShadowPaint(null);
        plot.setOutlinePaint(null);
        plot.setInteriorGap(0.0d);
        plot.setCircular(true);
        plot.setMaximumLabelWidth(0.5);
//        double mlw = plot.getMaximumLabelWidth();
    }

}
