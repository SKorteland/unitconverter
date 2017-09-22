package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.quantity.Area;
import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 * This class performs conversions between units of area
 */

public class AreaConverter implements UnitConverter<Area> {

    private Unit<Area> fromUnit;
    private Unit<Area> toUnit;

    public AreaConverter(Unit<Area> from, Unit<Area> to) {
        this.fromUnit = from;
        this.toUnit = to;
    }


    @Override
    public <V extends Number> double convert(V value) {

        return value.doubleValue() * fromUnit.getToReferenceFactors()[0] / toUnit.getToReferenceFactors()[0];
    }
}