package com.suzeannekorteland.unitconverter.quantity;


import com.suzeannekorteland.unitconverter.unit.TimeUnit;


/**
 * Class representing the quantity Time
 */

public class Time implements Quantity<Time> {

    public static final String IC_RESOURCE_NAME = "ic_time_white_24dp";

    public static final String QUANTITY_NAME = "time";

    public static final TimeUnit REFERENCE_UNIT =  TimeUnit.SECOND;

    @Override
    public TimeUnit getReferenceUnit(){
        return REFERENCE_UNIT;
    }
}
