package org.hbrs.se1.ss25.uebung02;

public abstract class Card implements PersonCard {
    private final String vorname;
    private final String nachname;
    private final int id;
    private static int idGen = 3000;

    public Card(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.id = idGen++;
    }
    @Override
    public String getFirstName() {
        return this.vorname;
    }
    @Override
    public String getLastName() {
        return this.nachname;
    }
    @Override
    public int getId() {
        return this.id;
    }

}
