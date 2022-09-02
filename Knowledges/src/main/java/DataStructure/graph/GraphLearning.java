package DataStructure.graph;

import java.util.*;

public class GraphLearning {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        for(int i = 0;i < 4; i++) {
            graph2.put(i, new ArrayList<>());
        }

        graph2.get(0).add(1);
        graph2.get(0).add(3);                          //  邻接表    0 -- 1
                                                       //           |    |
        graph2.get(1).add(0);                          //           3 -- 2
        graph2.get(1).add(2);

        graph2.get(2).add(1);
        graph2.get(2).add(3);

        graph2.get(3).add(0);
        graph2.get(3).add(2);

        System.out.println(graph2.toString()); // {0=[1, 3], 1=[0, 2], 2=[1, 3], 3=[0, 2]}

        boolean[][] graph3 = new boolean[4][4];
        for (int i = 0; i < 4; i++) {
            graph3[i][i] = true;
        }
        graph3[0][1] = true;
        graph3[0][3] = true;

        graph3[1][0] = true;
        graph3[1][2] = true;
                                                                        //      0      1      2      3
        graph3[2][1] = true;                                            //  0 [true, true, false, true]
        graph3[2][3] = true;                                            //  1 [true, true, true, false]
                                                                        //  2 [false, true, true, true]
        graph3[3][2] = true;                                            //  3 [true, false, true, true]
        graph3[3][0] = true;

        System.out.println("    0      1      2      3");
        for (int i = 0; i < 4; i++) {
            System.out.println(i + " " + Arrays.toString(graph3[i]));
        }


        ArrayList[] graph = new ArrayList[4];   // 不推荐在网页IDE
        for(int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();

        graph[0].add(1);
        graph[0].add(3);

        graph[1].add(2);
        graph[1].add(0);

        graph[2].add(1);                            //  邻接表    0 -- 1
        graph[2].add(3);                            //           |    |
                                                    //           3 -- 2
        graph[3].add(0);
        graph[3].add(2);

        System.out.println(graph[0].toString());
        System.out.println(graph[1].toString());





    }
}
