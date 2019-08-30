package topics.String.l564FindtheClosestPalindrome;

public class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();
        boolean isEven = len % 2 == 0;

        if(case1(num)) return Long.toString(num - 1);
        if(case2(num)) return Long.toString(num - 2);
        if(case3(num)) return Long.toString(num + 2);

        long base = isEven ? Long.parseLong(n.substring(0, n.length() / 2)) :
                Long.parseLong(n.substring(0, n.length() / 2 + 1));

        // palindrom with the equal base, bigger base or smaller base
        long ePalindrom = getPalindrom(base, isEven);
        long bPalindrom = getPalindrom(base + 1, isEven);
        long sPalindrom = getPalindrom(base - 1, isEven);

        long eDiff = Math.abs(num - ePalindrom);
        long bDiff = Math.abs(num - bPalindrom);
        long sDiff = Math.abs(num - sPalindrom);

        long minDiff = 0, res = 0;

        if(sDiff <= bDiff) {
            minDiff = sDiff;
            res = sPalindrom;
        }
        else {
            minDiff = bDiff;
            res = bPalindrom;
        }

        if(eDiff != 0) {
            if(eDiff < minDiff) res = ePalindrom;
            else if(eDiff == minDiff) {
                res = Math.min(res, ePalindrom);
            }
        }

        return Long.toString(res);

    }

    private long getPalindrom(long base, boolean isEven) {
        StringBuilder sb = new StringBuilder();
        sb.append(base);
        int len = sb.length();
        for(int i = len - 1; i >= 0; --i) sb.append(sb.charAt(i));
        if(!isEven) sb.deleteCharAt(sb.length() / 2);
        return Long.parseLong(sb.toString());
    }

    // <= 10 || 100, 1000, 10000 simply + 1
    private boolean case1(long num) {
        if(num <= 10) return true;
        while(num > 1) {
            if(num % 10 != 0) return false;
            num /= 10;
        }
        return true;
    }

    // case when num equals to 101 1001 10001
    // simply - 2
    private boolean case2(long num) {
        if(num % 10 != 1) return false;
        return case1(num - 1);
    }

    // case when num equals to 99 999 9999 99999
    // simply + 2
    private boolean case3(long num) {
        while(num > 0) {
            if(num % 10 != 9) return false;
            num /= 10;
        }
        return true;
    }
}