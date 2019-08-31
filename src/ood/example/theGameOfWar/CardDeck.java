package ood.example.theGameOfWar;
import java.util.Random;
public class CardDeck {
    private Card[] deck;
    private int numCards;
    private Random random;
    public CardDeck() {
        random = new Random();
        deck = new Card[52];
        fill();
    }

    public void shuffle() {
        for(int i = 0; i < numCards; ++i) {
            int j = random.nextInt(i + 1);
            exch(i, j);
        }
    }

    public Card deal() {
        if(numCards == 0) return null;
        else return deck[--numCards];
    }

    public int getSize() {
        return numCards;
    }

    private void fill() {
        int index = 0;
        for(int r = 1; r <= 13; ++r) {
            for(int s = 1; s <= 4; ++s) {
                deck[index++] = new Card(r, s);
            }
        }
        numCards = 52;
    }

    private void exch(int i, int j) {
        Card temp = deck[i];
        deck[i] = deck[j];
        deck[j] = temp;
    }

}
