package DataStructure.IntegerLearning;

import org.junit.jupiter.api.Test;

public class IntegerLearning {
    public static void main(String[] args) {
        int maxVal = Integer.MAX_VALUE; // 2147483647 = 2^31 - 1
        int minVal = Integer.MIN_VALUE; // -2147483648 = -2^31


        int rollMeOverMax= Integer.MAX_VALUE + 1; // -2147483648 = Integer.MIN_VALUE
        System.out.println(rollMeOverMax);

        int rollMeOverMin = Integer.MIN_VALUE - 1; // 2147483647 = Integer.MAX_VALUE
        System.out.println(rollMeOverMin);
    }

/*
        Given a signed 32-bit integer x, return x with its digits reversed.
        If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

        Input: x = 123
        Output: 321

        Input: x = -123
        Output: -321

 */
    public int reverse(int x) {
        if(x < 0) return 0 - helper(-x);
        else return helper(x);
    }

    private int helper(int x) {
        if(x == 0) return 0;

        int res = 0;
        while(x != 0) {
            int tmp = x % 10; // 余数
            int newRes = 10 * res + tmp; // 新result
            if((newRes - tmp) / 10 != res) return 0; // 如果新result已经越界，则直接返回0
            res = newRes;
            x /= 10;
        }

        return res;
    }

    @Test
    public void basic_test() {
        // String to Integer
        String s1 = "123";
        Integer i1 = Integer.parseInt(s1);
        System.out.println(i1);
    }
}
