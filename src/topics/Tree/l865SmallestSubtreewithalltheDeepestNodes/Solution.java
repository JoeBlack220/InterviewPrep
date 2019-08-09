package topics.Tree.l865SmallestSubtreewithalltheDeepestNodes;
        import java.util.*;
        import datastructure.TreeNode;
public class Solution {
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    Map<TreeNode, TreeNode> nodeMap = new HashMap<>();
    int max = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        helper(0, root, null);
        List<TreeNode> listCur = map.get(max);
        Set<TreeNode> set = new HashSet<>(listCur);
        if(listCur.size() == 0) return root;
        else {
            while(set.size() > 1) {
                Set<TreeNode> parent = new HashSet<>();
                for(TreeNode node: set) {
                    parent.add(nodeMap.get(node));
                }
                set = parent;
            }

        }
        return set.iterator().next();
    }

    private void helper(int depth, TreeNode root, TreeNode parent) {
        if(root == null) return;
        else {
            nodeMap.put(root, parent);
            List<TreeNode> list = map.computeIfAbsent(depth, x -> new ArrayList<>());
            list.add(root);
            max = Math.max(max, depth);
            depth++;
            helper(depth, root.left, root);
            helper(depth, root.right, root);
        }
    }
}
// dfs + memoization
class Solution2 {
    public int depth(TreeNode root,HashMap<TreeNode,Integer> map){
        if(root == null ) return 0;
        if( map.containsKey(root) ) return map.get(root);
        int max = Math.max(depth(root.left,map),depth(root.right,map))+1;
        map.put(root,max);
        return max;
    }
    public TreeNode dfs(TreeNode root, HashMap<TreeNode,Integer> map){
        int left =  depth(root.left,map);
        int right = depth(root.right,map);
        if( left  == right ) return root;
        if( left > right ) return dfs(root.left,map);
        return dfs(root.right,map);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if( root == null ) return null;
        HashMap<TreeNode,Integer> map = new HashMap<>();
        depth(root,map);
        return dfs(root,map);
    }
}

class Solution3 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).r;
    }

    private Pair helper(TreeNode root) {
        if(root == null) return new Pair(root, 0);
        Pair r = helper(root.right), l = helper(root.left);
        int rd = r.d, ld = l.d;
        return new Pair(rd == ld ? root : rd > ld ? r.r: l.r, Math.max(rd, ld) + 1);
    }

    class Pair{
        int d;
        TreeNode r;
        Pair(TreeNode root, int depth) {
            r = root;
            d = depth;
        }
    }
}