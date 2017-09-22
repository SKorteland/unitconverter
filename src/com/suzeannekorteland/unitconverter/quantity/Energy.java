package com.suzeannekorteland.unitconverter.quantity;


import com.suzeannekorteland.unitconverter.unit.EnergyUnit;


/**
 * Class representing the physical quantity Energy
 */

public class Energy implements Quantity<Energy> {

    public static final String QUANTITY_NAME = "energy";

    public static final EnergyUnit REFERENCE_UNIT =  EnergyUnit.JOULE;

    @Override
    public EnergyUnit getReferenceUnit(){
        return REFERENCE_UNIT;
    }
}