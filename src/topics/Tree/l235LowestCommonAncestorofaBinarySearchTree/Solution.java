package topics.Tree.l235LowestCommonAncestorofaBinarySearchTree;
import datastructure.TreeNode;
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if p and q both exist in a bst
        // their lowest ancestor should be the node that has value between these two nodes
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else return root;
    }
}
