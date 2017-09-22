package com.suzeannekorteland.unitconverter.quantity;

import com.suzeannekorteland.unitconverter.conversion.Conversion;
import com.suzeannekorteland.unitconverter.conversion.UnitConverter;
import com.suzeannekorteland.unitconverter.unit.Unit;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * class representing a measurement consisting of a value and a unit
 */

public final class Measurement<T extends Quantity<T>> {


    private final double value;
    private final Unit<T> unit;

    public <V extends Number> Measurement(V value, Unit<T> unit) {
        this.value = value.doubleValue();
        this.unit = unit;
    }

    public Unit<T> getUnit(){

        return unit;
    }

    public double getValue(){
        return value;
    }


    public String formattedString(int decimals) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(decimals, RoundingMode.HALF_UP);

        return bd.toString() + " " + unit.getFriendlyName();
    }
    
    public Measurement<T> convertTo(Unit<T> newUnit){

        UnitConverter<T> converter = unit.getUnitConverterTo(newUnit);
        double convertedValue = converter.convert(value);

        return new Measurement<T>(convertedValue, newUnit);

    }


    @Override
    public String toString(){
        return value + " " +  unit.getFriendlyName();
    }
    
  

}
