package topics.Stack.l1209RemoveAllAdjacentDuplicatesinStringII;
import java.util.*;
public class Solution {

    public String removeDuplicates(String s, int k) {
        List<Pair> list = new ArrayList<>();
        for(char c: s.toCharArray()) {
            if(list.size() != 0 && list.get(list.size() - 1).c == c) {
                Pair last = list.get(list.size() - 1);
                last.count = (last.count + 1) % k;
                if(last.count == 0) {
                    list.remove(list.size() - 1);
                }
            }
            else {
                list.add(new Pair(c));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Pair p: list) {
            for(int i = 0; i < p.count;++i) {
                sb.append(p.c);
            }
        }
        return sb.toString();

    }
    class Pair {
        int count;
        char c;
        public Pair(char c) {
            this.c = c;
            count = 1;
        }
    }
}
