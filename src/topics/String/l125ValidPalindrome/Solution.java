package topics.String.l125ValidPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            while(!Character.isLetter(s.charAt(l)) && !Character.isDigit(s.charAt(l)) && l < r) l++;
            while(!Character.isLetter(s.charAt(r)) && !Character.isDigit(s.charAt(r)) && l < r) r--;
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {return false;}
            l++;
            r--;
        }
        return true;
    }

}
