package LeetcodeSolutions.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode (int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List result = new ArrayList();
//        if(root == null) return result;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//    }
}
