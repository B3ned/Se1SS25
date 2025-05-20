package org.hbrs.se1.ss25.uebung04;


public class DeveloperCards extends Card implements PersonCard {

    private boolean hasEnoughCoffee;

    public DeveloperCards(String vorname, String nachname, boolean hasEnoughCoffee) {
        super(vorname,nachname);
        this.hasEnoughCoffee = hasEnoughCoffee;
    }

    public void setHasEnoughCoffee(boolean hasEnoughCoffee) {
        this.hasEnoughCoffee = hasEnoughCoffee;
    }

    public boolean hasEnoughCoffee() {
        return hasEnoughCoffee;
    }

    public String toString() {
        return "ID = " + getId()  + ", Vorname = " + getFirstName() + ", Nachname = " + getLastName() +
                ", hasEnoughCoffee = " + hasEnoughCoffee();
    }
}
