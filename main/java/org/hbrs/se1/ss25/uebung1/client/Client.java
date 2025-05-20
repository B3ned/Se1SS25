package org.hbrs.se1.ss25.uebung1.client;

import org.hbrs.se1.ss25.uebung1.businesslogic.Factory;

public class Client {
    public void printTransformation(int number) {
        String result = Factory.HexTransformer().transformNumber(number);
        System.out.println("Die Hexadezimaldarstellung der Zahl " + number + " ist: " + result);
    }
}
