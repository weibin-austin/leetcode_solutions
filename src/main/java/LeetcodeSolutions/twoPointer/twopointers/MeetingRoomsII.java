package LeetcodeSolutions.twoPointer.twopointers;

import java.util.*;

/*
      To understand why it works, first let’s define two events:
      Meeting Starts
      Meeting Ends

      Next, we acknowledge three facts:
      The numbers of the intervals give chronological orders
      When an ending event occurs, there must be a starting event has happened before that, where “happen before” is defined by the chronological orders given by the intervals
      Meetings that started which haven’t ended yet have to be put into different meeting rooms, and the number of rooms needed is the number of such meetings

      So, what this algorithm works as follows:

      for example, we have meetings that span along time as follows:

      |_____|
            |______|
      |________|
              |_______|
      Then, the start time array and end time array after sorting appear like follows:

      ||    ||
           |   |   |  |
      Initially, endsItr points to the first end event, and we move i which is the start event pointer. As we examine the start events, we’ll find the first two start events happen before the end event that endsItr points to, so we need two rooms (we magically created two rooms), as shown by the variable rooms. Then, as i points to the third start event, we’ll find that this event happens after the end event pointed by endsItr, then we increment endsItr so that it points to the next end event. What happens here can be thought of as one of the two previous meetings ended, and we moved the newly started meeting into that vacant room, thus we don’t need to increment rooms at this time and move both of the pointers forward.
      Next, because endsItr moves to the next end event, we’ll find that the start event pointed by i happens before the end event pointed by endsItr. Thus, now we have 4 meetings started but only one ended, so we need one more room. And it goes on as this.
 */
public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRoomsM3(intervals));
    }

    // 扫描线
    public static int minMeetingRoomsM1(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals) {
            list.add(new int[]{interval[0], 1});
            list.add(new int[]{interval[1], -1});
        }
        Collections.sort(list, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // 这里一定要注意，不是简单的对时间(list[0])进行sort，而是要判断是否两个时间是否相同，如果相同，根据cost排列，先放-1，再放1

        int count = 0, res = 0;
        for(int[] arr: list) {
            count += arr[1];
            res = Math.max(res, count);
        }
        return res;
    }

    //PriorityQueue
    public static int minMeetingRoomsM2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));                            // 将intervals以开始时间升序排序（由小到大）
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));   // 初始化一个pq，pq内的数据以结束时间升序排序（由小到大） pq内也是排在最前面的先出（最小的）
        heap.offer(intervals[0]);                                                              // 将第一个时间段放入pq
        for (int i = 1; i < intervals.length; i++) {                                           // !!! 从第2个intervals开始，所以只能用fori，不能用forEach
            if (heap.peek()[1] <= intervals[i][0]) heap.poll();                                // 如果第一个时段的结束时间 小于等于 第i个的开始时间，说明需要减少一个zoom。实现为pq内结束的时段弹出(poll)
            heap.offer(intervals[i]);                                                          // 之后再将第i个时段插入到pq中。必须先进行弹出操作
        }
        return heap.size();
    }
    /*
         关于pq解决meeting room的问题，为什么返回时要返回heap.size(),而不是在循环中用一个值eg: res = Math.max(res, heap.size())。
         是因为每次进入循环的interval和pq中的最小结束时间的interval比较，如果新进入的开始时间晚于这个最小时间，那么就会poll这个interval。
         因为每次循环只poll出那个结束时间最小的，所以heap可以一直保持整个loop过程最大需求的size。结果reture heap.size(); 就可以理解了
     */



    // 变种扫描线
    public static int minMeetingRoomsM3(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int count = 0;
        int endInterval = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[endInterval]) {
                count++;
            } else {
                endInterval++;
            }
        }
        return count;
    }
}