package others.tr.wf;

public class Solution {
    public int solve(int[] v) {
        int[] prefix = new int[v.length + 1];

        for(int i = 0; i < v.length; ++i) {
            if(v[i] == 1) {
                prefix[i + 1] = prefix[i] + 1;
            }
            else {
                prefix[i + 1] = prefix[i] - 1;
            }
        }

        int sum = prefix[v.length];
        for(int i = 0; i <= v.length; ++i) {
            System.out.println("the number " + i + " line has sum " + prefix[i]);
            if(prefix[i] > sum - prefix[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] empty = new int[]{};
        int[] normal = new int[]{1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1};
        int[] longt = new int[]{1, 1, 0, 1, 0, 0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,0,1,1,0,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1};
        int[] case0 = new int[]{1, 0, 0, 1, 0};
        Solution sol = new Solution();
        System.out.println(sol.solve(empty));
        System.out.println(sol.solve(normal));
        System.out.println(sol.solve(longt));
        System.out.println(sol.solve(case0));
    }
}
