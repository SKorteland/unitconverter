package com.suzeannekorteland.unitconverter.quantity;

import com.suzeannekorteland.unitconverter.unit.MassUnit;


/**
 * immutable class representing the physical quantity Mass
 */

public final class Mass implements Quantity<Mass> {


    public static final String QUANTITY_NAME = "mass";

    public static final MassUnit REFERENCE_UNIT =  MassUnit.KILOGRAM;

    @Override
    public MassUnit getReferenceUnit(){
        return REFERENCE_UNIT;
    }
}
