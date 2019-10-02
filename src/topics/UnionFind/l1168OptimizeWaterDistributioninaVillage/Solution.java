package topics.UnionFind.l1168OptimizeWaterDistributioninaVillage;
import java.util.*;
// notice that all the indexes of pipes are 1-indexed
// suppose that all the villages can't build wells, and there is a well in a virtual village which has index 0
// wells[i - 1] can be regarded as the cost of build a pipe from i-th village to village 0
public class Solution {
    int[] uf;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int w_num = wells.length;
        uf = new int[w_num + 1];
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i <= w_num; ++i) {
            uf[i] = i;
            if(i != 0) {
                edges.add(new int[]{i, 0, wells[i - 1]});
            }
        }

        for(int[] edge: pipes) {
            edges.add(edge);
        }

        Collections.sort(edges, (a, b) -> (a[2] - b[2]));
        int res = 0;

        for(int[] edge: edges) {
            if(union(edge[0], edge[1])){
                res += edge[2];
            }
        }
        return res;
    }

    private int find(int x){
        if(uf[x] != x) {
            uf[x] = find(uf[x]);
        }
        return uf[x];
    }

    private boolean union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);
        if(x_parent == y_parent) return false;
        else {
            uf[x_parent] = y_parent;
            return true;
        }
    }
}
