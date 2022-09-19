package LeetcodeSolutions.bfs;

import LeetcodeSolutions.bfs.node.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseOddLevelsofBinaryTree2451 {
    @Test
    public void basic_test() {

    }

    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) q.offer(root);
        boolean reverse = false;
        while(!q.isEmpty()) {
            int size = q.size();
            if(reverse) {
                Deque<Integer> stack = new ArrayDeque<>();

                for(int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    stack.push(cur.val);
                    q.offer(cur);
                }

                for(int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    cur.val = stack.pop();
                    if(cur.left != null) {
                        q.offer(cur.left);
                        q.offer(cur.right);
                    }
                }
                int left = 0, right = stack.size() - 1;
                while(left < right) {

                }
                reverse = false;
            } else {
                for(int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    if(cur.left != null && cur.right != null) {
                        q.offer(cur.left);
                        q.offer(cur.right);
                    }
                }
                reverse = true;
            }
        }
        return root;
    }
}
