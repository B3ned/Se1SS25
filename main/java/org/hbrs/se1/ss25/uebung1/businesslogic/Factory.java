package org.hbrs.se1.ss25.uebung1.businesslogic;

public class Factory {
    public static HexNumberTransformer HexTransformer() {
        return new HexNumberTransformer();
    }
}
