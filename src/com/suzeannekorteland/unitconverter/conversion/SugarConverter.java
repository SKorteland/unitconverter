package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.conversion.UnitConverter;
import com.suzeannekorteland.unitconverter.quantity.Sugar;
import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 * This class performs conversions between units of sugar
 */

public class SugarConverter implements UnitConverter<Sugar> {

    private Unit<Sugar> fromUnit;
    private Unit<Sugar> toUnit;

    public SugarConverter(Unit<Sugar> from, Unit<Sugar> to) {
        this.fromUnit = from;
        this.toUnit = to;
    }


    @Override
    public <V extends Number> double convert(V value) {

        return value.doubleValue() * fromUnit.getToReferenceFactors()[0] / toUnit.getToReferenceFactors()[0];
    }
}