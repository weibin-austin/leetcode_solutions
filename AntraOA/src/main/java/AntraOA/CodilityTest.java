package AntraOA;

import java.util.*;

public class CodilityTest {
    static Map<String, Integer> map = new HashMap();
    public static void main(String[] args) {
        map.put("Mon", 0);
        map.put("Tue", 1);
        map.put("Wed", 2);
        map.put("Thu", 3);
        map.put("Fri", 4);
        map.put("Sat", 5);
        map.put("Sun", 6);

        System.out.println(solution("Mon", 6));
        System.out.println(solution("Tue", 0));
    }

    private static String solution(String s, int k) {
        int tmp = map.get(s);
        int num = tmp + k;
        int res = num % 7;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == res) return entry.getKey();
        }
        return "Mon";
    }
}
