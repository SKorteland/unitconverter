package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.quantity.Pressure;
import com.suzeannekorteland.unitconverter.conversion.PressureConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * enum representing units for pressure
 */

public enum PressureUnit implements Unit<Pressure> {
    PASCAL("pascal (Pa)", "Pa", 1),
    KILOPASCAL("kilopascal (kPa)", "kPa", 1000),
    MEGAPASCAL("megapascal (MPa)", "MPa", 1000000),
    GIGAPASCAL("gigapascal (GPa)", "GPa", 1000000000),
    HECTOPASCAL("hectopascal (hPa)", "hPa", 100),
    ATMOSPHERE_STD("standard atmosphere (atm)", "atm", 101325),
    ATMOSPHERE_TECHNICAL("technical atmosphere (at)", "at", 98066.5),
    BAR("bar", "bar", 100000),
    KILOBAR("kilobar (kbar)", "kbar", 100000000),
    MILLIBAR("millibar (mbar)", "mbar", 100),
    CENTIBAR("centibar (cbar)", "cbar", 1000),
    MEGABAR("megabar (Mbar)", "Mbar", 1E11),
    TORR("torr", "Torr", 133.322368421),
    MILLITOR("millitorr (mTorr)", "mTorr",0.133322368421),
    DYNE_PER_SQUARE_METRE("dyne/m\u00b2", "dyn/m\u00b2", 0.00001),
    DYNE_PER_SQUARE_CENTIMETRE("dyne/cm\u00b2", "dyn/cm\u00b2", 0.1),
    MM_MERCURY("millimetre mercury (mmHg)", "mmHg", 133.322387415),
    IN_MERCURY("inch mercury (inHg)", "inHg", 3386.389),
    MM_WATER("millimetre water (mmH\u2082O", "mmH\u2082O", 9.80665),
    CM_WATER("centimetre water (cmH\u2082O)", "cmH\u2082O", 98.0665),
    M_WATER("metre water (mH\u2082O)", "mH\u2082O", 9806.65),
    IN_WATER("inch water (inH\u2082O)", "inH\u2082O", 248.84),
    BARYE("barye (Ba)", "Ba", 0.1),
    NEWTON_PER_SQUARE_METRE("newton/m\u00b2 (N/m\u00b2)", "N/m\u00b2", 1),
    PSI("pound/inch\u00b2 (psi)", "psi",6894.8),
    KSI("kilopound/inch\u00b2 (ksi)" , "ksi" , 6894800);


    private final String friendlyName;
    private final String symbol;
    private final double[] referenceFactors;

    PressureUnit(String friendly, String symbol, double factor){
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
    public PressureConverter getUnitConverterTo(Unit<Pressure> that){

        if (this.getClass() == that.getClass()) {
            return new PressureConverter(this, that);
        } else {
            throw new IllegalArgumentException("The units for conversion are incompatible");
        }


    }

    @Override
    public String getFriendlyName(){
        return friendlyName;
    }

    @Override
    public Map<String, Unit<Pressure>> getUnitMapping() {
        Map<String, Unit<Pressure>> map = new HashMap<>();
        for (PressureUnit unit : values()) {
            map.put(unit.friendlyName, unit);
        }
        return map;
    }

    @Override
    public Class<?> getQuantityType() {
        return Pressure.class;
    }

    @Override
    public String getQuantityName() {
        return Pressure.QUANTITY_NAME;
    }


    @Override
    public List<String> getUnitsList() {
        List<String> list = new ArrayList<>();
        for (PressureUnit unit : values()) {
            list.add(unit.friendlyName);
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public Measurement<Pressure> createMeasurement(Number value) {
        return new Measurement<>(value,this);
    }

    @Override
    public Class<?> getConcreteUnitClass() {
        return this.getClass();
    }

}

