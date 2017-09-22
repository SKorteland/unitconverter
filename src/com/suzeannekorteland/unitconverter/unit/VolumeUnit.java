package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.quantity.Volume;
import com.suzeannekorteland.unitconverter.conversion.VolumeConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * enum representing units for volume
 */

public enum VolumeUnit implements Unit<Volume> {
    MILLILITRE("millilitre (mL)", "mL", 1.0e-6),
    CENTILITRE("centilitre (cL)", "cL", 1.0e-5),
    DECILITRE("decilitre (dL)", "dL", 1.0e-4),
    LITRE ("litre (L)", "L", 0.001),
    CUBIC_CENTIMETRE("cubic centimetre (cm\u00b3)", "cm\u00b3", 1e-6),
    CUBIC_METRE("cubic metre (m\u00b3)", "m\u00b3", 1),
    CUBIC_INCH("cubic inch (in\u00b3)", "in\u00b3", 1.6387064e-5),
    CUBIC_FOOT("cubic foot (ft\u00b3)", "ft\u00b3", 0.028316846592),
    GALLON_US("gallon (gal) (US)", "gal (US)", 0.003785411784),
    GALLON_UK("gallon (gal) (UK)", "gal (UK)", 0.00454609),
    GILL_US("gill (US)", "gill (US)",  0.00011829411825),
    GILL_UK("gill (UK)", "gill (UK)", 0.00014206531),
    PINT_US("pint (pt) (US)", "pt (US)", 0.000473176473),
    PINT_UK("pint (pt) (UK)", "pt (UK)", 0.00056826125),
    OUNCE_FLUID_US("fluid ounce (fl oz) (US)", "fl oz (US)", 2.95735296e-5),
    OUNCE_FLUID_UK("fluid ounce (fl oz) (UK)", "fl oz (UK)", 2.841306e-5),
    QUART_US("quart (qt) (US)", "qt (US)", 0.000946352946),
    QUART_UK("quart (qt) (UK)", "qt (UK)", 0.0011365225),
    CUP("cup", "cup", 0.000236588237),
    TABLESPOON("tablespoon (tbsp)", "tbsp", 1.47867648e-5),
    TEASPOON("teaspoon (tsp)", "tsp", 4.92892159e-6);


    private final String friendlyName;
    private final String symbol;
    private final double[] referenceFactors;

    VolumeUnit(String friendly, String symbol, double factor){
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
    public VolumeConverter getUnitConverterTo(Unit<Volume> that){

        return new VolumeConverter(this, that);
    }

    @Override
    public String getFriendlyName(){
        return friendlyName;
    }

    @Override
    public Map<String, Unit<Volume>> getUnitMapping() {
        Map<String, Unit<Volume>> map = new HashMap<>();
        for (VolumeUnit unit : values()) {
            map.put(unit.friendlyName, unit);
        }
        return map;
    }

    @Override
    public Class<?> getQuantityType() {
        return Volume.class;
    }

    @Override
    public String getQuantityName() {
        return Volume.QUANTITY_NAME;
    }


    @Override
    public List<String> getUnitsList() {
        List<String> list = new ArrayList<>();
        for (VolumeUnit unit : values()) {
            list.add(unit.friendlyName);
        }
        Collections.sort(list);
        return list;
    }
    @Override
    public Measurement<Volume> createMeasurement(Number value) {
        return new Measurement<Volume>(value,this);
    }

    @Override
    public Class<?> getConcreteUnitClass() {
        return this.getClass();
    }
}
