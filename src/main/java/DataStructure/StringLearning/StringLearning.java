package DataStructure.StringLearning;

import LeetcodeSolutions.bfs.node.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StringLearning {
    /**
     *  String is a non-primitive data type.
     *
     *  primitive data type: boolean, int, char, double, long, byte, short, float
     *  non-primitive data type: Strings, Arrays, Classes, Interfaces
     * @param args
     */
    public static void main(String[] args) {
        String str = new String("String1");
        System.out.println(str);
        str = new String(new char[]{'S','t','r','i','n','g','2'});
        System.out.println(str);

        String substring1 = str.substring(1); // [1, ∞)
        System.out.println(substring1);

        String substring2 = str.substring(1, 4); // [1, 4); -> "tri"
        System.out.println(substring2);

        String substring3 = str.substring(1, 2); // [1, 2); -> "t"
        System.out.println(substring2);

        char c = str.charAt(1); // 't'
        System.out.println(c);


        String s1 = "abc"; // "abc"          "abc"           "abc"         "aaa"
        String s2 = "cba"; // "cba" -> -2,   "dba" -> -3,    "aba" -> 2,   "aza" -> -3
                           // 'a'-'c'= -2    'a'-'d'= -3     'c'-'a'= 2    'a'-'z' =-25
        int i = s1.compareTo(s2); //
        System.out.println(i);

//        char ch = '1';
        String sss ="123";
//        System.out.println(Integer.valueOf(sss, 2));
        System.out.println(Integer.valueOf(sss));

    }

    @Test
    public void basic_test1() {
        String s = "aaabbbccc";
        System.out.println(swap(s));
    }

    private String swap(String s) {
        if(s.length() == 0) return s;

        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while(left <= right) {
            char tmp = chars[right];
            chars[right] = chars[left];
            chars[left] = tmp;

            left++;
            right--;
        }
        return String.valueOf(chars);
    }


    @Test
    public void basic_test2() {
        String str = "1,2,null,null,3,4,null,null,5,null,null";
        String[] strings = str.split(","); // Array of String[]
        for(String s : strings) System.out.println(s);

        Queue<String> q = new LinkedList<>(Arrays.asList(str.split(",")));
        TreeNode head = helper(q);
        System.out.println(serialize(head));
    }

    private TreeNode helper(Queue<String> q) {
        String s = q.poll();
        if(s.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(q);
        root.right = helper(q);
        return root;
    }

    private String serialize(TreeNode root) {
        if(root == null) return "null";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

}
