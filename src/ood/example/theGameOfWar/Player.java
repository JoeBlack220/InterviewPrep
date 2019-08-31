package ood.example.theGameOfWar;

public class Player {
    private Pile playPile, wonPile;
    private String name;

    public Player(String n) {
        name = n;
        playPile = new Pile();
        wonPile = new Pile();
    }

    public Card playCard() {
        if(playPile.getSize() == 0) {
            useWonPile();
        }
        if(playPile.getSize() > 0) {
            return playPile.nextCard();
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public void collectCard(Card c) {
        wonPile.addCard(c);
    }

    public void collectCards(Pile p) {
        wonPile.addCards(p);
    }

    public void useWonPile() {
        playPile.clear();
        playPile.addCards(wonPile);
        wonPile.clear();
    }

    public int numCards() {
        return playPile.getSize() + wonPile.getSize();
    }
}
