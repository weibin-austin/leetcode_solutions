package LeetcodeSolutions.tree;

import LeetcodeSolutions.bfs.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
    /*
            1
           / \
          2   3



     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(threeOrder(root));

        System.out.println(inorder_iterative_helper(root)); // [2, 1, 3]
    }

    public static List<Integer> threeOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();

//        inorder_helper(root, res); // [2, 1, 3]
//
//        preorder_helper(root, res); // [1, 2, 3]

        postorder_helper(root, res); //[2, 3, 1]

        return res;
    }

    public static void inorder_helper(TreeNode root, List<Integer> res) {
        if(root == null) return;
        inorder_helper(root.left, res);
        res.add(root.val);
        inorder_helper(root.right, res);
    }

    public static List<Integer> inorder_iterative_helper(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


        public static void preorder_helper(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        preorder_helper(root.left, res);
        preorder_helper(root.right, res);
    }

    public static void postorder_helper(TreeNode root, List<Integer> res) {
        if(root == null) return;
        postorder_helper(root.left, res);
        postorder_helper(root.right, res);
        res.add(root.val);
    }
}
