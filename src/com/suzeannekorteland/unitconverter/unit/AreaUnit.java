package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.quantity.Area;
import com.suzeannekorteland.unitconverter.conversion.AreaConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * enum representing units for area
 */

public enum AreaUnit implements Unit<Area> {

    SQUARE_METRE("square metre (m\u00b2)", "m\u00b2", 1),
    SQUARE_MILLIMETRE("square millimetre (mm\u00b2)", "mm\u00b2", 1E-6),
    SQUARE_CENTIMETRE("square centimetre (cm\u00b2)","cm\u00b2", 0.0001),
    SQUARE_KILOMETRE("square kilometre (km\u00b2)", "km\u00b2", 1E6),
    SQUARE_YARD("square yard (yd\u00b2)", "yd\u00b2", 0.83612736),
    SQUARE_MILE("square mile (mi\u00b2)", "mi\u00b2", 2.589988110336E6),
    SQUARE_FOOT("square foot (ft\u00b2)", "ft\u00b2", 0.09290304),
    SQUARE_INCH("square inch (in\u00b2)", "in\u00b2", 0.00064516),
    ARE("are (a)", "a", 100),
    HECTARE("hectare (ha)", "ha", 10000),
    ACRE("acre (ac)", "ac", 4046.86);


    private final String friendlyName;
    private final String symbol;
    private final double[] referenceFactors;

    AreaUnit(String friendly, String symbol, double factor){
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
    public AreaConverter getUnitConverterTo(Unit<Area> that){

        if (this.getClass() == that.getClass()) {
            return new AreaConverter(this, that);
        } else {
            throw new IllegalArgumentException("The units for conversion are incompatible");
        }


    }

    @Override
    public String getFriendlyName(){
        return friendlyName;
    }

    @Override
    public Map<String, Unit<Area>> getUnitMapping() {
        Map<String, Unit<Area>> map = new HashMap<>();
        for (AreaUnit unit : values()) {
            map.put(unit.friendlyName, unit);
        }
        return map;
    }

    @Override
    public Class<?> getQuantityType() {
        return Area.class;
    }

    @Override
    public String getQuantityName() {
        return Area.QUANTITY_NAME;
    }


    @Override
    public List<String> getUnitsList() {
        List<String> list = new ArrayList<>();
        for (AreaUnit unit : values()) {
            list.add(unit.friendlyName);
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public Measurement<Area> createMeasurement(Number value) {
        return new Measurement<>(value,this);
    }

    @Override
    public Class<?> getConcreteUnitClass() {
        return this.getClass();
    }

}

