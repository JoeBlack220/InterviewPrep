package topics.Test;
import java.util.*;
public class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new LinkedList<>();
        Map<String, Pair> map = new HashMap<>();
        for(String t: transactions) {
            String[] tarr = t.split(",");
            if(Integer.parseInt(tarr[2]) > 1000) res.add(t);
            else {
                Pair cur = new Pair(Integer.parseInt(tarr[1]), tarr[3]);
                if(map.containsKey(tarr[0])) {
                    Pair last = map.get(tarr[0]);
                    if(last.city.equals(cur.city)) map.put(tarr[0], cur);
                    else if(last.time + 60 < cur.time) map.put(tarr[0], cur);
                    else {
                        res.add(tarr[0]);
                    }
                }
            }
        }
        return res;
    }

    class Pair{
        int time;
        String city;
        public Pair(int t, String c) {
            city = c;
            time = t;
        }
    }
}

class test {
    public static void main(String[] args) {
        DinnerPlates dp = new DinnerPlates(2);
        dp.push(1);
        dp.push(2);
        dp.push(3);
        dp.push(4);
        dp.push(5);
        dp.push(6);
        dp.push(7);
        dp.push(8);
        dp.popAtStack(3);
        dp.popAtStack(3);
        dp.popAtStack(1);
        dp.popAtStack(3);
        dp.popAtStack(0);

        dp.popAtStack(2);
        dp.popAtStack(2);
        dp.popAtStack(1);
        dp.popAtStack(1);
        dp.popAtStack(3);




        dp.pop();
        dp.pop();
        dp.pop();
        System.out.println(dp.pop());
        dp.push(3);
        System.out.println(dp.pop());
        System.out.println(dp.popAtStack(3));
    }
}

class DinnerPlates {
    TreeMap<Integer, Stack<Integer>> map;
    int cap;
    Integer leftmost;
    Integer rightmost;
    public DinnerPlates(int capacity) {
        cap = capacity;
        map = new TreeMap<>();
        leftmost = 0;
        rightmost = 0;
    }

    public void push(int val) {
        if(!map.containsKey(leftmost)) {
            map.put(leftmost, new Stack<>());
        }
        map.get(leftmost).push(val);
        while(map.get(leftmost).size() == cap) {
            Integer next = map.higherKey(leftmost);
            if(next == null) {
                leftmost++;
                rightmost = leftmost;
                map.put(leftmost, new Stack<>());

            }
            else leftmost = next;
        }
    }

    public int pop() {
        if(!map.containsKey(rightmost) || map.get(rightmost).empty()) {
            map.remove(rightmost);
            Integer next = map.lowerKey(rightmost);
            if(next == null) return -1;
            if(leftmost.compareTo(rightmost) == 0) {
                leftmost = next;
            }
            rightmost = next;
            return pop();
        }
        else return map.get(rightmost).pop();
    }

    public int popAtStack(int index) {
        if(!map.containsKey(index)) return -1;
        else {

            if(index == rightmost) return pop();
            if(map.get(index).empty()) return -1;
            int res = map.get(index).pop();
            if(index < leftmost) leftmost = index;
            return res;
        }
    }
}
