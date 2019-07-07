package cc189.chapter1;

public class PalindromePermutation {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.check1("Tact Coa"));
        System.out.println(sol.check2("Tsact Cosa"));
        System.out.println(sol.check3("Tsact Cosa"));
    }
    // space O(26) time O(n)
    static class Solution {
        public boolean check1(String s1) {
            int[] dict = new int[26];
            for(char c: s1.toCharArray()) {
                if(c == ' ') continue;
                dict[Character.toLowerCase(c) - 'a'] ++;
            }
            boolean flag = false;
            for(int num :dict) {
                if(num % 2 != 0) {
                    if(flag) return false;
                    flag = true;
                }
            }
            return true;
        }
        // little optimization, check characters that appear odd time while build the
        // dict table.
        public boolean check2(String s1) {
            int[] dict = new int[26];
            int oddCount = 0;
            for(char c: s1.toCharArray()) {
                if (c == ' ') continue;
                int index = Character.toLowerCase(c) - 'a';
                dict[index]++;
                if (dict[index] % 2 != 0) oddCount++;
                else oddCount--;
            }
            return oddCount <= 1;
        }

        // space O(1) time O(n)
        public boolean check3(String s1) {
            int bitVector = createBitVector(s1);
            return bitVector == 0 || checkExactlyOneBitSet(bitVector);
        }

        private int createBitVector(String s1) {
            int bitVecotr = 0;
            for(char c: s1.toCharArray()) {
                if(c == ' ') continue;
                int index = Character.toLowerCase(c) - 'a';
                bitVecotr = toggle(bitVecotr, index);
            }
            return bitVecotr;
        }

        private int toggle(int bitVector, int x) {
            return bitVector ^ (1 << x);
        }

        private boolean checkExactlyOneBitSet(int bitVector) {
            return (bitVector & (bitVector - 1)) == 0;
        }
    }

}
