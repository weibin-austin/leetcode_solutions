package LeetcodeSolutions.dfs;

import LeetcodeSolutions.bfs.node.TreeNode;
import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
          1
           \
            2
           /
          3
 */
public class BinaryTreeInorderTraversal94 {

    @Test
    public void Recursion() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root)); // [1, 3, 2]
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root) {

        if (root.left != null) helper(res, root.left);
        res.add(root.val);
        if (root.right != null) helper(res, root.right);

    }

    @Test
    public void Iterative() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        TreeNode root = node6;

        root.left = node2;
        root.right = node7;

        node2.left = node1;
        node2.right = node4;

        node7.right = node8;

        node4.left = node3;
        node4.right = node5;
        /*         6                      |             |            |             |              |             |             |             |
                  / \                     |             |            |             |              |             |             |             |
                2    7                    |             |            |             |              |             |             |             |
              /  \    \                   |             |            |             |              |             |             |             |
             1   4     8                  |             | -------->  |             |    --------> |             | -------->   |             |
                / \                       |             |            |             |              |             |             |             |
               3   5                      |             |            |             |              |    1        |             |    (1)      |
                                          |             |            |    2        |              |    2        |             |    2        |
                                          |    6        |            |    6        |              |    6        |             |    6        |
                                          --------------             --------------               --------------              --------------
                                          res = []                     res = []                      res = []                    res = [1]

                                          |             |             |             |             |             |             |             |
                                          |             |             |             |             |             |             |             |
                                          |             |             |             |             |             |             |             |
                                          |             |             |             |             |             |             |             |
                              -------->   |             | -------->   |             | -------->   |    3        | -------->   |   (3)       |
                                          |             |             |    4        |             |    4        |             |    4        |
                                          |   (1)       |             |   (1)       |             |   (1)       |             |   (1)       |
                                          |   (2)       |             |   (2)       |             |   (2)       |             |   (2)       |
                                          |    6        |             |    6        |             |    6        |             |    6        |
                                          --------------              --------------              --------------              --------------
                                             res = [1,2]                res = [1,2]                 res = [1,2]                res = [1,2,3]

                                         |             |             |             |                |             |                |             |
                                         |             |             |             |                |             |                |             |
                                         |             |             |             |                |             |                |             |
                                         |             |             |    5        |                |   (5)       |                |   (5)       |
                             -------->   |   (3)       | -------->   |   (3)       |    -------->   |   (3)       |    -------->   |   (3)       |
                                         |   (4)       |             |   (4)       |                |   (4)       |                |   (4)       |
                                         |   (1)       |             |   (1)       |                |   (1)       |                |   (1)       |
                                         |   (2)       |             |   (2)       |                |   (2)       |                |   (2)       |
                                         |    6        |             |    6        |                |    6        |                |   (6)       |
                                         --------------              --------------                 --------------                 --------------
                                         res = [1,2,3,4]             res = [1,2,3,4]               res = [1,2,3,4,5]             res = [1,2,3,4,5,6]

                                        |             |               |             |                     |             |                    |             |
                                        |             |               |             |                     |    8        |                    |   (8)       |
                                        |    7        |               |   (7)       |                     |   (7)       |                    |   (7)       |
                                        |   (5)       |               |   (5)       |                     |   (5)       |                    |   (5)       |
                            -------->   |   (3)       |   -------->   |   (3)       |         -------->   |   (3)       |        -------->   |   (3)       |
                                        |   (4)       |               |   (4)       |                     |   (4)       |                    |   (4)       |
                                        |   (1)       |               |   (1)       |                     |   (1)       |                    |   (1)       |
                                        |   (2)       |               |   (2)       |                     |   (2)       |                    |   (2)       |
                                        |   (6)       |               |   (6)       |                     |   (6)       |                    |   (6)       |
                                        --------------                --------------                      --------------                     --------------
                                      res = [1,2,3,4,5,6]           res = [1,2,3,4,5,6,7]               res = [1,2,3,4,5,6,7]              res = [1,2,3,4,5,6,7,8]
         */
                
        System.out.println(iterative(root)); // [1, 2, 3, 4, 5, 6, 7, 8]
    }

    public List<Integer> iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while(root != null) {
                stack.push(root);
                root = root.left; // 找到最左端的叶子节点，当root == null的时候跳出循环，此时栈内存放的是最左端的叶子节点
            }

            root = stack.pop();  // stack弹出最左端的叶子节点，
            res.add(root.val);   // 叶子节点value加入答案List中，满足 '左根右'的中序遍历顺序
            root = root.right;   // 检查当前叶子节点是否含有右子树，如果有，执行内层while循环，找到该右子树的最左端，并将最左端的节点全部push到stack中
                                 // 如果没有子树，只有一个本身的节点，则执行一次内层while，将右子树push到stack中，随后弹出加入到结果List中
        }                        //用stack 模拟仿真DFS的过程 先从最左端 一条路走到黑，然后去弹出本身，然后再找右孩子，如果右孩子有左子树，重复把左子树一条路走到黑。。so on so forth
        return res;
    }
}
