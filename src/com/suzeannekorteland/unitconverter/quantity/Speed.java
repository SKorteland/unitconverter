package com.suzeannekorteland.unitconverter.quantity;

import com.suzeannekorteland.unitconverter.unit.SpeedUnit;


/**
 * Class representing the physical quantity Speed
 */

public class Speed implements Quantity<Speed> {

    public static final String IC_RESOURCE_NAME = "ic_speed_white_24dp";
    public static final String QUANTITY_NAME = "speed";
    public static final SpeedUnit REFERENCE_UNIT =  SpeedUnit.METRE_PER_SECOND;

    @Override
    public SpeedUnit getReferenceUnit(){
        return REFERENCE_UNIT;
    }
}
