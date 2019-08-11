package topics.String.l1154DayoftheYear;

public class Solution {
    public int dayOfYear(String date) {
        String[] strs = date.split("-");
        int[] days = new int[]{31, 28, 31, 30, 31, 30 ,31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(strs[0]);
        boolean leap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        int month = Integer.parseInt(strs[1]);
        int res = Integer.parseInt(strs[2]);
        for(int i = 0; i < month - 1; ++i) {
            res += days[i];
        }
        if(leap && month > 2) res++;
        return res;
    }
}
