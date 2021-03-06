package topics.Trie.l421MaximumXORofTwoNumbersInanArray;

public class Solution2 {
    // same idea as the first solution
    // but we don't need to convert each number to a string
    // we just need to use binary operation to extract each bit of the number
    public int findMaximumXOR(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        TrieNode root = new TrieNode();

        for (int i : nums) {
            TrieNode node = root;
            for (int j = 31; j >= 0; j--) {
                int bit = (i >> j) & 1;
                if (bit == 1) {
                    if (node.one == null) {// one的位置是null，就新建
                        node.one = new TrieNode();
                    }
                    node = node.one;
                } else {
                    if (node.zero == null) {
                        node.zero = new TrieNode();
                    }
                    node = node.zero;
                }
            }
        }

        int max = Integer.MIN_VALUE;

        //找每一个数字和别的数字异或出来的最大值！
        //所有最大值，取其中最大的
        for (int i : nums) {
            TrieNode node = root;
            int XOR = 0;// 异或结果,的累加。按位累加也是牛逼
            for (int j = 31; j >= 0; j--) {
                int bit = (i >> j) & 1;
                //如果这一位是1，为了异或最大，最好使用0，这样异或出来是1
                //如果0不存在就只能使用1，这样这一位异或出来就是0
                //如果这一位是0，为了异或最大，最好使用1，这样异或出来是1
                //如果1不存在就只能使用0，这样这一位异或出来就是0
                if (bit == 1) {
                    if (node.zero != null) {
                        node = node.zero;
                        XOR += 1 << j;
                    } else {
                        node = node.one;
                        XOR += 0 << j;// 0没用为了明确还是写上
                    }
                } else {
                    if (node.one != null) {
                        node = node.one;
                        XOR += 1 << j;
                    } else {
                        node = node.zero;
                        XOR += 0 << j;
                    }
                }
            }
            max = max > XOR ? max : XOR;
        }

        return max;
    }
}

class TrieNode {
    TrieNode zero;
    TrieNode one;
}