package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.quantity.Quantity;

/**
 * Converter converting a value expressed in one unit of measure to another unit of measure of the
 * same quantity
 */

public interface UnitConverter<T extends Quantity<T>> {

    /**
     * convert a value from the old unit to the new unit
     * @param value the value (amount) to be converted
     * @param <V> a number
     * @return the converted value, now expressed in the new unit
     */
    <V extends Number> double convert(V value);

}
