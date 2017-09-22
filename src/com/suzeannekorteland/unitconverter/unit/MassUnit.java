package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.quantity.Mass;
import com.suzeannekorteland.unitconverter.conversion.MassConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * enum representing units for mass
 */

public enum MassUnit implements Unit<Mass> {
    MICROGRAM("microgram (\u00b5g)", "\u00b5g", 1e-9),
    MILLIGRAM("milligram (mg)", "mg", 1e-6),
    GRAM("gram (g)", "g", 1e-3),
    KILOGRAM("kilogram (kg)", "kg", 1),
    STONE("stone (st)", "st", 6.35029318),
    OUNCE("ounce (oz)", "oz", 0.0283495231),
    POUND("pound (lbs)", "lbs", 0.45359237),
    TONNE("tonne (metric ton) (t)", "t", 1000),
    TON_UK("ton (long/UK)", "ton (long/UK)", 1016.047),
    TON_US("ton (short/US)", "ton (short/US)", 907.1847);

    private final String friendlyName;
    private final String symbol;
    private final double[] referenceFactors;

    MassUnit(String friendly, String symbol, double factor){
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
    public MassConverter getUnitConverterTo(Unit<Mass> that){

        if (this.getClass() == that.getClass()) {
            return new MassConverter(this, that);
        } else {
            throw new IllegalArgumentException("The units for conversion are incompatible");
        }


    }

    @Override
    public String getFriendlyName(){
        return friendlyName;
    }

    @Override
    public Map<String, Unit<Mass>> getUnitMapping() {
        Map<String, Unit<Mass>> map = new HashMap<>();
        for (MassUnit unit : values()) {
                map.put(unit.friendlyName, unit);
        }
        return map;
    }

    @Override
    public Class<?> getQuantityType() {
        return Mass.class;
    }

    @Override
    public String getQuantityName() {
        return Mass.QUANTITY_NAME;
    }

 

    @Override
    public List<String> getUnitsList() {
        List<String> list = new ArrayList<>();
        for (MassUnit unit : values()) {
            list.add(unit.friendlyName);
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public Measurement<Mass> createMeasurement(Number value) {
        return new Measurement<>(value,this);
    }

    @Override
    public Class<?> getConcreteUnitClass() {
        return this.getClass();
    }

}
