package OnlineAssignment.bayonesolution.txt;

import java.util.ArrayList;
import java.util.List;

public class AnticlockTree {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static int height(Node root) {
        if(root == null) return 0;

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return Math.max(lHeight + 1, rHeight + 1);
    }

    static void leftToRight(Node root, int level, List<Integer> result) {
        if(root == null) return;

        if(level == 1) result.add(root.val);
        else if(level > 1) {
            leftToRight(root.left, level - 1, result);
            leftToRight(root.right, level -1, result);
        }
    }

    static void rightToLeft(Node root, int level, List<Integer> result) {
        if(root == null) return;

        if(level == 1)  result.add(root.val);
        else if(level > 1) {
            rightToLeft(root.right, level - 1, result);
            rightToLeft(root.left, level - 1, result);
        }
    }

    private static List<Integer> solution(Node root) {
        List<Integer> result = new ArrayList<>();
        int i = 1, j = height(root), flag = 0;
        while(i <= j) {
            if(flag == 0) {
                rightToLeft(root, i, result);
                i++;
                flag = 1;
            } else {
                leftToRight(root, j, result);
                j--;
                flag = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.right.right.right = new Node(9);

        List<Integer> solution = solution(root);
        System.out.println(solution);

        /*
                      1
                     / \
                    2   3
                  / \  / \
                 4  5 6   7
               /           \
              8             9

             1  4  5  6  7  3  2
         */
    }
}
