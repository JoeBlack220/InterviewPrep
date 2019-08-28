package topics.Backtrack.l401BinaryWatch;
import java.util.*;
// solution1 backtrack
public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new LinkedList<>();
        backtrack(0, 0, 0, num, res);
        return res;
    }

    private void backtrack(int digits, int hour, int minutes, int left, List<String> res) {
        if(hour >= 12 || minutes >= 60) return;
        if(digits == 10 && left == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(hour);
            sb.append(":");
            sb.append(minutes);
            if(minutes < 10) sb.insert(sb.length() - 1, 0);
            res.add(sb.toString());
        }
        if(digits < 4) {
            backtrack(digits + 1, (hour << 1) + 1, minutes, left - 1, res);
            backtrack(digits + 1, hour << 1, minutes, left, res);
        }
        else if(digits < 10){
            backtrack(digits + 1, hour, (minutes << 1) + 1, left - 1, res);
            backtrack(digits + 1, hour, minutes << 1, left, res);
        }
    }
}

// solution 2 hash table
class Solution2 {
    String[][] hour = {{"0"},
            {"1", "2", "4", "8"},
            {"3", "5", "6", "9", "10"},
            {"7", "11"}};
    String[][] minute = {{"00"},
            {"01", "02", "04", "08", "16", "32"},
            {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"},
            {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"},
            {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"},
            {"31", "47", "55", "59"}};

    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList();
        for (int i = 0; i <= 3 && i <= num; i++) {
            if (num - i <= 5) {
                for (String str1 : hour[i]) {
                    for (String str2 : minute[num - i]) {
                        ret.add(str1 + ":" + str2);
                    }
                }
            }
        }
        return ret;
    }
}