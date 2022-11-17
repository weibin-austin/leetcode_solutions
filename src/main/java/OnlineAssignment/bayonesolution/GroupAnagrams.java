package OnlineAssignment.bayonesolution;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<List<String>> group = group(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"));
        List<List<String>> group1 = group(Arrays.asList("Rat", "Car", "Below", "art", "Cried", "Study", "nich", "Chin", "Grab", "atr", "dystu", "abrg", "Glean", "Desserts", "Tar", "Arc", "Elbow", "State", "Cider"));
        List<List<String>> group2 = group(Arrays.asList("Rat", "Car", "Below", "art", "Cried", "Study", "nich", "Chin", "Grab", "atr", "dystu", "abrg", "Glean", "Desserts", "Tar", "Arc", "Elbow", "State", "Cider"));

        for(List<String> strings : group2) {
            for(String s: strings) {
                System.out.print(s + ", ");
            }
            System.out.println(" ");
        }
    }
    /*
        idea:
           1. 输入：List<String>
           2. 要把每个String单独拿出来，然后比较这个String所包含的character(注意大小写不区分)的种类和个数是否完全相同(不考虑顺序)
           3. 如果相同，则把他们放到一个List<String>中
           4. 结果为一个List<List<String>>
           5. 如何判断每个String所包含的character是否在数量和种类上完全相同？
                哈希表：
                    key->唯一确定这个表内的String所包含的character具有相同的数量和种类
                    value->Strings = String所包含的character具有相同的数量和种类
           6. 对每一个String s，我们要将其转换成char[] arr
           7. 对应的key， 需要用String key = String.valueOf(arr);
           8. Map<String, List<String>> map = new HashMap<>();
           9. map.computeIfAbsent(key, x -> new ArrayList<>()).add(s);
           10. return new ArrayList<>(map.values());
    */
    public static List<List<String>> group(List<String> strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            char[] temp = new char[26];
            for(char c: s.toCharArray()) {
                temp[Character.toLowerCase(c) - 'a']++; // ASCII 0 -> 'NULL'       ASCII 1 -> 'SOH'
            }
            String key = String.valueOf(temp); //                        
            String key1 = temp.toString(); // 错误：每一个数组都是一个新的地址，地址toSting都是新的
//            System.out.println("key1: " + key1);
//            System.out.println("key: " + key);
//            if(!map.containsKey(key))
//                map.put(key, new ArrayList<>());
//            map.get(key).add(s);
            map.computeIfAbsent(key, x->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> group1 (List<String> strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String s : strs) {
            char[] temp = new char[26];
            for(char c : s.toCharArray()) {
                temp[Character.toLowerCase(c) - 'a']++;
            }
            String key = String.valueOf(temp);
//            if(!map.containsKey(key)) {
//                map.put(key, new ArrayList<>());
//            }
//            map.get(key).add(s);
            map.computeIfAbsent(key, x->new ArrayList<>()).add(s);
        }
        for(List<String> list : map.values()) {
            if(list.size() > 1) res.add(list);
        }
        return res;
    }

    public static List<List<String>> group2 (List<String> strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            char[] arr = new char[26];
            for(char c: s.toCharArray()) {
                arr[Character.toLowerCase(c) - 'a']++;
            }
            String key = String.valueOf(arr);
            map.computeIfAbsent(key, x -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
