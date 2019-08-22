package topics.DepthFirstSearch.l399EvaluateDivision;
import java.util.*;
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> edges = new HashMap<>();
        Map<String, List<Double>> dis = new HashMap<>();
        int n = equations.size();
        for(int i=0;i<n;i++){
            String f = equations.get(i).get(0), s = equations.get(i).get(1);
            edges.putIfAbsent(f, new ArrayList<>());
            dis.putIfAbsent(f, new ArrayList<>());
            edges.get(f).add(s);
            dis.get(f).add(values[i]);

            edges.putIfAbsent(s, new ArrayList<>());
            dis.putIfAbsent(s, new ArrayList<>());
            edges.get(s).add(f);
            dis.get(s).add(1/values[i]);
        }
        double[] res = new double[queries.size()];
        int id = 0;
        for(List<String> q : queries){
            String f = q.get(0), s = q.get(1);
            double v = dfs(f, s, edges, dis, new HashSet<>(), 1);
            res[id++] = v==0 ? -1 : v;
        }
        return res;
    }

    private double dfs(String start, String end, Map<String, List<String>> edges, Map<String, List<Double>> dis, HashSet<String> set, double value){
        if(set.contains(start)) return 0;
        if(!edges.containsKey(start)) return 0;
        if(start.equals(end)) return value;

        set.add(start);
        List<String> e = edges.get(start);
        List<Double> d = dis.get(start);
        int n = e.size();
        double tmp = 0;
        for(int i=0;i<n;i++){
            tmp = dfs(e.get(i), end, edges, dis, set, value*d.get(i));
            if(tmp!=0){
                break;
            }
        }
        set.remove(start);
        return tmp;
    }
}