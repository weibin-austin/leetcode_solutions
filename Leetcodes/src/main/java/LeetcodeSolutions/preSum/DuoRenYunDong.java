package LeetcodeSolutions.preSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 已知小猪每晚都要约好几个女生到他房间，每个女生i与小猪约好的时间有[si, ei]表示，
 * 其中si表示女生i进入小猪房间的时间，ei表示女生i离开小猪房间的时间，求小猪多人运动最多人的个数。
 * input：[[0, 30], [5, 10], [15, 20]]
 * output: 3 (包括小猪自己)
 */
public class DuoRenYunDong {
    static class Interval{
        int si;
        int ei;
        Interval(){}
        Interval(int si, int ei){
            this.si = si;
            this.ei = ei;
        }
    }

    static class Node {
        int time;
        int cost;
        Node(){}
        Node(int time, int cost){
            this.time = time;
            this.cost = cost;
        }
    }
    public static int solution(List<Interval> girls){
        List<Node> list = new ArrayList<>();
        for(Interval i: girls) {
            list.add(new Node(i.si, 1));
            list.add(new Node(i.ei, -1));
        }

        list.sort((o1, o2) -> {
            if (o1.time != o2.time) {
                return o1.time - o2.time;
            }
            return o1.cost - o2.cost;
        });

        int res = 0;
        int count = 0;
        for(Node node: list) {
            count += node.cost;
            res = Math.max(res, count);
        }

        return res + 1;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(0,30);
        Interval interval2 = new Interval(5,10);
        Interval interval3 = new Interval(15,30);
        List<Interval> intervals = Arrays.asList(interval1, interval2, interval3);
        System.out.println("Total people: " +solution(intervals));
    }
}
