package DataStructure.queueANDstack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLearning {
    /**
     *
     *        Queue<Integer> queue = new LinkedList<>();
     *        queue.offer(num);
     *        queue.poll();
     *        queue.peek();
     *        queue.isEmpty();
     *
     * @param args
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.add(3);

        System.out.println(queue.peek()); //return 1
        System.out.println(queue.poll()); //return 1
        System.out.println(queue.poll()); //return 2
        System.out.println(queue.remove()); //return 3
        System.out.println(queue.poll()); //return null
//        System.out.println(queue.remove()); //throw NoSuchElementException

        System.out.println("Is Queue empty? : " + queue.isEmpty());
    }
}
