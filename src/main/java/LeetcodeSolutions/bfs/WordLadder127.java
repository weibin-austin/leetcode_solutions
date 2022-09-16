package LeetcodeSolutions.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder127 {
    /*
            Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
            Output: 5
            Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
     */
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dog","dot","lot","log","cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    /*
          核心思路：两个HashSet 一个从起点，一个从终点，石头堆下去，两个水波扩张到接触交点就是我们找到了link
                  每次Set交替扩张，每次扩张的都是比size较小的那个一个Set

            思路：1. 初始化两个Set， beginSet endSet
                 2。 初始化 visited Set，用来避免重复。 改变集合类型 wordList 为 wordSet
                 3。 首先判断目标 endWord 是否在wordSet中，如果不在 直接返回0
                 3。 初始化step，从1开始 （利用结果推断） 初始化 N = len(beginWord)
                 4。 将 beginWord 和 endWord 放入对应的 beginSet 和 endSet 中
                 5。 while(beginSet, endSet not Empty)
                 6。 初始化一个 nextSet 用来存放第一次查找后，满足条件的 nextWord
                 7。 将 beginWord 换成 char[] chs
                 8.  两个for loop，用26个字母替换beginWord中的每一个character
                 9。 首先保存char pre = chs[i]。因为后期需要把 chs[i] 变回原来的数组内容
                 10。 char pre = chs[i];  chs[i] = c; String nextWord = new String(chs);
                 11. 判断 nextWord 是否存在于 endSet中，如果存在直接返回 step + 1
                 12. 判断 nextWord是否存在于 worSet，并且标记 visited Set。然后将 nextWord 加入到 nextSet
                 13. chs[i] = pre 将原 chs[i] = pre. 改回原来的 char[] chs, 进行下一次的loop N * 26
                   结束这一层 word 的遍历 （因为每次的Set 中可能包含很多 word）
                 14. 结束 Set 中全部 word 的遍历后，将比较nextSet 和 endSet的大小
                     nextSet是我 beginSet得到的下一层(上一层)的结果Set，如果我的 nextSet.size() > endSet.size()
                     这说明如果我继续遍历 nextSet 中全部的 word， 我会遍历多次word.
                     但如果下次我遍历 endSet 中的 word，相对而言，就会少遍历几次
                     所以我们让 beginSet = endSet； endSet = nextSet;
                     把下一次要遍历的 endSet 当作beginSet。 我得到的 nextSet 作为我的目标 endSet

                     else : 如果我的nextSet.size() <= endSet.size()
                     我就将nextSet 当作我下一次遍历的 beginSet -> beginSet = nextSet;
                     我的 endSet 保持不变

                 15. step++; 在while内增加步数

                 return 0; 是因为
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)) return 0;
        int step = 1, N = beginWord.length();

        beginSet.add(beginWord);
        endSet.add(endWord);

        while(!beginSet.isEmpty() && ! endSet.isEmpty()) {

            Set<String> nextSet = new HashSet<>();

            for(String word: beginSet) { // 从beginSet中的每一个word展开，看看是否到达endSet

                char[] chs = word.toCharArray();

                for(int i = 0; i < N; i++) {
                    for(char c = 'a'; c <= 'z'; c++) {

                        char pre = chs[i];
                        chs[i] = c;
                        String nextWord = new String(chs);

                        if(endSet.contains(nextWord)) return step + 1;
                        if(visited.add(nextWord) && wordSet.contains(nextWord)) nextSet.add(nextWord);

                        chs[i] = pre;
                    }
                }
            }
            if(nextSet.size() > endSet.size()){ // 当我们rolling HashSet的时候，我们需要将nextSet 和 endSet 做contest的操作，比较哪一个更小 我们查找的word最少
                beginSet = endSet;              // 核心的优化，我们选择较小的一段进行展开
                endSet = nextSet;
            }
            else beginSet = nextSet;

            step++;
        }
        return 0;
    }
}
