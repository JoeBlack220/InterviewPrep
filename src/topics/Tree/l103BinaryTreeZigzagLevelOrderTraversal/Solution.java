package topics.Tree.l103BinaryTreeZigzagLevelOrderTraversal;
import datastructure.TreeNode;
import java.util.*;
// recursive solution
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res, int level) {
        if(root == null) return;
        while(level >= res.size()) res.add(new LinkedList<>());
        if(level % 2 == 0) res.get(level).add(root.val);
        else res.get(level).add(0, root.val);
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}

// iterative solution
class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;

        while(!queue.isEmpty()){
            int size  = queue.size();

            LinkedList<Integer> tempList = new LinkedList<>();
            for(int i = 0; i < size; i ++){
                TreeNode curNode = queue.poll();
                if(reverse){
                    tempList.addFirst(curNode.val);
                }
                else{
                    tempList.add(curNode.val);
                }

                if(curNode.left != null){
                    queue.offer(curNode.left);
                }
                if(curNode.right != null){
                    queue.offer(curNode.right);
                }
            }
            result.add(tempList);
            reverse = !reverse;
        }
        return result;
    }
}