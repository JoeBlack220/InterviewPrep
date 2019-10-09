package others.ge.WF;

public class Solution {
    public int compute(int[] flowers, int capacity){
        int curCap = capacity;
        int step = 0;
        for(int i = 0; i < flowers.length; ++i) {
            step++;
            if(curCap < flowers[i]) {
                step += i * 2;
                curCap = capacity - flowers[i];
            }
            else {
                curCap -= flowers[i];
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] test1 = new int[]{2, 4, 5, 1, 2};
        System.out.println(sol.compute(test1, 6));
    }

}
