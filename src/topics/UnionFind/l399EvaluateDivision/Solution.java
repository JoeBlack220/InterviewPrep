package topics.UnionFind.l399EvaluateDivision;
import java.util.*;
public class Solution {
    Map<String, String> root = new HashMap<>();
    Map<String, Double> map = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if(equations == null || equations.size() == 0) return new double[]{};

        for(int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            String x1 = equation.get(0);
            String x2 = equation.get(1);
            root.putIfAbsent(x1, x1);
            root.putIfAbsent(x2, x2);
            map.putIfAbsent(x1, 1.0);
            map.putIfAbsent(x2, 1.0);
            String r1 = find(x1);
            String r2 = find(x2);
            root.put(r2, r1);
            map.put(r2, map.get(x1) * values[i] / map.get(x2));

        }

        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); ++i){
            res[i] = -1.0;
            String x1 = queries.get(i).get(0);
            String x2 = queries.get(i).get(1);
            if(!root.containsKey(x1) || !root.containsKey(x2)) continue;
            String r1 = find(x1);
            String r2 = find(x2);
            if(r1.equals(r2)){
                res[i] = get(x2) / get(x1);
            }
        }
        return res;
    }

    public String find(String var){
        if(root.get(var).equals(var)) return var;
        return find(root.get(var));
    }

    private double get(String var){
        String r = root.get(var);
        double result = map.get(var);

        if(r.equals(var)) return result;
        return result*get(r);
    }
}
