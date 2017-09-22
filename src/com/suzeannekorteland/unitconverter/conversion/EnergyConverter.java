package com.suzeannekorteland.unitconverter.conversion;


import com.suzeannekorteland.unitconverter.quantity.Energy;
import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 * This class performs conversions between units of energy
 */

public class EnergyConverter implements UnitConverter<Energy> {

    private Unit<Energy> fromUnit;
    private Unit<Energy> toUnit;

    public EnergyConverter(Unit<Energy> from, Unit<Energy> to) {
        this.fromUnit = from;
        this.toUnit = to;
    }


    @Override
    public <V extends Number> double convert(V value) {

        return value.doubleValue() * fromUnit.getToReferenceFactors()[0] / toUnit.getToReferenceFactors()[0];
    }
}