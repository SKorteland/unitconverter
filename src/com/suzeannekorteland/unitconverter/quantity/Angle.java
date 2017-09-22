package com.suzeannekorteland.unitconverter.quantity;

import com.suzeannekorteland.unitconverter.unit.AngleUnit;

/**
 * Class representing the physical quantity Angle
 */

public class Angle implements Quantity<Angle> {

    public static final String QUANTITY_NAME = "angle";

    public static final AngleUnit REFERENCE_UNIT = AngleUnit.DEGREE;

    @Override
    public AngleUnit getReferenceUnit(){
        return REFERENCE_UNIT;
    }


}
