package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.quantity.Angle;
import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 * This class performs conversions between units of angle
 */

public class AngleConverter implements UnitConverter<Angle> {

    private Unit<Angle> fromUnit;
    private Unit<Angle> toUnit;

    public AngleConverter(Unit<Angle> from, Unit<Angle> to) {
        this.fromUnit = from;
        this.toUnit = to;
    }


    @Override
    public <V extends Number> double convert(V value) {

        return value.doubleValue() * fromUnit.getToReferenceFactors()[0] / toUnit.getToReferenceFactors()[0];
    }
}