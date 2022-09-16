package LeetcodeSolutions.bfs.topologicalSort;

import java.util.*;

public class CourseSchedule207 {
    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}};

        /*
          [[1,4],[2,4],[3,1],[3,2]]   [end, start]
          eg: [1,4] 如果想要上1课程，需要先上4课程
                【4】
               /   \
              V     V
            【1】   【2】
               \   /
                V V
               【3】

          构建graph (Map)时                              Map<Integer, List<Integer>> graph = new HashMap<>();
            key：start，                                graph.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            value：List<Integer> of ends
         */
        System.out.println(canFinish(numCourses, prerequisites)); // true
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int end = pre[0], start = pre[1];
            graph.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            inDegree[end]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int neighbor : graph.getOrDefault(cur, new ArrayList<>())) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) q.offer(neighbor);
            }
        }
        return count == numCourses;
    }
}
