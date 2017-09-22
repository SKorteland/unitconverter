# Unit Conversion for Java

This code allows basic unit conversion between pre-defined units of several quantities

### Usage examples

To create units of a particular quantity:
Unit<Length> lengthUnit = LengthUnit.METER;
Unit<Temperature> temperatureUnit = TemperatureUnit.CELCIUS;

To create a measurement consisting of a value and a unit of of a particular quantity:
Measurement meas = new Measurement(1.0, MassUnit.Kilogram);

To create a converter from one unit to another unit of the same quantity:
UnitConverter<Mass> converter = new MassConverter(MassUnit.GRAM, MassUnit.OUNCE);
UnitConverter<Mass> converter = MassUnit.GRAM.getUnitConverterTo(MassUnit.OUNCE);

To convert:
double result = converter.convert(1.52);

 or
 
 Measurement meas = new Measurement(10.45, LengthUnit.INCH);
 Conversion conversion = meas.convertTo(LengthUnit.CENTIMETER);
 
 where conversion is an object containing the from- and to units and the from- and to values of the conversion.
 