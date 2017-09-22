package com.suzeannekorteland.unitconverter.quantity;


import com.suzeannekorteland.unitconverter.unit.DigitalStorageUnit;

/**
 * Class representing the quantity Digital Storage
 */

public class DigitalStorage implements Quantity<DigitalStorage> {

    public static final String QUANTITY_NAME = "digital storage";

    public static final DigitalStorageUnit REFERENCE_UNIT = DigitalStorageUnit.BIT;


    @Override
    public DigitalStorageUnit getReferenceUnit(){
        return REFERENCE_UNIT;
    }
}