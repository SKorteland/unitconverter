package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.quantity.Butter;
import com.suzeannekorteland.unitconverter.conversion.ButterConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * enum representing units for butter weight/volume
 */

public enum ButterUnit implements Unit<Butter> {


    STICK("stick butter", "stick butter", 1),
    CUP("cup butter", "cup butter", 2),
    GRAM("gram (g) butter", "g butter", 0.00881834215),
    KILOGRAM("kilogram (kg) butter", "kg butter", 8.881834215),
    OUNCE("ounce (oz) butter", "oz butter", 0.25),
    POUND("pound (lbs) butter", "lbs butter", 4),
    TABLESPOON("tablespoon (tbsp) butter", "tbsp butter", 0.125),
    TEASPOON("teaspoon (tsp) butter", "tsp butter", 0.04166666666);





    private final String friendlyName;
    private final String symbol;
    private final double[] referenceFactors;

    ButterUnit(String friendly, String symbol, double factor){
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
    public ButterConverter getUnitConverterTo(Unit<Butter> that){

        if (this.getClass() == that.getClass()) {
            return new ButterConverter(this, that);
        } else {
            throw new IllegalArgumentException("The units for conversion are incompatible");
        }


    }

    @Override
    public String getFriendlyName(){
        return friendlyName;
    }

    @Override
    public Map<String, Unit<Butter>> getUnitMapping() {
        Map<String, Unit<Butter>> map = new HashMap<>();
        for (ButterUnit unit : values()) {
            map.put(unit.friendlyName, unit);
        }
        return map;
    }

    @Override
    public Class<?> getQuantityType() {
        return Butter.class;
    }

    @Override
    public String getQuantityName() {
        return Butter.QUANTITY_NAME;
    }


    @Override
    public List<String> getUnitsList() {
        List<String> list = new ArrayList<>();
        for (ButterUnit unit : values()) {
            list.add(unit.friendlyName);
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public Measurement<Butter> createMeasurement(Number value) {
        return new Measurement<Butter>(value,this);
    }

    @Override
    public Class<?> getConcreteUnitClass() {
        return this.getClass();
    }

}
