package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.quantity.Length;
import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 * This class performs conversions between units of length
 */

public class LengthConverter implements UnitConverter<Length> {

    private Unit<Length> fromUnit;
    private Unit<Length> toUnit;

    public LengthConverter(Unit<Length> from, Unit<Length> to){
        this.fromUnit = from;
        this.toUnit = to;
    }


    @Override
    public <V extends Number> double convert(V value){

        return value.doubleValue() * fromUnit.getToReferenceFactors()[0] / toUnit.getToReferenceFactors()[0];
    }

}

