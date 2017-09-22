package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.quantity.Flour;
import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 *This class performs conversions between units of flour volume/weight
 */

public class FlourConverter implements UnitConverter<Flour> {

    private Unit<Flour> fromUnit;
    private Unit<Flour> toUnit;

    public FlourConverter(Unit<Flour> from, Unit<Flour> to){
        this.fromUnit = from;
        this.toUnit = to;
    }


    @Override
    public <V extends Number> double convert(V value){

        return value.doubleValue() * fromUnit.getToReferenceFactors()[0] / toUnit.getToReferenceFactors()[0];
    }

}

