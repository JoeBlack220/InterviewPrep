package topics.String.l159LongestSubstringwithAtMostTwoDistinctCharacters;

public class Solution {
    // same question compare to Fruit Into Baskets
    // two pointers time O(n) space O(1)
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int firstC = 0, secondC = 0;
        int start = 0, end = 0, len = s.length();
        int res = 0;
        char first =' ', second = ' ';
        while(end < len) {
            char cur = s.charAt(end);
            if(cur == first) {
                firstC++;
            }
            else if(cur == second) {
                secondC++;
            }
            else {
                while(firstC != 0 && secondC != 0) {
                    if(s.charAt(start) == first) firstC--;
                    else secondC--;
                    start++;
                }
                if(firstC == 0) {
                    first = cur;
                    firstC = 1;
                }
                else {
                    second = cur;
                    secondC = 1;
                }
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}
