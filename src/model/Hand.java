/*
 * Hand.java: modello di una mano al gioco delle tre carte.
 */
package model;

import java.util.Random;

/**
 *
 * @author Sandro
 */
public class Hand {

    private static final Random randomizer = new Random(System.currentTimeMillis());
    private static final int[][] possibleHands = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};
    private static final int[] possibleIdxAsso = {0, 0, 1, 2, 1, 2};

    int idx_asso;
    Card[] cards, hand;

    public Hand(Card asso, Card b, Card c) {
        cards = new Card[3];
        hand = new Card[3];
        hand[0] = cards[0] = asso;
        hand[1] = cards[1] = b;
        hand[2] = cards[2] = c;
        idx_asso = 0;
        // Shuffle();
    }

    public Card getCard(int idx) {
        return (idx < 0 || idx > 2 ? null : hand[idx]);
    }

    public int getWinner() {
        return idx_asso;
    }

    
    /*
     * lancia una nuova mano di carte scegliendo a caso l'ordine delle tre carte
     */
    public int Shuffle() {
        int choosen = randomizer.nextInt(6);
        idx_asso = possibleIdxAsso[choosen];
        hand[0] = cards[possibleHands[choosen][0]];
        hand[1] = cards[possibleHands[choosen][1]];
        hand[2] = cards[possibleHands[choosen][2]];
        return choosen;
    }

}
