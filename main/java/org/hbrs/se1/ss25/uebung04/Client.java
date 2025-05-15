package org.hbrs.se1.ss25.uebung04.uebung03;

import org.hbrs.se1.ss25.uebung02.CardBox;
import org.hbrs.se1.ss25.uebung02.CardBoxException;
import org.hbrs.se1.ss25.uebung02.DeveloperCards;

public class Client {
    public static void main(String[] args) throws CardBoxException, CardboxStorageException {
       zwei();
    }
    public static void eins() throws CardBoxException, CardboxStorageException {
        CardBox Container = CardBox.getInstance();
        DeveloperCards EIns = new DeveloperCards("ioajdfajf","oajeda",true);

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
