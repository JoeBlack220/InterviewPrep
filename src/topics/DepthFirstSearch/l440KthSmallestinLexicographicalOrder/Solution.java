package topics.DepthFirstSearch.l440KthSmallestinLexicographicalOrder;

public class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;
        while (k > 0) {
            // count how many numbers smaller than n are between curr and curr + 1 in lexical order
            int steps = calSteps(n, curr, curr + 1);
            // if steps <= k, it means that k should start with curr + 1 or even bigger prefix
            if (steps <= k) {
                curr += 1;
                k -= steps;
            } else {
                // if steps > k, it means that k should start with prefix curr
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }
    //use long in case of overflow
    public int calSteps(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}