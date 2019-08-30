package topics.DynammicProgramming.l471EncodeStringwithShortestLength;
// dp[i][j] shortest encoded string from index i to index j
public class Solution {
    public String encode(String s) {
        int len = s.length();
        String[][] dp = new String[len][len];

        for(int l = 0; l < len; ++l) {
            for(int i = 0; i < len - l; ++i) {
                int j = i + l;
                String sub = s.substring(i, j + 1);
                dp[i][j] = sub;
                for(int k = i; k < j; ++k) {
                    if((dp[i][k].length() + dp[k + 1][j].length()) < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k + 1][j];
                    }
                }

                for(int m = 0; m < sub.length(); ++m) {
                    if(sub.length() % (m + 1) != 0) continue;
                    String pattern = sub.substring(0, m + 1);
                    if(sub.replaceAll(pattern, "").length() == 0) {
                        String candidate = (sub.length() / pattern.length()) + "[" + dp[i][i + m] + ']';
                        // System.out.println(candidate);
                        if(candidate.length() < dp[i][j].length()) {
                            dp[i][j] = candidate;
                        }
                    }
                }
            }
        }
        return dp[0][len - 1];
    }
}