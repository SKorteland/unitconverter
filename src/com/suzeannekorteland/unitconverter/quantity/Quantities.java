package com.suzeannekorteland.unitconverter.quantity;

import com.suzeannekorteland.unitconverter.unit.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The quantities that can be converted 
 */

public enum Quantities {
    ANGLE(Angle.QUANTITY_NAME, 0, Angle.REFERENCE_UNIT),
    AREA(Area.QUANTITY_NAME, 1, Area.REFERENCE_UNIT),
    BUTTER(Butter.QUANTITY_NAME, 2, Butter.REFERENCE_UNIT),
    DIGITALSTORAGE(DigitalStorage.QUANTITY_NAME, 3, DigitalStorage.REFERENCE_UNIT),
    ENERGY(Energy.QUANTITY_NAME, 4, Energy.REFERENCE_UNIT),
    FLOUR(Flour.QUANTITY_NAME, 5, Flour.REFERENCE_UNIT),
    LENGTH(Length.QUANTITY_NAME, 6, Length.REFERENCE_UNIT),
    MASS(Mass.QUANTITY_NAME, 7,  Mass.REFERENCE_UNIT),
    PRESSURE(Pressure.QUANTITY_NAME, 8, Pressure.REFERENCE_UNIT),
    SPEED(Speed.QUANTITY_NAME, 9, Speed.REFERENCE_UNIT),
    SUGAR(Sugar.QUANTITY_NAME, 10, Sugar.REFERENCE_UNIT),
    TEMPERATURE(Temperature.QUANTITY_NAME, 11, Temperature.REFERENCE_UNIT),
    TIME(Time.QUANTITY_NAME, 12, Time.REFERENCE_UNIT),
    VOLUME(Volume.QUANTITY_NAME, 13, Volume.REFERENCE_UNIT);



    private final String friendlyName;
    private final int idx;
    private final Unit<?> referenceUnit;
    public static final Quantities DEFAULT = ANGLE;


    Quantities(String name, int idx, Unit<?> ref) {
        this.friendlyName = name;
        this.idx = idx;
        this.referenceUnit = ref;
    }


    public int getIdx() {
        return idx;
    }


    public static List<Quantities> getQuantities() {
        List<Quantities> list = new ArrayList<>();
        for (Quantities q : values()) {
            list.add(q);
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public String toString() {
        return friendlyName;
    }

    /**
     * get a Quantities enum value from a String
     * @param filterStr the string to get the enum from
     * @return the enum value who's toString() method returns the same
     * string as the inputstring. If there is no matching enum value,
     * return the default enum value.
     */
    public static Quantities getFromString(String filterStr) {
        // Log.v(TAG, "inputString = " + filterStr);
        if (filterStr != null) {
            for (Quantities q : values()) {
                // Log.v(TAG, "compare against: " + u.friendlyName);
                if (q.friendlyName.equalsIgnoreCase(filterStr)) {
                    return q;
                }
            }
        }
        return DEFAULT;
    }

    public List<String> getUnitList() {
        return referenceUnit.getUnitsList();
    }


    public static Map<String, Unit<? extends Quantity<?>>> getUnitMapping() {
        Map<String, Unit<? extends Quantity<?>>> map = new HashMap<>();
        for (Quantities q : Quantities.values()) {
            map.putAll(q.referenceUnit.getUnitMapping());
        }

        return map;
    }



}
