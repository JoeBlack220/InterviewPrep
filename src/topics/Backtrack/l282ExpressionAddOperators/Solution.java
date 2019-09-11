package topics.Backtrack.l282ExpressionAddOperators;
import java.util.*;
public class Solution {
    // backtracking
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);

                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}


class Solution2 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        helper(res, new StringBuilder(), 0, num, 0, target, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, long sofar, String num, int curIndex, long target, long mul) {
        if(curIndex == num.length() && target == sofar) {
            res.add(sb.toString());
        }
        for(int i = curIndex + 1; i <= num.length(); ++i) {
            long next = Long.parseLong(num.substring(curIndex, i));
            int count = countDigit(next);
            if(count != i - curIndex) continue;
            if(curIndex == 0) {
                sb.append(next);
                helper(res, sb, sofar + next, num, i, target, next);
                for(int j = 0; j < count; ++j) sb.deleteCharAt(sb.length() - 1);
            }
            else {
                sb.append('+');
                sb.append(next);
                helper(res, sb, sofar + next, num, i , target, next);
                for(int j = 0; j < count + 1; ++j) sb.deleteCharAt(sb.length() - 1);
                sb.append('-');
                sb.append(next);
                helper(res, sb, sofar - next, num, i , target, -next);
                for(int j = 0; j < count + 1; ++j) sb.deleteCharAt(sb.length() - 1);
                sb.append('*');
                sb.append(next);
                helper(res, sb, sofar + mul * (next - 1), num, i , target, mul * next);
                for(int j = 0; j < count + 1; ++j) sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private int countDigit(long num) {
        if(num == 0) return 1;
        int res = 0;
        while(num != 0) {
            res ++;
            num /= 10;
        }
        return res;
    }
}