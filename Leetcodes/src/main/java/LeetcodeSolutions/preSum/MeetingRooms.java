package LeetcodeSolutions.preSum;

import java.util.Arrays;
import java.util.Comparator;

/**
 *   Given an array of meeting time intervals where intervals[i] = [starti, endi],
 *   determine if a person could attend all meetings.
 *
 *   Example 1:
 *
 *   Input: intervals = [[0,30],[5,10],[15,20]]
 *   Output: false
 *   Example 2:
 *
 *   Input: intervals = [[7,10],[2,4]]
 *   Output: true
 *
 *   Constraints:
 *
 *   0 <= intervals.length <= 10^4
 *   intervals[i].length == 2
 *   0 <= starti < endi <= 10^6
 */
public class MeetingRooms {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // 防止stack overflow
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);                 // 直接做差
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));    // 比较每个输入的第一个数

        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }
}
