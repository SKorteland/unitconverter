package com.suzeannekorteland.unitconverter.quantity;

import com.suzeannekorteland.unitconverter.unit.LengthUnit;


/**
 * Class representing the physical quantity Length
 */

public class Length implements Quantity<Length> {

  
    public static final String QUANTITY_NAME = "length";

    public static final LengthUnit REFERENCE_UNIT =  LengthUnit.METRE;

    @Override
    public LengthUnit getReferenceUnit(){
        return REFERENCE_UNIT;
    }
}
