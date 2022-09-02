package LeetcodeSolutions.arrays;

import java.util.HashMap;

/**
 * @author Weibin Sun
 * @create 8/2/22 10:48 PM
 */
class Anagram {
    public static void main(String[] args) {
        String s = "acca";
        String t = "aaac";
        boolean anagram = isAnagram1(s, t);
        System.out.println(anagram);
    }

    /**
     *
     * @param s source String
     * @param t target String
     * @return ture or false if s and t are Anagrams
     */
    public static boolean isAnagram1(String s, String t) {

        if(s.length() != t.length()) return false;
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }

        for(int n : arr) {
            if(n != 0) return false;
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> maps = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            maps.put(s.charAt(i), maps.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            if(!maps.containsKey(t.charAt(i))){
                return false;
            }

            maps.put(t.charAt(i), maps.get(t.charAt(i)) - 1);

            if(maps.get(t.charAt(i)) < 0){
                return false;
            }
        }
        return true;
    }
}
