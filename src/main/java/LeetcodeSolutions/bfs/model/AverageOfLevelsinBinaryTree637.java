package LeetcodeSolutions.bfs.model;

import LeetcodeSolutions.bfs.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsinBinaryTree637 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(averageOfLevels(root)); // [3.0, 14.5, 11.0]
    }


    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0, count = 0;
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur != null) {
                    sum += cur.val;
                    count++;
                }
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            result.add((double) sum / count);
        }
        return result;
    }
}
