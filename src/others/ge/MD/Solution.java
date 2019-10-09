package others.ge.MD;

public class Solution {
    public int minDominoRotations(int[] A, int[] B) {

        for (int i = 1; i <= 6; ++i) {
            int res = helper(A, B, i);
            if (res != -1) return res;
        }
        return -1;
    }

    private int helper(int[] A, int[] B, int can) {
        int countA = 0;
        int countB = 0;
        for (int i = 0; i<A.length; ++i) {
            if (can != A[i] && can != B[i]) return -1;
            if (can != A[i]) countA++;
            if (can != B[i]) countB++;
        }
        return Math.min(countA, countB);
    }
}

class Solution2 {
    public int minDominoRotations(int[] A, int[] B) {
        int len = A.length;
        int a = 0, b = 0;

        for(int i = 0; i < len; ++i) {
            if(A[i] != A[0] && B[i] != A[0]) break;

            if(A[i] != A[0]) b++;
            if(B[i] != A[0]) a++;
            if(i == len - 1) return Math.min(a, b);
        }

        a = 0;
        b = 0;

        for(int i = 0; i < len; ++i) {
            if(B[i] != B[0] && A[i] != B[0]) break;

            if(A[i] != B[0]) a++;
            if(B[i] != B[0]) b++;

            if(i == len - 1) return Math.min(a, b);
        }

        return -1;
    }
}
