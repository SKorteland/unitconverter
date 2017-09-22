package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.quantity.Flour;
import com.suzeannekorteland.unitconverter.conversion.FlourConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * enum representing units for flour weight/volume
 */

public enum FlourUnit implements Unit<Flour> {

    GRAM("gram (g) flour", "g flour", 1),
    KILOGRAM("kilogram (kg) flour", "kg flour", 1000),
    CUP("cup flour", "cup flour", 130),
    OUNCE("ounce (oz) flour", "oz flour", 28.3495231),
    POUND("pound (lbs) flour", "lbs flour", 453.59237),
    TABLESPOON("tablespoon (tbsp) flour", "tbsp flour", 8.125),
    TEASPOON("teaspoon (tsp) flour", "tsp flour", 2.70833333333);


    private final String friendlyName;
    private final String symbol;
    private final double[] referenceFactors;

    FlourUnit(String friendly, String symbol, double factor){
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
    public FlourConverter getUnitConverterTo(Unit<Flour> that){

        if (this.getClass() == that.getClass()) {
            return new FlourConverter(this, that);
        } else {
            throw new IllegalArgumentException("The units for conversion are incompatible");
        }


    }

    @Override
    public String getFriendlyName(){
        return friendlyName;
    }

    @Override
    public Map<String, Unit<Flour>> getUnitMapping() {
        Map<String, Unit<Flour>> map = new HashMap<>();
        for (FlourUnit unit : values()) {
            map.put(unit.friendlyName, unit);
        }
        return map;
    }

    @Override
    public Class<?> getQuantityType() {
        return Flour.class;
    }

    @Override
    public String getQuantityName() {
        return Flour.QUANTITY_NAME;
    }


    @Override
    public List<String> getUnitsList() {
        List<String> list = new ArrayList<>();
        for (FlourUnit unit : values()) {
            list.add(unit.friendlyName);
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public Measurement<Flour> createMeasurement(Number value) {
        return new Measurement<>(value,this);
    }

    @Override
    public Class<?> getConcreteUnitClass() {
        return this.getClass();
    }

}
