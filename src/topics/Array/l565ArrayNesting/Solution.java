package topics.Array.l565ArrayNesting;

public class Solution {
    // simple dfs
    // time O(n) 36.71% space O(n) 91.69%
    public int arrayNesting(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        boolean[] visited = new boolean[len];
        int res = 0;
        for(int i = 0; i < len; ++i) {
            if(!visited[i]) res = Math.max(res, check(nums, visited, i));
        }
        return res;
    }

    private int check(int[] nums, boolean[] visited, int index) {
        int res = 0;
        while(!visited[index]) {
            res++;
            visited[index] = true;
            index = nums[index];
        }
        return res;
    }

    // if we can modify the original array
    // the space will be O(1)
    // time beats 64.45% space beats 23.72%
    public int arrayNesting1(int[] a) {
        int maxsize = 0;
        for (int i = 0; i < a.length; i++) {
            int size = 0;
            for (int k = i; a[k] >= 0; size++) {
                int ak = a[k];
                a[k] = -1; // mark a[k] as visited;
                k = ak;
            }
            maxsize = Integer.max(maxsize, size);
        }

        return maxsize;
    }
}
