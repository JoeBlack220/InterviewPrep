package topics.String.l736ParseLispExpression;
import java.util.*;
public class Solution {
    // (add e1 e2)
    Deque<Map<String, Integer>> stack;
    public int evaluate(String expression) {
        stack = new ArrayDeque<>();
        return eval(expression, new int[]{0});
    }

    private int eval(String expression, int[] pos) {
        while(expression.charAt(pos[0]) == '(' || expression.charAt(pos[0]) == ' ') pos[0]++;
        // System.out.println(pos[0]);
        Map<String, Integer> symboltable = new HashMap<>();
        stack.push(symboltable);
        String token = getToken(expression, pos);
        // System.out.println(token);

        int res = 0;
        if(token.equals("mult")) {
            int oppr1 = eval(expression, pos);
            int oppr2 = eval(expression, pos);
            res = oppr1 * oppr2;
        }
        else if(token.equals("add")) {
            int oppr1 = eval(expression, pos);
            int oppr2 = eval(expression, pos);
            res = oppr1 + oppr2;
        }
        else if(token.equals("let")) {
            pos[0]++;
            while(expression.charAt(pos[0]) != ')') {
                if(expression.charAt(pos[0]) == '(') {
                    res = eval(expression, pos);
                    break;
                }
                String symbol = getToken(expression, pos);
                if(expression.charAt(pos[0]) != ')') {
                    int val = eval(expression, pos);
                    symboltable.put(symbol, val);
                }
                else {
                    if(Character.isLetter(symbol.charAt(0))) res = findValue(symbol);
                    else res = Integer.parseInt(symbol);
                }
            }
        }
        else if(Character.isLetter(token.charAt(0))) {
            res = findValue(token);
        }
        else {
            res = Integer.parseInt(token);
        }
        pos[0]++;
        stack.pop();
        return res;
    }

    private String getToken(String expression, int[] pos) {
        if(expression.charAt(pos[0]) == ' ') pos[0]++;
        StringBuilder sb = new StringBuilder();
        while(expression.charAt(pos[0]) != ')' && expression.charAt(pos[0]) != ' ') {
            sb.append(expression.charAt(pos[0]++));
        }
        return sb.toString();
    }

    private int findValue(String x) {
        for(Map<String, Integer> map: stack) {
            if(map.containsKey(x)) return map.get(x);
        }
        return 0;
    }
}
