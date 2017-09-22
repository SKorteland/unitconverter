package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.quantity.Length;
import com.suzeannekorteland.unitconverter.conversion.LengthConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * enum representing units for length
 */

public enum LengthUnit implements Unit<Length> {

    NANOMETRE("nanometre (nm)", "nm", 1e-9 ),
    MICROMETRE("micrometre (\u00b5m)", "\u00b5m", 1e-6),
    MILLIMETRE("millimetre (mm)", "mm", 0.001),
    CENTIMETRE("centimetre (cm)", "cm", 0.01),
    DECIMETRE("decimetre (dm)", "dm", 0.1),
    METRE("metre (m)", "m", 1),
    KILOMETRE("kilometre (km)", "km", 1000),
    YARD("yard (yd)", "yd", 0.9144),
    INCH("inch (in)", "in", 0.0254),
    FOOT("foot (ft)", "ft", 0.3048),
    MILE("mile (mi)", "mi", 1609.344),
    NAUTICALMILE("nautical mile (nmi)", "nmi", 1852);

    private final String friendlyName;
    private final String symbol;
    private final double[] referenceFactors;

    LengthUnit(String friendly, String symbol, double factor){
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
    public LengthConverter getUnitConverterTo(Unit<Length> that){

        if (this.getClass() == that.getClass()) {
            return new LengthConverter(this, that);
        } else {
            throw new IllegalArgumentException("The units for conversion are incompatible");
        }


    }

    @Override
    public String getFriendlyName(){
        return friendlyName;
    }

    @Override
    public Map<String, Unit<Length>> getUnitMapping() {
        Map<String, Unit<Length>> map = new HashMap<>();
        for (LengthUnit unit : values()) {
            map.put(unit.friendlyName, unit);
        }
        return map;
    }

    @Override
    public Class<?> getQuantityType() {
        return Length.class;
    }

    @Override
    public String getQuantityName() {
        return Length.QUANTITY_NAME;
    }


    @Override
    public List<String> getUnitsList() {
        List<String> list = new ArrayList<>();
        for (LengthUnit unit : values()) {
            list.add(unit.friendlyName);
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public Measurement<Length> createMeasurement(Number value) {
        return new Measurement<Length>(value,this);
    }

    @Override
    public Class<?> getConcreteUnitClass() {
        return this.getClass();
    }

}
