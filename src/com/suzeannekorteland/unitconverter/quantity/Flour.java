package com.suzeannekorteland.unitconverter.quantity;

import com.suzeannekorteland.unitconverter.unit.FlourUnit;


/**
 * Class representing the quantity Flour
 */

public class Flour implements Quantity<Flour> {


    public static final String QUANTITY_NAME = "flour";

    public static final FlourUnit REFERENCE_UNIT =  FlourUnit.GRAM;

    @Override
    public FlourUnit getReferenceUnit(){
        return REFERENCE_UNIT;
    }
}
