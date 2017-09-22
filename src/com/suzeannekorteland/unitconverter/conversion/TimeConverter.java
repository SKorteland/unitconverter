package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.conversion.UnitConverter;
import com.suzeannekorteland.unitconverter.quantity.Time;
import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 * This class performs conversions between units of time
 */

public class TimeConverter implements UnitConverter<Time> {

    private Unit<Time> fromUnit;
    private Unit<Time> toUnit;

    public TimeConverter(Unit<Time> from, Unit<Time> to) {
        this.fromUnit = from;
        this.toUnit = to;
    }


    @Override
    public <V extends Number> double convert(V value) {

        return value.doubleValue() * fromUnit.getToReferenceFactors()[0] / toUnit.getToReferenceFactors()[0];
    }
}