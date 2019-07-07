package cc189.chapter1;
import java.util.Arrays;
public class URLify {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String test = "Mr John Smith    ";
        char[] testarr = test.toCharArray();
        sol.urlify(testarr, 13);
        System.out.println(Arrays.toString(testarr));

    }

    static class Solution {
        // space O(1) time O(n)
        final char[] toInsert = new char[]{'%', '2', '0'};
        public void urlify(char[] testarr, int len) {
            int spaceCount = 0, index = 0, i;
            for(i = 0; i < len; ++i) {
                if(testarr[i] == ' ') {
                    spaceCount++;
                }
            }
            index = len + spaceCount * 2;
            for(i = len - 1; i >= 0; --i) {
                if(testarr[i] == ' ') {
                    testarr[index - 1] = '0';
                    testarr[index - 2] = '2';
                    testarr[index - 3] = '%';
                    index -= 3;
                } else {
                    testarr[index - 1] = testarr[i];
                    index--;
                }
            }

        }
    }
}
