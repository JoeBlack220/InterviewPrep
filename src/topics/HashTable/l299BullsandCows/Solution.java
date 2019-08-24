package topics.HashTable.l299BullsandCows;

public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] dict = new int[10];
        for(int i = 0; i < secret.length(); ++i) {
            char c = secret.charAt(i);
            if(c == guess.charAt(i)) bulls++;
            else dict[c - '0'] ++;
        }
        for(int i = 0; i < guess.length(); ++i) {
            char c = guess.charAt(i);
            if(secret.charAt(i) != c && dict[c - '0'] > 0) {
                cows++;
                dict[c - '0']--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}