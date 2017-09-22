package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.quantity.Temperature;
import com.suzeannekorteland.unitconverter.conversion.TemperatureConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * enum representing units for temperature
 */

public enum TemperatureUnit implements Unit<Temperature> {

    KELVIN("kelvin (K)", "K", 1, 0),
    CELCIUS("degree Celcius (\u00B0C)", "\u00B0C", 1, 273.15),
    FAHRENHEIT("degree Fahrenheit (\u00b0F)", "\u00b0F", 5.0/9, 459.67*5.0/9);

    private final String friendlyName;
    private final String symbol;
    private final double[] referenceFactors;

    TemperatureUnit(String friendly, String symbol, double factor, double intercept){
        this.friendlyName = friendly;
        this.symbol = symbol;
        this.referenceFactors = new double[]{factor, intercept};

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
    public TemperatureConverter getUnitConverterTo(Unit<Temperature> that){

        return new TemperatureConverter(this, that);
    }

    @Override
    public String getFriendlyName(){
        return friendlyName;
    }

    @Override
    public Map<String, Unit<Temperature>> getUnitMapping() {
        Map<String, Unit<Temperature>> map = new HashMap<>();
        for (TemperatureUnit unit : values()) {
            map.put(unit.friendlyName, unit);
        }
        return map;
    }

    @Override
    public Class<?> getQuantityType() {
        return Temperature.class;
    }

    @Override
    public String getQuantityName() {
        return Temperature.QUANTITY_NAME;
    }


    @Override
    public List<String> getUnitsList() {
        List<String> list = new ArrayList<>();
        for (TemperatureUnit unit : values()) {
            list.add(unit.friendlyName);
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public Measurement<Temperature> createMeasurement(Number value) {
        return new Measurement<Temperature>(value,this);
    }

    @Override
    public Class<?> getConcreteUnitClass() {
        return this.getClass();
    }
}
