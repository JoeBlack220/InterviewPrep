package topics.Tree.l536ConstructBinaryTreefromString;
import datastructure.TreeNode;
public class Solution {
    public TreeNode str2tree(String s) {
        if(s == null || s.length() == 0) return null;
        return parseHelper(s, new int[]{0});
    }

    private TreeNode parseHelper(String s, int[] index) {
        int start = index[0];
        int minus = 1;
        if(s.charAt(index[0]) == '-') {
            start++;
        }
        while(start < s.length() && Character.isDigit(s.charAt(start))) {
            start++;
        }
        int val = Integer.parseInt(s.substring(index[0], start));
        index[0] = start;
        TreeNode res = new TreeNode(val);
        if(start == s.length()) {
            return res;
        }
        if(s.charAt(start) == ')') {
            index[0]++;
            return res;
        }
        if(s.charAt(index[0]) == '(') {
            index[0]++;
            res.left = parseHelper(s, index);
        }
        if(index[0] < s.length() && s.charAt(index[0]) == '(') {
            index[0]++;
            res.right = parseHelper(s, index);
        }
        index[0]++;
        return res;
    }
}