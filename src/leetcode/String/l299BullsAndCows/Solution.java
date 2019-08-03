package leetcode.String.l299BullsAndCows;

public class Solution {
    // space O(n)
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        int[] rec = new int[10];
        for(int i = 0; i < secret.length(); ++i) {
            if(secret.charAt(i) == guess.charAt(i)) {
                A++;
            }
            else {
                rec[secret.charAt(i) - '0']++;
            }
        }
        for(int i = 0; i < guess.length(); ++i) {
            if(secret.charAt(i) != guess.charAt(i)) {
                if(rec[guess.charAt(i) - '0'] > 0) {
                    B++;
                    rec[guess.charAt(i) -'0'] --;
                }
            }
        }
        return Integer.toString(A) + "A" + Integer.toString(B) + "B";
    }
    // one-pass version
    public String getHint2(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
                if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
