package org.hbrs.se1.ss25.uebung04.uebung03;

import org.hbrs.se1.ss25.uebung02.PersonCard;

import java.util.ArrayList;

public class PersonCardView {
    public static void showContent(ArrayList<PersonCard> personList) {
            if (personList.isEmpty()) {
                return;
            }
            for (PersonCard personCard : personList) {
                System.out.println(personCard);
            }
    }
}
