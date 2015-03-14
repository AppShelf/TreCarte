package model;

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
