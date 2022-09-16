package DataStructure.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetLearning {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(){{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }};

        Set<String> set = new HashSet<>(list); // list 转换成 set

        System.out.println(set.add("hot")); // boolean set.add(value)
    }
}
