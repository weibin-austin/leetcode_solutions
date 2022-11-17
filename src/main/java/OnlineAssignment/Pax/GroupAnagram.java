package OnlineAssignment.Pax;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.*;

public class GroupAnagram {
    @Test
    public void basic_test() {
        List<String> list = Arrays.asList("cat", "arc","CAR","ball","aLLb","sun","Uns");
        List<List<String>> solution = solution1(list);
        solution.forEach(list1-> {
            System.out.println();
            list1.forEach(System.out::println);
        });
    }

    public List<List<String>> solution(List<String> list) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: list) {
            char[] arr = new char[26];
            for(char c: s.toCharArray()) {
                arr[Character.toLowerCase(c) - 'a']++;
            }
            String key = String.valueOf(arr);
            map.computeIfAbsent(key, x-> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> solution1(List<String> list) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            String cur = list.get(i);
            char[] arr = new char[26];
            for(int j = 0; j < cur.length(); j++) {
                arr[Character.toLowerCase(cur.charAt(j)) - 'a']++;
            }
            String key = String.valueOf(arr);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(cur);
        }
     for(Map.Entry<String, List<String>> entry: map.entrySet()){
         res.add(entry.getValue());
     }
     return res;
    }
}
