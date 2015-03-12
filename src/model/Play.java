/*
 * Play.java: modello di una partita al gioco delle tre carte.
 */
package model;

/**
 *
 * @author Sandro
 */
public class Play {

    private final String backImg;
    private final Hand theHand;
    private int win, lose, tot;

    public Play() {
        win = lose = 0;
        backImg = "/view/resources/retro.jpg";
        Card asso = new Card("Asso", "/view/resources/asso.jpg");
        Card cavallo = new Card("Cavallo", "/view/resources/cavallo.jpg");
        Card re = new Card("Re", "/view/resources/re.jpg");
        theHand = new Hand(asso, cavallo, re);
        theHand.Shuffle();
    }

    public void newHand() {
        theHand.Shuffle();
    }

    public Card getCard(int idx) {
        return (idx < 0 || idx > 2 ? null : theHand.getCard(idx));
    }

    public boolean isWinner(int idx) {
        if (idx == theHand.getWinner()) {
            win++;
            return true;
        }
        lose++;
        return false;
    }

    public String getBackImg() {
        return backImg;
    }

    public int getPercentage() {
        if ((win + lose) == 0) {
            return 0;
        }
        return (win * 100 / (win + lose));
    }

    public int num_win() {
        return win;
    }

    public int tot_played() {
        tot = win + lose;
        return tot;
    }

    public void reset() {
        win = 0;
        lose = 0;
        tot = 0;
    }

    public double rapporto() {
        if (tot == 0) {
            return 0;
        }
        double r = getPercentage();
        System.out.println(r);
        return r / 100;
    }
    
}
