package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.quantity.Butter;
import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 * This class performs conversions between units of butter volume/weight
 */

public class ButterConverter implements UnitConverter<Butter> {

    private Unit<Butter> fromUnit;
    private Unit<Butter> toUnit;

    public ButterConverter(Unit<Butter> from, Unit<Butter> to) {
        this.fromUnit = from;
        this.toUnit = to;
    }


    @Override
    public <V extends Number> double convert(V value) {

        return value.doubleValue() * fromUnit.getToReferenceFactors()[0] / toUnit.getToReferenceFactors()[0];
    }
}