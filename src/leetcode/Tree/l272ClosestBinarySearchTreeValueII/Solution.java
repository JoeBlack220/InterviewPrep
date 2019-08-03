package leetcode.Tree.l272ClosestBinarySearchTreeValueII;
import java.util.*;
import datastructure.TreeNode;
public class Solution {
    // iterate all the nodes and save them ito a PriorityQueue
    // according to their difference from the target
    // then extract the first k elements from the pq
    // time O(klogk + n) space O(k)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                if(i1 == i2) return 0;
                else if(Math.abs(i1 - target) < Math.abs(i2 - target)) return -1;
                else return 1;
            }
        });
        helper(root, pq);
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < k; ++i) {
            res.add(pq.poll());
        }
        return res;
    }
    private void helper(TreeNode root, PriorityQueue<Integer> pq) {
        if(root == null) return;
        pq.offer(root.val);
        helper(root.left, pq);
        helper(root.right, pq);
    }
}

class Solution2 {
    // maintain a deque that have size k
    // inorder traversal the tree can get a ascending sequence of the tree
    // space O(logN) timeO(N)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> dq = new LinkedList<>();

        inorder(root, dq);
        while (dq.size() > k) {
            if (Math.abs(dq.peekFirst() - target) > Math.abs(dq.peekLast() - target))
                dq.pollFirst();
            else
                dq.pollLast();
        }

        return new ArrayList<Integer>(dq);
    }

    public void inorder(TreeNode root, Deque<Integer> dq) {
        if (root == null) return;
        inorder(root.left, dq);
        dq.add(root.val);
        inorder(root.right, dq);
    }
}
