package others.tr.ap;

public class Solution {
    public int solve(int init, int[] ut) {
        long start = init;
        int curIndex = 0;
        long limit = (long) 200000000;
        while(curIndex < ut.length) {
            if(ut[curIndex] < 25 && start > 1) {
                start /= 2;
                curIndex += 10;
            }
            else if(ut[curIndex] > 65 && 2 * start <= limit) {
                start *= 2;
                curIndex += 10;
            }
            else curIndex++;
        }
        return (int) start;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solve(1, new int[]{3, 5, 10, 90}));
    }
}
