package com.suzeannekorteland.unitconverter.quantity;

import com.suzeannekorteland.unitconverter.unit.VolumeUnit;


/**
 * Class representing the physical quantity Volume
 */

public class Volume implements Quantity<Volume> {

    public static final String IC_RESOURCE_NAME = "ic_volume_white_24dp";

    public static final String QUANTITY_NAME = "volume";

    public static final VolumeUnit REFERENCE_UNIT =  VolumeUnit.CUBIC_METRE;

    @Override
    public VolumeUnit getReferenceUnit(){
        return REFERENCE_UNIT;
    }
}
