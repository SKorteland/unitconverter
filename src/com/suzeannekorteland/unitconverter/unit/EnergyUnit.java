package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.quantity.Energy;
import com.suzeannekorteland.unitconverter.conversion.EnergyConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * enum representing units for energy
 */

public enum EnergyUnit implements Unit<Energy> {

    JOULE("joule (J)", "J", 1),
    KILOJOULE("kilojoule (kJ)", "kJ", 1000),
    MEGAJOULE("megajoule (MJ)", "MJ", 1E6),
    GIGAJOULE("gigajoule (GJ)", "GJ", 1E9),
    NEWTONMETRE("newton metre (Nm)", "Nm", 1),
    ELECTRONVOLT("electronvolt (eV)", "eV", 1.60217653E-19),
    FOOTPOUNDFORCE("foot-pound force (ft lbs)", "ft lbs",1.3558179483314004),
    CALORIE_SMALL("gram calorie (cal)", "cal", 4.184),
    KILOCALORIE_SMALL("kilocalorie (kcal)", "kcal",4184),
    CALORIE_LARGE("food calorie (Cal)", "Cal", 4184),
    WATTHOUR("watt-hour (Wh)", "Wh", 3600),
    KILOWATTHOUR("kilowatt-hour (kWh)","kWh",3.6E6),
    BTU("British thermal unit (BTU)", "BTU", 1055.06);


    private final String friendlyName;
    private final String symbol;
    private final double[] referenceFactors;

    EnergyUnit(String friendly, String symbol, double factor){
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
    public EnergyConverter getUnitConverterTo(Unit<Energy> that){

        if (this.getClass() == that.getClass()) {
            return new EnergyConverter(this, that);
        } else {
            throw new IllegalArgumentException("The units for conversion are incompatible");
        }


    }

    @Override
    public String getFriendlyName(){
        return friendlyName;
    }

    @Override
    public Map<String, Unit<Energy>> getUnitMapping() {
        Map<String, Unit<Energy>> map = new HashMap<>();
        for (EnergyUnit unit : values()) {
            map.put(unit.friendlyName, unit);
        }
        return map;
    }

    @Override
    public Class<?> getQuantityType() {
        return Energy.class;
    }

    @Override
    public String getQuantityName() {
        return Energy.QUANTITY_NAME;
    }


    @Override
    public List<String> getUnitsList() {
        List<String> list = new ArrayList<>();
        for (EnergyUnit unit : values()) {
            list.add(unit.friendlyName);
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public Measurement<Energy> createMeasurement(Number value) {
        return new Measurement<Energy>(value,this);
    }

    @Override
    public Class<?> getConcreteUnitClass() {
        return this.getClass();
    }

}
