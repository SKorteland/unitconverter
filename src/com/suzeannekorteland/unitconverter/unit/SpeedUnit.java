package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.quantity.Speed;
import com.suzeannekorteland.unitconverter.conversion.SpeedConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * enum representing units for speed
 */

public enum SpeedUnit implements Unit<Speed> {
    METRE_PER_SECOND("metre per second (m/s)", "m/s", 1),
    KILOMETRE_PER_HOUR("kilometre per hour (km/h)", "km/h", 0.27777777777),
    MILE_PER_HOUR("mile per hour (mi/h)", "mi/h", 0.44704),
    FOOT_PER_SECOND("foot per second (ft/s)", "ft/s", 0.3048),
    KNOT("knot (kn)", "kn", 0.514444);


    private final String friendlyName;
    private final String symbol;
    private final double[] referenceFactors;

    SpeedUnit(String friendly, String symbol, double factor){
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
    public SpeedConverter getUnitConverterTo(Unit<Speed> that){

        if (this.getClass() == that.getClass()) {
            return new SpeedConverter(this, that);
        } else {
            throw new IllegalArgumentException("The units for conversion are incompatible");
        }


    }

    @Override
    public String getFriendlyName(){
        return friendlyName;
    }

    @Override
    public Map<String, Unit<Speed>> getUnitMapping() {
        Map<String, Unit<Speed>> map = new HashMap<>();
        for (SpeedUnit unit : values()) {
            map.put(unit.friendlyName, unit);
        }
        return map;
    }

    @Override
    public Class<?> getQuantityType() {
        return Speed.class;
    }

    @Override
    public String getQuantityName() {
        return Speed.QUANTITY_NAME;
    }


    @Override
    public List<String> getUnitsList() {
        List<String> list = new ArrayList<>();
        for (SpeedUnit unit : values()) {
            list.add(unit.friendlyName);
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public Measurement<Speed> createMeasurement(Number value) {
        return new Measurement<>(value,this);
    }

    @Override
    public Class<?> getConcreteUnitClass() {
        return this.getClass();
    }

}

