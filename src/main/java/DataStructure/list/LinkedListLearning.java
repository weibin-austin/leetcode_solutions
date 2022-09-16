package DataStructure.list;

import java.util.LinkedList;

public class LinkedListLearning {
    /*
         add() = addLast()
         因为元素都是像后添加
     */
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        // 特有的方法 addLast()
//        linkedList.addLast(2); // [2]
//        linkedList.addLast(1); // [2]->[1]
//        linkedList.addLast(0); // [2]->[1]->[0]

//        linkedList.addFirst(2); // [2]
//        linkedList.addFirst(1); // [1]->[2]
//        linkedList.addFirst(0); // [0]->[1]->[2]

        linkedList.add(2); // [2]
        linkedList.add(1); // [2]->[1]
        linkedList.add(0); // [2]->[1]->[0]
        System.out.println(linkedList); // [2, 1, 0]


    }
}
