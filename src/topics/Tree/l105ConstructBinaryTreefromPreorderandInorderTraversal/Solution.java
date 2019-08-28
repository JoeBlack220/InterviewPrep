package topics.Tree.l105ConstructBinaryTreefromPreorderandInorderTraversal;
import java.util.*;
import datastructure.TreeNode;
// preorder root left right inorder left root right
// use the first number of preorder as the root's val
// then find the index of this val in inorder, the leftside of this number is the left child
// the right side of the number is the right child
// recursively build the tree like that
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int len = inorder.length;
        for(int i = 0; i < len; ++i) indexMap.put(inorder[i], i);
        return buildTree(preorder, 0, len - 1, inorder, 0, len - 1, indexMap);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode res = new TreeNode(preorder[preStart]);
        int index = inMap.get(preorder[preStart]);
        int len = index - inStart;
        res.left = buildTree(preorder, preStart + 1, preStart + len, inorder, inStart, index - 1, inMap);
        res.right = buildTree(preorder, preStart + len + 1, preEnd, inorder, index + 1, inEnd, inMap);
        return res;
    }
}
