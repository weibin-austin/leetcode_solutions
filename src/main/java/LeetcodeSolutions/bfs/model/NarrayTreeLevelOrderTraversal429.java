package LeetcodeSolutions.bfs.model;

import LeetcodeSolutions.bfs.node.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NarrayTreeLevelOrderTraversal429 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if(cur != null) level.add(cur.val);
                if(cur.children != null) {
                    for(Node node : cur.children) { // 下一层的元素增加到queue中 需要用到for loop遍历
                        queue.offer(node);
                    }
                }
            }
            result.add(level);
        }
        return result;
    }


}
