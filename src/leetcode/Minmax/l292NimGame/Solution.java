package leetcode.Minmax.l292NimGame;

public class Solution {
    // we go first, so we should make the rest of the stones a multiple of 4
    // this way we can always make four after our opponent take from the piles
    // so if the total number is not a multiple of 4, we will win
    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }
}
