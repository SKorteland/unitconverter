package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.conversion.UnitConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;
import com.suzeannekorteland.unitconverter.quantity.Quantity;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * An immutable type representing a unit of measurement for a quantity
 * @param <T> the quantity type of the unit
 */

public interface Unit<T extends Quantity<T>> {

    /**
     * get the symbol representing the unit
     * @return symbol representing the unit
     */
    String getSymbol();

    /**
     * get the reference factors of the unit. These factors convert a value expressed in the unit
     * to a value expressed in the reference unit
     * @return an array with two values representing the slope (a) and intercept (b) of a linear conversion
     * curve: y = ax+b, where y is a value expressed in the reference unit, and x is a value
     * expressed in the current unit.
     */
    double[] getToReferenceFactors();

    /**
     * get a UnitConverter that converts the current unit to another unit of the same type
     * @param that the unit which to convert to
     * @return a UnitConverter
     */
    UnitConverter<T> getUnitConverterTo(Unit<T> that);

    /**
     * get the display-friendly name of the unit
     * @return the display-friendly name of the unit
     */
    String getFriendlyName();

    /**
     * get the quantity type of the unit
     * @return the quantity type of the unit
     */
    Type getQuantityType();

    /**
     * get the name of the quantity the unit is a measure of
     * @return the name of the quantity the unit is a measure of
     */
    String getQuantityName();


    /**
     * get a list of all units for the quantity
     * @return a list of all display-friendly unit names for the quantity
     */
    List<String> getUnitsList();

    /**
     * create a measurement consisting of a value and a unit
     * @param value the value of the measurement
     * @return a new measurement consisting of a value and a unit
     */
    Measurement<T> createMeasurement(Number value);

    /**
     * get the unit class
     * @return the unit class
     */
    Class<?> getConcreteUnitClass();

    /**
     * generate a mapping of display-friendly unit names to the actual unit
     * @return a mapping of display friendly unit names to actual units
     */
    Map<String, Unit<T>> getUnitMapping();



}
