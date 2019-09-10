package topics.UnionFind.l721AccountsMerge;
import java.util.*;
public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> uf = new HashMap<>();
        Map<String, String> o = new HashMap<>();
        Map<String, TreeSet<String>> map = new HashMap<>();
        for(int i = 0; i < accounts.size(); ++i) {
            String sig = accounts.get(i).get(0) + "," + i;
            map.put(sig, new TreeSet<>());
            o.put(sig, accounts.get(i).get(0));
            uf.put(sig, sig);
            for(int j = 1; j < accounts.get(i).size(); ++j) {
                uf.put(accounts.get(i).get(j), sig);
            }
        }

        for(int i = 0; i < accounts.size(); ++i) {
            for(int j = 1; j < accounts.get(i).size(); ++j) {
                for(int k = j + 1; k < accounts.get(i).size(); ++k) {
                    union(accounts.get(i).get(j), accounts.get(i).get(k), uf);
                }
            }
        }
        for(Map.Entry<String, String> entry: uf.entrySet()) {
            if(!map.containsKey(entry.getKey())) {
                map.get(find(entry.getValue(), uf)).add(entry.getKey());
            }
        }
        List<List<String>> res = new ArrayList<>();

        for(Map.Entry<String, TreeSet<String>> entry: map.entrySet()) {
            if(entry.getValue().size() > 0) {
                List<String> toAdd = new ArrayList<>();
                toAdd.add(o.get(entry.getKey()));
                toAdd.addAll(entry.getValue());
                res.add(toAdd);
            }
        }
        return res;
    }

    private String find(String s1, Map<String, String> uf) {
        String parent = uf.get(s1);
        if(!parent.equals(s1)) {
            uf.put(s1, find(parent, uf));
        }
        return uf.get(s1);
    }

    private void union(String s1, String s2, Map<String, String> uf) {
        String parent1 = find(s1, uf);
        String parent2 = find(s2, uf);
        if(!parent1.equals(parent2)) {
            uf.put(parent1, parent2);
        }
    }
}


class Solution2 {
    public List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), p);
        }
        for(List<String> a : acts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }
    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}
