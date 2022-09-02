package OnlineAssignment.bayonesolution.txt;

public class AntiClockwiseBinaryTree {

    static class Node{
        Node left;
        Node right;
        int data;

        Node (int data) {
            this.data = data;
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

    static void leftToRight(Node root, int level) {
        if(root == null) return;

        if(level == 1) System.out.print(root.data + " ");
        else if (level > 1) {
            leftToRight(root.left, level - 1);
            leftToRight(root.right, level - 1);
        }
    }

    static void rightToLeft(Node root, int level) {
        if(root == null) return;
        if(level == 1) System.out.print(root.data + " ");
        else if(level > 1) {
            rightToLeft(root.right, level - 1);
            rightToLeft(root.left, level - 1);
        }
    }

    static void anticClockWiseSpiral(Node root) {
        int i = 1;
        int j = height(root);
        int flag = 0;

        while(i <= j) {
            if(flag == 0) {
                rightToLeft(root, i);
                flag = 1;
                i++;
            } else {
                leftToRight(root, j);
                flag = 0;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        anticClockWiseSpiral(root);

        /*
                      1
                     / \
                    2   3
                  / \  / \
                 4  5 6   7

             1  4  5  6  7  3  2
         */
    }

}
