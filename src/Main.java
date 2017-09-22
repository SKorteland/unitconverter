import com.suzeannekorteland.unitconverter.quantity.*;
import com.suzeannekorteland.unitconverter.unit.*;

public class Main {

    public static void main(String[] args) {
        
        //Example of usage
        
        //convert gram to ounce
        Measurement<Mass> meas = new Measurement<>(30, MassUnit.GRAM);
        
        Measurement<Mass> converted = meas.convertTo(MassUnit.OUNCE);
        
        System.out.println("converted " + meas.formattedString(2) + " to " + converted.formattedString(2));
        
        
        
        
    }
}
