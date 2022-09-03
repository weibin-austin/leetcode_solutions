package DataStructure.arrayANDstring;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysStreamApi {
    public static void main(String[] args) {
        int[] arr = new int[]{11,2,8,6,7,4,23,14,3};
        IntStream stream = Arrays.stream(arr); // IntStream = A sequence of primitive int-valued elements
        int sum = stream.sum();                // terminal operation: sum(), collect(), OptionalInt min(), OptionalInt max(), OptionalInt findFirst(), OptionalDouble average()
        stream.max().getAsInt();               // getAsInt() 方法是在 OptionalInt 类中
    }
}
