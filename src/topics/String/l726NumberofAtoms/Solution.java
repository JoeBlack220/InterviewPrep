package topics.String.l726NumberofAtoms;
import java.util.*;
public class Solution {
    Deque<Map<String, Integer>> stack;
    public String countOfAtoms(String formula) {
        stack = new ArrayDeque<>();
        eval(formula, new int[]{0});
        Map<String, Integer> map = stack.pop();
        StringBuilder res = new StringBuilder();
        for(Map.Entry<String, Integer> e: map.entrySet()) {
            res.append(e.getKey());
            if(e.getValue() != 1) res.append(e.getValue());
        }
        return res.toString();
    }

    public void eval(String formula, int[] pos) {
        Map<String, Integer> map = new TreeMap<>();
        stack.push(map);
        while(pos[0] != formula.length() && formula.charAt(pos[0]) != ')') {
            if(formula.charAt(pos[0]) == '(') {
                pos[0]++;
                eval(formula, pos);
                int num = 1;
                if(pos[0] < formula.length() && isDigit(formula.charAt(pos[0]))) {
                    num = formula.charAt(pos[0]++) - '0';
                    while(pos[0] < formula.length() && isDigit(formula.charAt(pos[0]))) {
                        num *= 10;
                        num += formula.charAt(pos[0]++) - '0';
                    }
                }
                Map<String, Integer> last = stack.pop();
                for(Map.Entry<String, Integer> entry: last.entrySet()) {
                    int elem_num = map.getOrDefault(entry.getKey(), 0) + entry.getValue() * num;
                    map.put(entry.getKey(), elem_num);
                }
            }
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(formula.charAt(pos[0]++));
                while(pos[0] < formula.length() && isLowerCase(formula.charAt(pos[0]))) {
                    sb.append(formula.charAt(pos[0]++));
                }
                int num = 1;
                if(pos[0] < formula.length() && isDigit(formula.charAt(pos[0]))) {
                    num = formula.charAt(pos[0]++) - '0';
                    while(pos[0] < formula.length() && isDigit(formula.charAt(pos[0]))) {
                        num *= 10;
                        num += formula.charAt(pos[0]++) - '0';
                    }
                }
                String elem = sb.toString();
                map.put(elem, map.getOrDefault(elem, 0) + num);
            }
        }
        if(pos[0] < formula.length() && formula.charAt(pos[0]) == ')') pos[0]++;
    }

    private boolean isLowerCase(char c) {
        return c <= 'z' && c >= 'a';
    }

    private boolean isDigit(char c) {
        return c <= '9' && c >= '0';
    }
}