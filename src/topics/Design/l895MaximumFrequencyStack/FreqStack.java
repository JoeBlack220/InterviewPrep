package topics.Design.l895MaximumFrequencyStack;
import java.util.*;
public class FreqStack {
    Map<Integer, Integer> map;
    List<Deque<Integer>> list;
    public FreqStack() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
        int freq = map.get(x);
        while(list.size() < freq) list.add(new LinkedList<>());
        list.get(freq - 1).push(x);
    }

    public int pop() {
        Deque<Integer> stack = list.get(list.size() - 1);
        int toPop = stack.pop();
        int freq = map.get(toPop);
        if(freq == 1) map.remove(toPop);
        else map.put(toPop, freq - 1);
        if(stack.isEmpty()) list.remove(list.size() - 1);
        // System.out.println(toPop + "," + freq);
        return toPop;
    }
}
