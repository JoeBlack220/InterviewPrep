package topics.Math.l1118NumberOfDaysInAMonth;

public class Solution {
    // remember the condition of leap year
    // can be divide by 4 but can't divide by 100, or can be divided by 400
    // time O(1) beats 100% space O(1) beats 50%
    public int numberOfDays(int Y, int M) {
        switch(M) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if((Y % 4 == 0) && (Y % 100 != 0) || (Y % 400 == 0)) return 29;
                else return 28;
        }
        return -1;
    }
}
