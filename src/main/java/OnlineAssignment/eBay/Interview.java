package OnlineAssignment.eBay;

import java.util.HashMap;
import java.util.Map;

public class Interview {
    public static void main(String[] args) {
        String[] arr = new String[]{"water", "fire", "water", "tree", "student", "book", "water","teacher", "book"};
        int solution = solution(arr);
        System.out.println(solution);
    }

    public static int solution(String[] arr){
        Map<String, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                int last = map.get(arr[i]);
                minDistance = Math.min(i - last, minDistance);
            }
            map.put(arr[i], i);
        }
        return minDistance;
    }
}
