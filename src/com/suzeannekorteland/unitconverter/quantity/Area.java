package com.suzeannekorteland.unitconverter.quantity;

import com.suzeannekorteland.unitconverter.unit.AreaUnit;

/**
 * Class representing the physical quantity Area
 */

public class Area implements Quantity<Area> {


    public static final String QUANTITY_NAME = "area";

    public static final AreaUnit REFERENCE_UNIT = AreaUnit.SQUARE_METRE;

    @Override
    public AreaUnit getReferenceUnit(){
        return REFERENCE_UNIT;
    }
}
