package topics.DynammicProgramming.l1125SmallestSufficientTeam;
import java.util.*;
public class Solution {
    // to be continued...
    Set<Integer> skip;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        List<Integer> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String s: req_skills) set.add(s);
        skip = new HashSet<>();
        for (int i = 0; i < people.size();i++){
            if (skip.contains(i)) continue;
            for (int j = 0;j < people.size();j++){
                if (skip.contains(j)) continue;
                if (j == i) continue;
                Set<String> test = new HashSet<>();
                List<String> skillI = people.get(i);
                List<String> skillJ = people.get(j);
                for (String s: skillI) test.add(s);
                for (String s: skillJ) if (test.contains(s)) test.remove(s);

                if (i == 12 && test.size() == 0) System.out.println(j);
                if (test.size() == 0) skip.add(i);
            }
        }
        rec(people, 0, new ArrayList<>(),set,  new HashMap<>(), list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length;i++) ans[i] = list.get(i);
        return ans;

    }

    public void rec(List<List<String>> people, int index, List<Integer> workers,Set<String> need, Map<String, Integer> have, List<Integer> ans){
        if (have.size() == need.size()){
            if (workers.size() < ans.size() || ans.size() == 0){
                ans.clear();
                ans.addAll(workers);
            }
        }else if (index == people.size()){
            return;
        }
        else{
            List<String> skills = people.get(index);
            if (skills.size() == 0 || skip.contains(index)) {
                rec(people, index+1, workers, need, have, ans);
                return;
            }
            boolean goInto = false;
            for (int i = 0; i < skills.size();i++){
                String skill = skills.get(i);
                if (need.contains(skill)){
                    if (have.getOrDefault(skill, 0) == 0) goInto = true;
                    have.put(skill, have.getOrDefault(skill, 0) + 1);
                }
            }
            workers.add(index);
            if (goInto) rec(people, index+1, workers, need, have, ans);
            workers.remove(workers.size()-1);
            for (int i = 0; i < skills.size();i++){
                String skill = skills.get(i);
                if (need.contains(skill)){
                    have.put(skill, have.get(skill)-1);
                    if (have.get(skill) == 0) have.remove(skill);
                }
            }
            rec(people, index+1, workers, need, have, ans);
        }
    }
}

