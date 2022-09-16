package LeetcodeSolutions.bfs.model;

import LeetcodeSolutions.bfs.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    /*
            3
           / \
          9   20
              / \
             15  7
 */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root)); // [[3], [20, 9], [15, 7]]
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        boolean flag = false;       // 需要一个flag来标记
        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if(cur != null && !flag) level.addLast(cur.val);
                if(cur != null && flag) level.addFirst(cur.val); // 逆向操作 addFirst()

                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            result.add(level);
            flag = !flag;
        }
        return result;
    }
}
