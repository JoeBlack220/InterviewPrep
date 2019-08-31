package ood.example.theGameOfWar;

public class Pile {
    private Card[] pile;
    private int front, end;
    public Pile() {
        pile = new Card[52];
        front = 0;
        end = 0;
    }

    public int getSize() {
        return end - front;
    }

    public void clear() {
        front = 0;
        end = 0;
    }

    public void addCard(Card c) {
        pile[end++] = c;
    }

    public Card nextCard() {
        if(front == end) return null;
        else return pile[front++];
    }

    public void addCards(Pile p) {
        while(p.getSize() > 0) {
            addCard(p.nextCard());
        }
    }

}
