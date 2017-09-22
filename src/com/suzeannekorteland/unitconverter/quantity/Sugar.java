package com.suzeannekorteland.unitconverter.quantity;

import com.suzeannekorteland.unitconverter.unit.SugarUnit;


/**
 * Class representing the quantity Sugar (weight or volume)
 */

public class Sugar implements Quantity<Sugar> {

    public static final String IC_RESOURCE_NAME = "ic_sugar_white_24dp";

    public static final String QUANTITY_NAME = "sugar";
    public static final SugarUnit REFERENCE_UNIT =  SugarUnit.GRAM;


    @Override
    public SugarUnit getReferenceUnit(){
        return REFERENCE_UNIT;
    }
}