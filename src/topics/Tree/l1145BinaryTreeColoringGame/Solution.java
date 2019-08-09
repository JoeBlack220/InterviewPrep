package topics.Tree.l1145BinaryTreeColoringGame;
import datastructure.TreeNode;
import java.util.Map;
import java.util.HashMap;
public class Solution {
    TreeNode xNode = new TreeNode(0);
    Map<TreeNode, TreeNode> map = new HashMap<>();
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        iterate(null, root, x);
        TreeNode xParent = new TreeNode(0);
        xParent = map.get(xNode);
        if(xParent == null) {
            return countChildren(xNode.left) != countChildren(xNode.right);
        }
        else {
            int countX = countChildren(xNode);
            int countChild = Math.max(countChildren(xNode.left), countChildren(xNode.right));
            // System.out.println(countX + 1);
            return (countX <= n / 2) || countChild > n / 2;
        }
    }


    public int countChildren(TreeNode root) {
        if(root == null) return 0;
        else return 1 + countChildren(root.left) + countChildren(root.right);
    }

    public void iterate(TreeNode parent, TreeNode cur, int x) {
        if(cur != null) {
            map.put(cur, parent);
            if(cur.val == x) {
                xNode = cur;
            }
            iterate(cur, cur.left, x);
            iterate(cur, cur.right, x);
        }
    }
}