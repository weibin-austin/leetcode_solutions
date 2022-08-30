package DataStructure;

import java.util.Stack;

public class StackLearning {
    /**
     *          Stack<Integer> stack = new Stack<>();
     *          stack.push(1);
     *          stack.pop();
     *          stack.peek()
     *          stack.isEmpty();
     *
     * @param args
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.add(3);

        System.out.println(stack.peek()); // return 3
        System.out.println(stack.pop()); // return 3
        System.out.println(stack.pop()); // return 2
        System.out.println(stack.pop()); // return 1

        System.out.println("Is Stack Empty? : " + stack.isEmpty());
    }
}
