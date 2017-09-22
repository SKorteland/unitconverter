package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.quantity.Volume;
import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 * This class performs conversions between units of volume
 */

public class VolumeConverter implements UnitConverter<Volume> {

    private Unit<Volume> fromUnit;
    private Unit<Volume> toUnit;

    public VolumeConverter(Unit<Volume> from, Unit<Volume> to){
        this.fromUnit = from;
        this.toUnit = to;
    }

    @Override
    public <V extends Number> double convert(V value) {
        return value.doubleValue() * fromUnit.getToReferenceFactors()[0] / toUnit.getToReferenceFactors()[0];
    }


}
