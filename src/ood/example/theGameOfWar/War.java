package ood.example.theGameOfWar;

public class War {
    public static void main(String[] args) {
        Game g = new Game();
        g.play();
        Player winner = g.getWinner();
        if(winner == null) System.out.println("Tie game.");
        else System.out.println("Winner = " + winner.getName());
    }
}
