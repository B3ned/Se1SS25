package org.hbrs.se1.ss25.uebung1.businesslogic;

public class HexNumberTransformer implements NumberTransformer {
    @Override
    public String transformNumber(int number) {
        if(!(0 <= number && number < 65536)) {
            return "Außerhalb des Wertebereiches";
        }
        return Integer.toHexString(number);
    }

    @Override
    public String getTransformerType() {
        return "Transformer für Hexadezimalzahlen";
    }
}
