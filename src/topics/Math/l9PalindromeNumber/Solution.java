package topics.Math.l9PalindromeNumber;

public class Solution {
    public boolean isPalindrome(int x) {
        int cmp = x;
        if(x < 0) return false;
        int temp = 0, last = 0;
        while(x != 0) {
            temp *= 10;
            temp += x % 10;
            // handle overflow
            if(temp / 10 != last) return false;
            last = temp;
            x /= 10;
        }
        // System.out.println(x);
        return cmp == temp;
    }
}
