package LeetcodeSolutions.preSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *    Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 *    return the minimum number of conference rooms required.
 *
 *    Example 1:
 *
 *    Input: intervals = [[0,30],[5,10],[15,20]]
 *    Output: 2
 *    Example 2:
 *
 *    Input: intervals = [[7,10],[2,4]]
 *    Output: 1
 *
 *    数飞机
 */
public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals1 = new int[][]{{0, 11}, {10, 15}, {9, 20}, {25, 30}};
        System.out.println(solution(intervals1));

    }

    public static int solution(int[][] intervals){
        List<int[]> list = new ArrayList<>();
        for(int[] interval: intervals){
            list.add(new int[]{interval[0], 1});
            list.add(new int[]{interval[1], -1});
        }

        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0]- b[0]);

        int res = 0, count = 0;
        for(int[] point: list) {
            count += point[1];
            res = Math.max(res, count);
        }
        return res;
    }
}
