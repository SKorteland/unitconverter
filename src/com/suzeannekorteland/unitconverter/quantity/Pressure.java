package com.suzeannekorteland.unitconverter.quantity;

import com.suzeannekorteland.unitconverter.unit.PressureUnit;

/**
 * Class representing the physical quantity Pressure
 */

public class Pressure implements Quantity<Pressure> {

    public static final String IC_RESOURCE_NAME = "ic_pressure_white_24dp";

    public static final String QUANTITY_NAME = "pressure";

    public static final PressureUnit REFERENCE_UNIT =  PressureUnit.PASCAL;

    @Override
    public PressureUnit getReferenceUnit(){
        return REFERENCE_UNIT;
    }
}