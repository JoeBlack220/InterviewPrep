package topics.UnionFind.l547FriendCircles;

public class Solution {
    int[] uf;
    int n, count;
    // typical union find problems
    // be careful, all nodes belong to 1 group doesn't necessarily have the same
    // uf[i] value, but their find(i) should be the same
    // if a node belongs to some group, the total number of groups should minus 1
    // space O(n) time O(nlogn)
    public int findCircleNum(int[][] M) {
        n = M.length;
        count = n;
        uf = new int[n];

        for(int i = 0; i < n; ++i){
            uf[i] = i;
        }

        for(int i = 0; i < n; ++i){
            for(int j = i; j < n; ++j){
                if(M[i][j] == 1 && i != j){
                    union(i, j);
                }
            }
        }
        return count;
    }

    public int find(int x){
        if(x != uf[x]){
            uf[x] = find(uf[x]);
        }
        return uf[x];
//         while(x != uf[x]){

//             x = uf[x];
//         }
//         return x;
    }

    public void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return;
        count --;
        uf[x] = y;
    }
}
