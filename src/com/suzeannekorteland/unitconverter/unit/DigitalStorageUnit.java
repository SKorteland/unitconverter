package com.suzeannekorteland.unitconverter.unit;

import com.suzeannekorteland.unitconverter.quantity.DigitalStorage;
import com.suzeannekorteland.unitconverter.conversion.DigitalStorageConverter;
import com.suzeannekorteland.unitconverter.quantity.Measurement;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * enum representing units for digital storage
 */

public enum DigitalStorageUnit implements Unit<DigitalStorage> {

    BIT("bit (b)", "b", 1),
    KILOBIT("kilobit (kb)", "kb", 1000),
    MEGABIT("megabit (Mb)", "Mb", 1e6),
    GIGABIT("gigabit (Gb)", "gb", 1e9),
    TERABIT("terabit (Tb)", "Tb", 1e12),
    PETABIT("petabit (Pb)", "Pb", 1e15),
    KIBIBIT("kibibit (Kibit)", "Kibit", 1024),
    MEBIBIT("mebibit (Mibit)", "Mibit", 1.048576e6),
    GIBIBIT("gibibit (Gibit)", "Gibit", 1.073741824e9),
    TEBIBIT("tebibit (Tibit)", "Tibit", 1.0995116e12),
    NIBBLE("nibble" ,"nibble", 4),
    BYTE("byte (B)", "B", 8),
    KILOBYTE("kilobyte (KB)", "KB", 8000),
    MEGABYTE("megabyte (MB)", "MB", 8e6),
    GIGABYTE("gigabyte (GB)", "GB", 8e9),
    TERABYTE("terabyte (TB)", "TB", 8e12),
    PETABYTE("petabyte (PB)", "PB", 8e15),
    KIBIBYTE("kibibyte (KiB)", "Kib", 8192),
    MEBIBYTE("mebibyte (MiB)", "Mib", 8.388608e6),
    GIBIBYTE("gibibyte (GiB)", "GiB", 8.589934592e9),
    TEBIBYTE("tebibyte (TiB)", "TiB", 8.796093e12),
    PEBIBYTE("pebibyte (PiB)", "PiB", 9.0071993e15);

    private final String friendlyName;
    private final String symbol;
    private final double[] referenceFactors;

    DigitalStorageUnit(String friendly, String symbol, double factor){
        this.friendlyName = friendly;
        this.symbol = symbol;
        this.referenceFactors = new double[]{factor, 0};
    }

    @Override
    public double[] getToReferenceFactors(){
        return referenceFactors;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public DigitalStorageConverter getUnitConverterTo(Unit<DigitalStorage> that){

        if (this.getClass() == that.getClass()) {
            return new DigitalStorageConverter(this, that);
        } else {
            throw new IllegalArgumentException("The units for conversion are incompatible");
        }


    }

    @Override
    public String getFriendlyName(){
        return friendlyName;
    }

    @Override
    public Map<String, Unit<DigitalStorage>> getUnitMapping() {
        Map<String, Unit<DigitalStorage>> map = new HashMap<>();
        for (DigitalStorageUnit unit : values()) {
            map.put(unit.friendlyName, unit);
        }
        return map;
    }

    @Override
    public Class<?> getQuantityType() {
        return DigitalStorage.class;
    }

    @Override
    public String getQuantityName() {
        return DigitalStorage.QUANTITY_NAME;
    }


    @Override
    public List<String> getUnitsList() {
        List<String> list = new ArrayList<>();
        for (DigitalStorageUnit unit : values()) {
            list.add(unit.friendlyName);
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public Measurement<DigitalStorage> createMeasurement(Number value) {
        return new Measurement<DigitalStorage>(value,this);
    }

    @Override
    public Class<?> getConcreteUnitClass() {
        return this.getClass();
    }

}
