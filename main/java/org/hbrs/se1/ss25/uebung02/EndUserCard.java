package org.hbrs.se1.ss25.uebung02;

public class EndUserCard extends Card implements PersonCard {

    private boolean isHungry;

    public EndUserCard(String vorname, String nachname, boolean isHungry) {
        super(vorname, nachname); this.isHungry = isHungry;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }

    public String toString() {
        return "ID = " + getId()  + ", Vorname = " + getFirstName() + ", Nachname = " + getLastName() +
                ", isHungry = " + isHungry();
    }


}
