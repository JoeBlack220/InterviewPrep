package topics.String.l434NumberOfSegmentsInAString;

public class Solution {
    // method using trim and split
    public int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.length() == 0) return 0;
        else return trimmed.split("\\s+").length;
    }

    // method using a pointer
    public int countSegments1(String s) {
        int res=0;
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
                res++;
        return res;
    }
}
