package org.hbrs.se1.ss25.uebung1.businesslogic;
import org.hbrs.se1.ss25.uebung1.client.Client;

import java.text.DecimalFormat;

public class GermanFormatNumberTransformer implements NumberTransformer {
    @Override
    public String transformNumber(int number) {
        if(!(0 <= number && number < 65536)) {
            return "Außerhalb des Wertebereiches";
        }
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(number);
    }

    @Override
    public String getTransformerType() {
        return "Transformer für deutsche Zahlenformatierung";
    }

}
