package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.quantity.Pressure;
import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 * This class performs conversions between units of pressure
 */

public class PressureConverter implements UnitConverter<Pressure> {

    private Unit<Pressure> fromUnit;
    private Unit<Pressure> toUnit;

    public PressureConverter(Unit<Pressure> from, Unit<Pressure> to) {
        this.fromUnit = from;
        this.toUnit = to;
    }


    @Override
    public <V extends Number> double convert(V value) {

        return value.doubleValue() * fromUnit.getToReferenceFactors()[0] / toUnit.getToReferenceFactors()[0];
    }
}
