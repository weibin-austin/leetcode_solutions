package DataStructure.tree.switchStructure;

import LeetcodeSolutions.bfs.node.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class serializeAndDeserializeBinaryTree297 {
    @Test
    public void basic_test2() {
        String preOrderString = "1,2,#,#,3,4,#,#,5,#,#";
//        List<String> strings = Arrays.asList(preOrderString.split(","));
//        for(String s : strings) System.out.println(s);
        Queue<String> q = new LinkedList<>(Arrays.asList(preOrderString.split(",")));
        TreeNode head = helper(q);
        System.out.println(serialize(head));
    }

    private TreeNode helper(Queue<String> q) {
        String s = q.poll();
        if(s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(q);
        root.right = helper(q);
        return root;
    }

    private String serialize(TreeNode root) {
        if(root == null) return "null";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }
}
