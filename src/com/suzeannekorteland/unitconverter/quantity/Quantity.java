package com.suzeannekorteland.unitconverter.quantity;

import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 * Represents a property that can be quantified.
 */

public interface Quantity<T extends Quantity<T>> {

    /**
     * get the reference unit of the quantity. For SI quantities, this will be the SI unit. For non-SI quantities,
     * this will be the most commonly used unit.
     * @param <T> the quantity type
     * @return the reference (SI) unit of Quantity type T
     */
    Unit<T> getReferenceUnit();


}
