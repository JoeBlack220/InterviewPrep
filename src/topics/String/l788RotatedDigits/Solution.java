package topics.String.l788RotatedDigits;

public class Solution {
    /// <summary>
    /// convert integer to string
    /// go over each string to determine if it is a good number
    /// 0, 1, 8 -> rotate to itself
    /// 2<->5
    /// 6<->9
    /// 3, 4, 7, 8 does not apply rotation

    public int rotatedDigits(int N)
    {
        // dp[i] = 0, invalid number
        // dp[i] = 1, valid and same number
        // dp[i] = 2, valid and different number
        int[] dp = new int[N + 1];

        int count = 0;
        for (int i = 0; i <= N; i++)
        {
            if (i < 10)
            {
                if (i == 0 || i == 1 || i == 8)
                {
                    dp[i] = 1;
                }
                else if (i == 2 || i == 5 || i == 6 || i == 9)
                {
                    dp[i] = 2;
                    count++;
                }
            }
            else
            {
                int a = dp[i / 10];
                int b = dp[i % 10];

                if (a == 1 && b == 1)
                {
                    dp[i] = 1;
                }
                else if (a >= 1 && b >= 1)
                {
                    dp[i] = 2;
                    count++;
                }
            }
        }

        return count;
    }
}

class Solution2 {
    // brute force
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i ++) {
            if (isValid(i)) count ++;
        }
        return count;
    }

    public boolean isValid(int N) {
        /*
         Valid if N contains ATLEAST ONE 2, 5, 6, 9
         AND NO 3, 4 or 7s
         */
        boolean validFound = false;
        while (N > 0) {
            if (N % 10 == 2) validFound = true;
            if (N % 10 == 5) validFound = true;
            if (N % 10 == 6) validFound = true;
            if (N % 10 == 9) validFound = true;
            if (N % 10 == 3) return false;
            if (N % 10 == 4) return false;
            if (N % 10 == 7) return false;
            N = N / 10;
        }
        return validFound;
    }
}