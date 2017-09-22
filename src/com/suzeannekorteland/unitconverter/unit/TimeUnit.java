package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.quantity.Time;
import com.suzeannekorteland.unitconverter.conversion.TimeConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * enum representing units for time
 */

public enum TimeUnit implements Unit<Time> {

    SECOND("second (s)", "s", 1),
    KILOSECOND("kilosecond (ks)", "ks", 1000),
    MILLISECOND("millisecond (ms)", "ms", 0.001),
    MICROSECOND("microsecond (\u00B5s)", "\u00B5s", 1E-6),
    NANOSECOND("nanosecond (ns)", "ns", 1E-9),
    MINUTE("minute (min)","min",60),
    HOUR("hour (hr)", "hr", 3600),
    DAY("day", "day", 86400),
    WEEK("week", "week", 604800),
    MONTH("month", "month", 2.628E6),
    YEAR("year", "year", 3.1536E+7),
    DECADE("decade", "decade", 3.1536E+8),
    CENTURY("century", "century", 3.1536E+9),
    MILLENIUM("millenium", "millenium",3.1536E+10 );






    private final String friendlyName;
    private final String symbol;
    private final double[] referenceFactors;

    TimeUnit(String friendly, String symbol, double factor){
        this.friendlyName = friendly;
        this.symbol = symbol;
        this.referenceFactors = new double[]{factor, 0};

    }

    @Override
    public double[] getToReferenceFactors(){
        return referenceFactors;
    }


    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public TimeConverter getUnitConverterTo(Unit<Time> that){

        return new TimeConverter(this, that);
    }

    @Override
    public String getFriendlyName(){
        return friendlyName;
    }


    @Override
    public Map<String, Unit<Time>> getUnitMapping() {
        Map<String, Unit<Time>> map = new HashMap<>();
        for (TimeUnit unit : values()) {
            map.put(unit.friendlyName, unit);
        }
        return map;
    }

    @Override
    public Class<?> getQuantityType() {
        return Time.class;
    }

    @Override
    public String getQuantityName() {
        return Time.QUANTITY_NAME;
        }

   
    @Override
    public List<String> getUnitsList() {
        List<String> list = new ArrayList<>();
        for (TimeUnit unit : values()) {
            list.add(unit.friendlyName);
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public Measurement<Time> createMeasurement(Number value) {
        return new Measurement<Time>(value,this);
        }

    @Override
    public Class<?> getConcreteUnitClass() {
        return this.getClass();
        }
        }

