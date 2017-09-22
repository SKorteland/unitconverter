package com.suzeannekorteland.unitconverter.quantity;

import com.suzeannekorteland.unitconverter.unit.TemperatureUnit;


/**
 * Class representing the physical quantity Temperature
 */

public class Temperature implements Quantity<Temperature> {

    public static final String IC_RESOURCE_NAME = "ic_temperature_white_24dp";

    public static final String QUANTITY_NAME = "temperature";

    public static final TemperatureUnit REFERENCE_UNIT =  TemperatureUnit.KELVIN;

    @Override
    public TemperatureUnit getReferenceUnit(){
        return REFERENCE_UNIT;
    }
}
