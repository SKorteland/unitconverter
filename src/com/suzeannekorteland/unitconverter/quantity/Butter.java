package com.suzeannekorteland.unitconverter.quantity;

import com.suzeannekorteland.unitconverter.unit.ButterUnit;

/**
 * Class representing the quantity Pressure
 */

public class Butter implements Quantity<Butter> {

    public static final String QUANTITY_NAME = "butter";

    public static final ButterUnit REFERENCE_UNIT = ButterUnit.STICK;

    @Override
    public ButterUnit getReferenceUnit(){
        return REFERENCE_UNIT;
    }
}
