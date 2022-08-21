package LeetcodeSolutions.preSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *   https://www.lintcode.com/problem/391/description
 *   Given an list interval, which are taking off and landing time of the flight.
 *   How many airplanes are there at most at the same time in the sky?
 *
 *   Input: [(1, 10), (2, 3), (5, 8), (4, 7)]
 *   Output: 3
 *   Explanation:
 *   The first airplane takes off at 1 and lands at 10.
 *   The second ariplane takes off at 2 and lands at 3.
 *   The third ariplane takes off at 5 and lands at 8.
 *   The forth ariplane takes off at 4 and lands at 7.
 *   During 5 to 6, there are three airplanes in the sky.
 */
public class CountOfAirplanes {

    static class Interval {
        int start, end;
        Interval(){}
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Node{
        int time;
        int cost;
        Node(){}
        Node(int time, int cost){
            this.time = time;
            this.cost = cost;
        }
    }

    public static int countOfAirplanes(List<Interval> airplanes) {
        List<Node> list = new ArrayList<>();
        for(Interval i: airplanes) {
            list.add(new Node(i.start, 1));
            list.add(new Node(i.end, -1));
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.time != o2.time) {
                return o1.time - o2.time;
            }
            return o1.cost - o2.cost;
        });

        int res = 0;
        int count = 0;
        for (Node node : list) {
            count += node.cost;
            res = Math.max(res, count);
        }
        return res;
    }


    public static void main(String[] args) {
        //[(1, 10), (2, 3), (5, 8), (4, 7)]
        Interval interval1 = new Interval(1,10);
        Interval interval2 = new Interval(2,3);
        Interval interval3 = new Interval(5,8);
        Interval interval4 = new Interval(4,7);
        List<Interval> intervals = Arrays.asList(interval1, interval2, interval3, interval4);
        System.out.println("First test result: " +countOfAirplanes(intervals));


        //[(1, 2), (2, 3), (3, 4)]
        Interval interval11 = new Interval(1,2);
        Interval interval22 = new Interval(2,3);
        Interval interval33 = new Interval(3,4);
        Interval interval44 = new Interval(4,5);
        List<Interval> intervals1 = Arrays.asList(interval11, interval22, interval33, interval44);
        //res = 3
        System.out.println("Second test result: " + countOfAirplanes(intervals1));
    }
}
