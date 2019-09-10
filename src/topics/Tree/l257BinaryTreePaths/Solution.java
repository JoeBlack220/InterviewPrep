package topics.Tree.l257BinaryTreePaths;
import java.util.*;
import datastructure.TreeNode;
public class Solution {
    List<String> res = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        dfs("", root);
        return res;
    }

    public void dfs(String curPath, TreeNode curNode){
        if(!curPath.equals("")) curPath += "->" + curNode.val;
        else curPath += curNode.val;
        if(curNode.left == null && curNode.right == null){
            res.add(curPath);
            return;
        }
        if(curNode.left != null){
            dfs(curPath, curNode.left);
        }
        if(curNode.right != null){
            dfs(curPath, curNode.right);
        }
    }
}