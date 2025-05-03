package org.hbrs.se1.ss25.uebung03;

import org.hbrs.se1.ss25.uebung02.CardBox;
import org.hbrs.se1.ss25.uebung02.CardBoxException;
import org.hbrs.se1.ss25.uebung02.DeveloperCards;
import org.hbrs.se1.ss25.uebung02.*;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Client {
    static CardBox Container = CardBox.getInstance();
    public static void main(String[] args) throws CardBoxException, CardboxStorageException {
        zwei();
    }
    public static void eins() throws CardBoxException, CardboxStorageException {
        DeveloperCards EIns = new DeveloperCards("Max","Mustermann",true);

        Container.addPersonCard(EIns);
        PersonCardView.showContent(Container.getPersonList());
        Container.save();
    }
    public static void zwei() throws CardboxStorageException {
        CardBox Container = CardBox.getInstance();
        Container.load();
        PersonCardView.showContent(Container.getPersonList());
    }
}
