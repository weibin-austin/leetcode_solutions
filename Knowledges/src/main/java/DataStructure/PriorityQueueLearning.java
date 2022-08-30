package DataStructure;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueLearning {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(a,b)); // minHeap
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder()); // minHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap


        pq.offer(2); // O(logn)
        pq.add(0); // O(logn)
        pq.add(1);

        pq.peek(); // return 0, O(1)
        pq.poll(); // return 0, O(logn)
        pq.poll(); // return 1, O(logn)

        pq1.offer(2); // O(logn)
        pq1.add(0); // O(logn)
        pq1.add(1);

        System.out.println(pq1.peek()); // return 0, O(1)
        System.out.println(pq1.poll()); // return 0, O(logn)
        System.out.println(pq1.poll()); // return 1, O(logn)


        maxHeap.offer(2); // O(logn)
        maxHeap.add(0); // O(logn)
        maxHeap.add(1);

        maxHeap.peek(); // return 2, O(1)
        System.out.println(maxHeap.poll()); // return 2, O(logn)
        System.out.println(maxHeap.poll()); // return 1, O(logn)

    }
}
