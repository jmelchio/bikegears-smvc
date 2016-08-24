/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nob.bg.web.chart.cewolf;

import de.laures.cewolf.DatasetProduceException;
import de.laures.cewolf.DatasetProducer;
import java.util.Date;
import java.util.Map;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author jorismelchior
 */
public class TestDatasetProducer implements DatasetProducer {
    private static final long serialVersionUID = -4361948469926267247L;
    public static final String PRODUCER_ID = "testProducer";
    private Long expireMilliseconds = 5000L;

    public Object produceDataset(@SuppressWarnings("rawtypes") Map params) throws DatasetProduceException {
        DefaultPieDataset pieDataset = new DefaultKeyedValuesDataset();
        pieDataset.setValue("applePie", 10);
        pieDataset.setValue("cherryPie", 20);
        pieDataset.setValue("blueBerry", 30);
        pieDataset.setValue("blackBerry", 40);
        return pieDataset;
    }

    public boolean hasExpired(@SuppressWarnings("rawtypes") Map params, Date since) {
        return System.currentTimeMillis() - expireMilliseconds < since.getTime();
    }

    public String getProducerId() {
        return PRODUCER_ID;
    }

    public Long getExpireMilliseconds() {
        return expireMilliseconds;
    }

    public void setExpireMilliseconds(Long expireMilliseconds) {
        this.expireMilliseconds = expireMilliseconds;
    }

}
