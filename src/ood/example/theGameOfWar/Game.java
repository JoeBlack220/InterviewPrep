package ood.example.theGameOfWar;

public class Game {
    private Player p1, p2;

    public void play() {
        CardDeck cd = new CardDeck();
        cd.shuffle();
        p1 = new Player("Ernie");
        p2 = new Player("Burt");

        while(cd.getSize() >= 2) {
            p1.collectCard(cd.deal());
            p2.collectCard(cd.deal());
        }
        p1.useWonPile();
        p2.useWonPile();
        Pile down = new Pile(); // pile used for cards in a war

        for(int t = 1; t <= 100; ++t) {
            if(!enoughCards(1)) break;
            Card c1 = p1.playCard();
            Card c2 = p2.playCard();
            System.out.println("\nTurn " + t + ": ");
            System.out.println(p1.getName() + ": " + c1 + " ");
            System.out.println(p2.getName() + ": " + c2 + " ");
            int compVal = c1.compareTo(c2);
            if(compVal > 0) {
                p1.collectCard(c1);
                p1.collectCard(c2);
            }
            else if(compVal < 0) {
                p2.collectCard(c1);
                p2.collectCard(c2);
            }
            else {
                down.clear();
                down.addCard(c1);
                down.addCard(c2);
                boolean done = false;
                while(!done) {
                    int num = c1.getRank();
                    if(!enoughCards(num)) break;
                    System.out.println("War! Players put down " + num + " card(s),");

                    for(int m = 1; m <= num; ++m) {
                        c1 = p1.playCard();
                        c2 = p2.playCard();
                        down.addCard(c1);
                        down.addCard(c2);
                    }
                    System.out.println(p1.getName() + ": " + c1 + " ");
                    System.out.println(p2.getName() + ": " + c2 + " ");
                    compVal = c1.compareTo(c2);
                    if(compVal > 0) {
                        p1.collectCards(down);
                        done = true;
                    }
                    else if(compVal < 0) {
                        p2.collectCards(down);
                        done = true;
                    }
                }
            }
            System.out.println(p1.numCards() + " to " + p2.numCards());

        }
    }

    public boolean enoughCards(int n) {
        return !(p1.numCards() < n || p2.numCards() < n);
    }

    public Player getWinner() {
        if(p1.numCards() > p2.numCards()) return p1;
        else if(p1.numCards() < p2.numCards()) return p2;
        else return null;
    }
}
