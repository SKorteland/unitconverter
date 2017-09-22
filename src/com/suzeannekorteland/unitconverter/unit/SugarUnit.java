package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.quantity.Sugar;
import com.suzeannekorteland.unitconverter.conversion.SugarConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * enum representing units for sugar weight/volume
 */

public enum SugarUnit implements Unit<Sugar> {

    GRAM("gram (g) sugar", "g sugar", 1),
    KILOGRAM("kilogram (kg) sugar", "kg sugar", 1000),
    CUP("cup sugar", "cup sugar", 200),
    OUNCE("ounce (oz) sugar", "oz sugar", 28.3495),
    POUND("pound (lbs) sugar", "lbs sugar", 453.592),
    TABLESPOON("tablespoon (tbsp) sugar", "tbsp sugar", 12.6),
    TEASPOON("teaspoon (tsp) sugar", "tsp sugar", 4.2);


    private final String friendlyName;
    private final String symbol;
    private final double[] referenceFactors;

    SugarUnit(String friendly, String symbol, double factor){
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
    public SugarConverter getUnitConverterTo(Unit<Sugar> that){

        if (this.getClass() == that.getClass()) {
            return new SugarConverter(this, that);
        } else {
            throw new IllegalArgumentException("The units for conversion are incompatible");
        }


    }

    @Override
    public String getFriendlyName(){
        return friendlyName;
    }

    public Map<String, Unit<Sugar>> getUnitMapping() {
        Map<String, Unit<Sugar>> map = new HashMap<>();
        for (SugarUnit unit : values()) {
            map.put(unit.friendlyName, unit);
        }
        return map;
    }

    @Override
    public Class<?> getQuantityType() {
        return Sugar.class;
    }

    @Override
    public String getQuantityName() {
        return Sugar.QUANTITY_NAME;
    }


    @Override
    public List<String> getUnitsList() {
        List<String> list = new ArrayList<>();
        for (SugarUnit unit : values()) {
            list.add(unit.friendlyName);
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public Measurement<Sugar> createMeasurement(Number value) {
        return new Measurement<Sugar>(value,this);
    }

    @Override
    public Class<?> getConcreteUnitClass() {
        return this.getClass();
    }

}
