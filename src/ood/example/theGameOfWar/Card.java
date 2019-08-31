package ood.example.theGameOfWar;

public class Card implements Comparable<Card> {
    private int rank;
    private int suit;
    public final static String[] suitList = new String[]{"", "Clubs", "Diamonds", "Hearts", "Spades"};
    public final static String[] rankList = new String[]{"", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
    "Jack", "Queen", "King"};

    public static void main(String[] args) {
        Card test1 = new Card(1, 1);
        Card test2 = new Card(13, 2);
        System.out.println(test1);
        System.out.println(test2);
    }

    public Card(int r, int s) {
        rank = r;
        suit = s;
    }

    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }

    public int compareTo(Card other) {
        int thisRank = rank;
        int otherRank = other.rank;
        if(thisRank == 1) thisRank = 14;
        if(otherRank == 1) otherRank = 14;
        return thisRank - otherRank;
    }

    public boolean equals(Object ob) {
        if(ob instanceof Card) {
            Card other = (Card)ob;
            return this.rank == other.rank && this.suit == other.suit;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(rankList[rank]);
        sb.append(" of ");
        sb.append(suitList[suit]);
        int i = sb.length() + 1;
        for(; i <= 17; i++) sb.append(" ");
        return sb.toString();
    }

}
