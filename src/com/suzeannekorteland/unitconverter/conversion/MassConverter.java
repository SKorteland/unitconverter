package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.quantity.Mass;
import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 * This class performs conversions between units of mass
 */

public final class MassConverter implements UnitConverter<Mass> {

    private Unit<Mass> fromUnit;
    private Unit<Mass> toUnit;

    public MassConverter(Unit<Mass> from, Unit<Mass> to){
        this.fromUnit = from;
        this.toUnit = to;
    }


    @Override
    public <V extends Number> double convert(V value){

        return value.doubleValue() * fromUnit.getToReferenceFactors()[0] / toUnit.getToReferenceFactors()[0];
    }

}
