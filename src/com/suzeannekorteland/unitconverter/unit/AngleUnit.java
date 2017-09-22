package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.quantity.Angle;
import com.suzeannekorteland.unitconverter.conversion.AngleConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * enum representing units for angle
 */

public enum AngleUnit implements Unit<Angle> {

    RADIAN("radian (rad)", "rad", 1),
    DEGREE("degree (angle)" ,"\u00b0", Math.PI / 180),
    SECOND("second (angle)", "\"", 3600 * Math.PI / 180),
    MINUTE("minute (angle)", "\'", 60 * Math.PI / 180);


    private final String friendlyName;
    private final String symbol;
    private final double[] referenceFactors;

    AngleUnit(String friendly, String symbol, double factor){
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
    public AngleConverter getUnitConverterTo(Unit<Angle> that){

        if (this.getClass() == that.getClass()) {
            return new AngleConverter(this, that);
        } else {
            throw new IllegalArgumentException("The units for conversion are incompatible");
        }


    }

    @Override
    public String getFriendlyName(){
        return friendlyName;
    }

    @Override
    public Map<String, Unit<Angle>> getUnitMapping() {
        Map<String, Unit<Angle>> map = new HashMap<>();
        for (AngleUnit unit : values()) {
            map.put(unit.friendlyName, unit);
        }
        return map;
    }

    @Override
    public Class<?> getQuantityType() {
        return Angle.class;
    }

    @Override
    public String getQuantityName() {
        return Angle.QUANTITY_NAME;
    }


    @Override
    public List<String> getUnitsList() {
        List<String> list = new ArrayList<>();
        for (AngleUnit unit : values()) {
            list.add(unit.friendlyName);
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public Measurement<Angle> createMeasurement(Number value) {
        return new Measurement<Angle>(value,this);
    }

    @Override
    public Class<?> getConcreteUnitClass() {
        return this.getClass();
    }

}


