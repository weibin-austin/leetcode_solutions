package OnlineAssignment.eBay;

import java.util.HashMap;
import java.util.Map;

public class MergeString {
    public static void main(String[] args) {


    }

    public static String merge(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c: s1.toCharArray()) {
            if(!map1.containsKey(c)) {
                map1.put(c, 1);
            } else {
                map1.put(c, map1.get(c) + 1);
            }
        }

        for(char c: s2.toCharArray()) {
            map2.getOrDefault(c, 1);
        }
        return new String();
    }
}
class Solution3{
    public static void main(String[] args) {
        String s1 = "dce", s2 = "cccbd";
        System.out.println(mergeTwoString(s1, s2));
    }
    public static String mergeTwoString(String str1, String str2){
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();

        for(int x = 0; x < str1.length(); x++)
            map1.put(str1.charAt(x), map1.getOrDefault(str1.charAt(x), 0) + 1);

        for(int x = 0; x < str2.length(); x++)
            map2.put(str2.charAt(x), map2.getOrDefault(str2.charAt(x), 0) + 1);

        int i = 0, j = 0;

        while(i < str1.length() || j < str2.length()){
            if(i == str1.length()) {
                sb.append(str2.charAt(j++));
            }
            else if(j == str2.length()){
                sb.append(str1.charAt(i++));
            }
            else{
                if(map1.get(str1.charAt(i)) > map2.get(str2.charAt(j))){
                    sb.append(str2.charAt(j++));
                }
                else if (map1.get(str1.charAt(i)) < map2.get(str2.charAt(j))){
                    sb.append(str1.charAt(i++));
                }
                else{
                    if(str1.charAt(i) <= str2.charAt(j))
                        sb.append(str1.charAt(i++));
                    else
                        sb.append(str2.charAt(j++));
                }

            }
        }
        return sb.toString();
    }
}