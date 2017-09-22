package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.quantity.Speed;
import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 * This class performs conversions between units of speed
 */

public class SpeedConverter implements UnitConverter<Speed> {

    private Unit<Speed> fromUnit;
    private Unit<Speed> toUnit;

    public SpeedConverter(Unit<Speed> from, Unit<Speed> to){
        this.fromUnit = from;
        this.toUnit = to;
    }


    @Override
    public <V extends Number> double convert(V value){

        return value.doubleValue() * fromUnit.getToReferenceFactors()[0] / toUnit.getToReferenceFactors()[0];
    }

}

