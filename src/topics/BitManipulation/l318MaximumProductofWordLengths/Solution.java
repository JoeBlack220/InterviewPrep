package topics.BitManipulation.l318MaximumProductofWordLengths;

public class Solution {
    // since the words only contains lower bit characters
    // we can use a 26-bit integer to represent what letters appear in a word
    // val |= 1<<(c - 'a')
    // then if val1 && val2 == 0, it means that there is not a single character that the two words share
    // we can update the maximum length then

    public static int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];
        for(int i = 0; i < words.length; ++i) {
            String word = words[i];
            for(char c: word.toCharArray()) {
                value[i] |= 1 << (c - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
                    maxProduct = words[i].length() * words[j].length();
            }
        return maxProduct;
    }
}