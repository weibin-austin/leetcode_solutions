package DataStructure.queueANDstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeLearning {
    /*

    deque.offerFirst(num)                                                             deque.offerFirst(num) 
                   |                                                                    |
               ____V_____ __________ __________ __________ __________ __________ _______V___
              |          |          |          |          |          |          |          |
      Front   |    0     |   1      |  2       |   3      |     4    |  5       |    6     |  Rear
     (First)  |__________|__________|__________|__________|__________|__________|__________| (Last)
                   |                                                                    |
                   V                                                                    V
     deque.pollFirst()                                                                deque.pollLast()

       一般我们不在deque中使用 deque.offer(num) AND deque.peek() AND deque.poll()
       EVEN deque.offer() = deque.offerLast()
            deque.peek() = deque.peekFirst()
            deque.poll() = deque.pollFirst()

        容易混淆，所以每个方法明确First() 还是 Last()
     */
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(0); //  [0]
        deque.offerLast(1);  //  [0, 1]
        deque.offerFirst(-1); // [-1, 0, 1]
        deque.offerLast(2);  //  [-1, 0, 1, 2]

        System.out.println(deque.peekFirst()); //    [-1, 0, 1, 2]
                                               //      ^
        System.out.println(deque.peekLast());  //    [-1, 0, 1, 2]
                                               //               ^

        System.out.println(deque.pollFirst()); // return -1 
                                               // deque = [0, 1, 2]

        System.out.println(deque.pollLast()); // return 2
                                               // deque = [0, 1]
        deque.offer(100); // deque.offerLast(100);
        System.out.println(deque.peekLast());
        System.out.println(deque.pollLast());


    }
}
