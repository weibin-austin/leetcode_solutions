package LeetcodeSolutions.bfs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheMazeII505 {
    public static void main(String[] args) {
        int[][] maze = new int[][] {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0,4};
        int[] destination = new int[]{4,4};
        System.out.println(shortestDistance(maze, start, destination)); // 12
    }

    static public int[][] dirs = new int[][]{{0,1}, {0,-1}, {1, 0}, {-1, 0}};
    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for(int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dijkstra(maze, start, distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    public static void dijkstra(int[][] maze, int[] start, int[][] distance) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        q.offer(new int[]{start[0], start[1], 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] dir: dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1], count = 0;
//                int x = cur[0], y = cur[1], count = 0;
                while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                x -= dir[0];
                y -= dir[1];
                // count--;
                if(distance[cur[0]][cur[1]] + count < distance[x][y]) {
                    distance[x][y] = distance[cur[0]][cur[1]] + count;
                    q.offer(new int[]{x, y, distance[x][y]});
                }
            }
        }
    }

    public static int shortestDistance1(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for(int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dijkstra1(maze, start, destination, distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    public static void dijkstra1(int[][] maze, int[] start, int[] destination ,int[][] distance) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a->a[2])); // index0: x, index1: y, index2: step
        q.offer(new int[]{start[0], start[1], 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == destination[0] && cur[1] == destination[1]) return; // 提前判断结果是否是终点 如果是 提前终止
            for(int[] dir: dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1], count = 0;
                while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                x -= dir[0];
                y -= dir[1];
                // count--;
                if(distance[cur[0]][cur[1]] + count < distance[x][y]) {
                    distance[x][y] = distance[cur[0]][cur[1]] + count;
                    q.offer(new int[]{x, y, distance[x][y]});
                }
            }
        }
    }
}
