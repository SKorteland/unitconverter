package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.quantity.Temperature;
import com.suzeannekorteland.unitconverter.unit.Unit;

/**
 * This class performs conversions between units of temperature
 */

public class TemperatureConverter implements UnitConverter<Temperature> {

    private Unit<Temperature> fromUnit;
    private Unit<Temperature> toUnit;

    public TemperatureConverter(Unit<Temperature> from, Unit<Temperature> to){
        this.fromUnit = from;
        this.toUnit = to;
    }

    @Override
    public <V extends Number> double convert(V value) {
        double[] fromUnitFactors = fromUnit.getToReferenceFactors();
        double valueInBase = value.doubleValue()* fromUnitFactors[0] + fromUnitFactors[1];

        double[] toUnitFactors = toUnit.getToReferenceFactors();
        double valueInToUnit = (valueInBase - toUnitFactors[1]) / toUnitFactors[0];
        return valueInToUnit;
    }


}
