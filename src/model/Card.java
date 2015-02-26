/*
 * Card.java: modella gli oggetti di tipo Carta.
 */
package model;

/**
 *
 * @author Sandro
 */
public class Card {

    String name, frontImg;

    public Card(String name, String frontImg) {
        this.name = name;
        this.frontImg = frontImg;
    }

    public String getName() {
        return name;
    }

    public String getFrontImg() {
        return frontImg;
    }

}
