package com.suzeannekorteland.unitconverter.conversion;

import com.suzeannekorteland.unitconverter.quantity.Measurement;
import com.suzeannekorteland.unitconverter.quantity.Quantity;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This class represents a conversion from one measurement to another of the same quantity
 */

public final class Conversion implements Comparable<Conversion> {

    private final double fromValue;
    private final double toValue;
    private final String fromUnitSymbol;
    private final String toUnitSymbol;
    private final String quantityString;

    public <T extends Quantity<T>> Conversion(Measurement<T> from, Measurement<T> to) {
        // the measurements are broken down into simple, non-generic data-types
        // to facilitate easy storage
        this.fromValue = from.getValue();
        this.toValue = to.getValue();
        this.fromUnitSymbol = from.getUnit().getSymbol();
        this.toUnitSymbol = to.getUnit().getSymbol();
        this.quantityString= from.getUnit().getQuantityName();


    }
    public String getFormattedString(int d, String compare){
            return formatValue(fromValue, d) + " " + fromUnitSymbol +
                    compare + formatValue(toValue, d) + " " + toUnitSymbol;
    }

    public String getQuantityString() {
        return quantityString;
    }

    public String getFromUnitSymbol() { return fromUnitSymbol;}

    public String getToUnitSymbol() { return toUnitSymbol;}

    public String getFormattedFromValue(int d) { return formatValue(fromValue, d);}

    public String getFormattedToValue(int d) { return formatValue(toValue, d);}


    private String formatValue(double value, int decimals) {

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(decimals, RoundingMode.HALF_UP);

        return bd.toString();

    }

    @Override
    public String toString() {
        // TODO: this is a temporary string solution, it should format the values using the
        // number of decimals set by the user
        return fromValue + " " + fromUnitSymbol +
                " = " + toValue + " " + toUnitSymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Conversion)) {
            return false;
        }

        Conversion c = (Conversion) o;

        return (Double.compare(fromValue, c.fromValue) == 0 && Double.compare(toValue, c.toValue) == 0) &&
                    fromUnitSymbol.equals(c.fromUnitSymbol) && toUnitSymbol.equals(c.toUnitSymbol) &&
                quantityString.equals(c.quantityString);
    }

    
    @Override
    public int hashCode() {
     // Compute hashcode as suggested in Effective Java, Joshua Bloch
        int result = 17;
        long bits = Double.doubleToLongBits(fromValue);
        result = 31 * result + (int) (bits ^ (bits >>> 32));
        bits = Double.doubleToLongBits(toValue);
        result = 31 * result + (int)(bits ^ (bits >>> 32));
        result = 31 * result + fromUnitSymbol.hashCode();
        result = 31 * result + toUnitSymbol.hashCode();
        result = 31 * result + quantityString.hashCode();

        return result;
    }


    @Override
    public int compareTo(Conversion other) {

        // Compare quantity type
        if (quantityString.compareTo(other.quantityString) < 0) {
            return -1;
        }
        if (quantityString.compareTo(other.quantityString) > 0) {
            return 1;
        }

        // compare from unit
        if (fromUnitSymbol.compareTo(other.fromUnitSymbol) < 0) {
            return -1;
        }
        if (fromUnitSymbol.compareTo(other.fromUnitSymbol) > 0) {
            return 1;
        }

        // compare to unit
        if (toUnitSymbol.compareTo(other.toUnitSymbol) < 0) {
            return -1;
        }
        if (toUnitSymbol.compareTo(other.toUnitSymbol) > 0) {
            return 1;
        }

        // compare from value
        if (Double.compare(fromValue, other.fromValue) < 0) {
            return -1;
        }
        if (Double.compare(fromValue, other.fromValue) > 0) {
            return 1;
        }

        //compare to value
        if (Double.compare(toValue, other.toValue) < 0) {
            return -1;
        }
        if (Double.compare(toValue, other.toValue) > 0) {
            return 1;
        }

       

        // all fields are equal
        return 0;
    }
}
