# Unit Conversion for Java

This code allows basic unit conversion between pre-defined units of several quantities

### Usage examples

To create units of a particular quantity:
Unit<Length> lengthUnit = LengthUnit.METER;
Unit<Temperature> temperatureUnit = TemperatureUnit.CELCIUS;

To create a measurement consisting of a value and a unit of of a particular quantity:
Measurement<Mass> meas = new Measurement<>(30.0, MassUnit.GRAM);

To convert a measurement into a measurement of another unit (e.g. gram to ounce):
Measurement<Mass> convertedMeas = meas.convertTo(MassUnit.OUNCE);

To print a measurement with a predefined number of decimals (e.g. 2 decimals):
System.out.println("converted " + meas.formattedString(2) " to " convertedMeas.formattedString(2);

To create a converter from one unit to another unit of the same quantity:
UnitConverter<Mass> converter = new MassConverter(MassUnit.GRAM, MassUnit.OUNCE);
UnitConverter<Mass> converter = MassUnit.GRAM.getUnitConverterTo(MassUnit.OUNCE);

Use a converter to convert:
double result = converter.convert(1.52);

a Conversion object contains the from- and to units and the from and to values of a conversion:
Conversion conversion = meas.convertTo()
 