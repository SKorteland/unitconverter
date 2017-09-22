package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.quantity.DigitalStorage;
import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 * This class performs conversions between units of digital storage
 */

public class DigitalStorageConverter implements UnitConverter<DigitalStorage> {

    private Unit<DigitalStorage> fromUnit;
    private Unit<DigitalStorage> toUnit;

    public DigitalStorageConverter(Unit<DigitalStorage> from, Unit<DigitalStorage> to) {
        this.fromUnit = from;
        this.toUnit = to;
    }


    @Override
    public <V extends Number> double convert(V value) {

        return value.doubleValue() * fromUnit.getToReferenceFactors()[0] / toUnit.getToReferenceFactors()[0];
    }
}
